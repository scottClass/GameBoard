
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *A class that represents a 8x8 game board like used in checkers
 * @author johns6971
 */
public class GameBoard extends JComponent implements MouseListener{
    
    private Color[][] grid = new Color[8][8];
    private String message = "";
    private JFrame window;
    private final int TILE_SIZE = 100;
    private Coordinate click = null; 
    
    /**
     * creates a brand new empty 8x8 board
     */
    public GameBoard() {
        // Sets all positions to be null
        for(int row = 0; row < 8; row ++) {
            for(int col = 0; col < 8; col ++) {
                grid[row][col] = null;
            }
        }
        // Create the frame to display the board
        window = new JFrame("Game Board");
        // Add the board to the frame
        window.add(this);
        // Make the frame visible
        window.setVisible(true);
        //set the size
        this.setPreferredSize(new Dimension(8 * TILE_SIZE + 50, 8 * TILE_SIZE + 100));
        window.pack();
        //set the X
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add the mouse listener
        this.addMouseListener(this);
    }
    
    /**
     * Drawing the game board
     * @param g Graphics object to draw with
     */
    @Override
    public void paintComponent(Graphics g) {
        for(int row = 0; row < 8; row ++) {
            for(int col = 0; col < 8; col ++) {
                //alternate colours of the grid
                if((row + col)%2 == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.black);
                }
                //draws single spot
                g.fillRect(col * TILE_SIZE + TILE_SIZE/4, row * TILE_SIZE + TILE_SIZE/4, TILE_SIZE, TILE_SIZE);
                //draw a piece
                if(grid[row][col] != null) {
                    g.setColor(grid[row][col]);
                    g.fillOval(col * TILE_SIZE + TILE_SIZE/2, row * TILE_SIZE + TILE_SIZE/2, TILE_SIZE / 2, TILE_SIZE / 2);
                }
            }
        }
        g.drawString(message, TILE_SIZE/4, TILE_SIZE * 8 + TILE_SIZE/2);
    }
    
    /**
     * Place a piece of a specific Colour on the board
     * @param row the row at which to place the piece
     * @param col the column at which to place the piece
     * @param Colour the Colour to make the piece
    **/
    public void putPiece(int row, int col, Color Colour) {
        grid[row][col] = Colour;
        repaint();
    }
    /**
     * 
     * @param row the row at which to remove the piece
     * @param col the column at which to remove the piece
     */
    public void removePiece(int row, int col) {
        grid[row][col] = null;
        repaint();
    }
    /**
     * 
     * Remove all pieces from the board
     */
    public void clearBoard() {
        for(int row = 0; row < 8; row ++) {
            for(int col = 0; col < 8; col ++) {
                grid[row][col] = null;
            }
        }
        repaint();
    }
    /**
     * Displays a message in the game area
     * @param theMessage the message to display
     */
    public void setMessage(String theMessage) {
        message = theMessage;
        repaint();
    }
    
    public void printBoard() {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if(grid[row][col] == Color.red) {
                    System.out.print("R  ");
                } else if(grid[row][col] == Color.blue) {
                    System.out.print("B  ");
                }else if(grid[row][col] == null) {
                    System.out.print("_  ");
                }
            }
            System.out.println("");
        }
        System.out.println(message);
        System.out.println("");
    }

    public Coordinate getClick() {
        //wipe out previous click
        click = null;
        //wait for a click to happen
        while(click == null) {
            //do nothing
            try {
                Thread.sleep(1);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return click;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Get x and y of click
        //shift them so the top and left boarders are gone
        int x = e.getX() - TILE_SIZE/4;
        int y = e.getY() - TILE_SIZE/4;
        
        //get the row and column of the click
        int row = y / TILE_SIZE;
        int col = x / TILE_SIZE;
        
        //validate the coordinate
        if(row >= 0 && row <= 7 
                && col >= 0 && col <= 7) {
            click = new Coordinate(row,col);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}
