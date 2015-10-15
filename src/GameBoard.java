
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
public class GameBoard extends JComponent{
    
    private Color[][] grid = new Color[8][8];
    private String message = "";
    private JFrame window;
    
    private final int TILE_SIZE = 100;
    
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
    }
    
    /**
     * Drawing the game board
     * @param g Graphics object to draw with
     */
    @Override
    public void paintComponent(Graphics g) {
        for(int row = 0; row < 8; row ++) {
            for(int col = 0; col < 8; col ++) {
                g.drawRect(row * TILE_SIZE + 25, col * TILE_SIZE + 25, TILE_SIZE, TILE_SIZE);
            }
        }
    }
    
    /**
     * Place a piece of a specific Colour on the board
     * @param row the row at which to place the piece
     * @param col the column at which to place the piece
     * @param Colour the Colour to make the piece
    **/
    public void putPiece(int row, int col, Color Colour) {
        grid[row][col] = Colour;
    }
    /**
     * 
     * @param row the row at which to remove the piece
     * @param col the column at which to remove the piece
     */
    public void removePiece(int row, int col) {
        
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
    }
    /**
     * Displays a message in the game area
     * @param theMessage the message to display
     */
    public void setMessage(String theMessage) {
        message = theMessage;
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
    }
    
}
