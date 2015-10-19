
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johns6971
 */
public class TestBoard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameBoard board = new GameBoard();

        int pRow = 5;
        int clicked = 0;
        while(true) {
            //wait for the user to click
            Coordinate c = board.getClick();
            clicked++;
            int row = c.getRow();
            int col = c.getCol();
            //put a piece where they clicked
            board.putPiece(row, col, Color.blue);
            board.setMessage("You have clicked " + clicked + " times");
        }
        
    }
}
