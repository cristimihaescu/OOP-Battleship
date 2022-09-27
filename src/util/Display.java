package src.util;
import src.board.Board;

import java.util.Arrays;
import src.board.Board;
import src.ship.Ship;
import src.ship.ShipType;

public class Display {
    public void printMenu(){
        System.out.println(
                "Choose an option: \n"+
                "1.Play game \n"+
                "2.Quit");
    }

    public void askForCoordinates(){
        System.out.println("Enter the coordinates: \n");
    }

    public void askForCoordinates(ShipType type){
        String shipTypeName = type.getName();
        String shipLength = type.getSize();
        System.out.println("You will place a" + shipTypeName + (shipLength) + "Enter the starting coordinate !\n" );
    }

    public void printBoard(Board board) {
        StringBuilder output = new StringBuilder();
        String tableHeader = createTableHeader(board.getSize());
        for (int row = 0; row < board.getSize(); row++) {
            output.append(row + 1);
            if (row + 1 < 10) output.append(" ");
            for (int column = 0; column < board.getSize(); column++) {
                if (board[row][column].getSquareStatus.equals(EMPTY)) output.append("|_").append("__");
                else {
                    if (board[row][column].getSquareStatus.equals(SHIP))) {
                        output.append("|_").append("#_");
                    } else if (board[row][column].getSquareStatus.equals(HIT))){
                        output.append("|_").append("H_");
                    } else if (board[row][column].getSquareStatus.equals(MISS))) {
                        output.append("|_").append("M_");
                    }
                }
            }
            output.append("|\n");
        }
        System.out.println(tableHeader);
        System.out.println(output);
    }

    private String createTableHeader(int boardSize) {
        StringBuilder tableHeader = new StringBuilder();
        tableHeader.append("Player ").append(activePlayer).append("'s turn!\n").append("    ");
        for (int index = 0; index < boardSize; index++) {
            tableHeader.append(alphabetString.charAt(index)).append("   ");
        }
        return tableHeader.toString();
    }

    public void printGameplay(){
        System.out.println("");
    }

    public void printResults(){
        System.out.println("");
    }

    public void askForName(){
        System.out.println("Enter your name:\n");
    }
}
