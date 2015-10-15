
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *A class that represents a 8x8 game board like used in checkers
 * @author johns6971
 */
public class GameBoard {
    
    private Color[][] grid = new Color[8][8];
    private String message = "";
    /**
     * creates a brand new empty 8x8 board
     */
    public GameBoard() {
        //Sets all positions to be null
        for(int row = 0; row < 8; row ++) {
            for(int col = 0; col < 8; col ++) {
                grid[row][col] = null;
            }
        }
    }
    
    /**
     * Place a piece of a specific Colour on the board
     * @param row the row at which to place the piece
     * @param col the column at which to place the piece
     * @param Colour the colour to make the piece
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
