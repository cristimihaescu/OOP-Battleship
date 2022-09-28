package src.util;
import src.board.Board;

import src.board.Board;
import src.ship.Ship;
import src.ship.ShipType;
import src.board.SquareStatus;
import src.game.Player;

public class Display {

    private final String alphabetString = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
    public void printMenu(){
        System.out.println(
                "Choose an option: \n"+
                "1.Play game \n"+
                "2.Quit\n");
    }

    public void askForCoordinates(){
        System.out.println("Enter the coordinates: \n");
    }

    public void askForCoordinates(ShipType type){
        String shipTypeName = type.getName();
        int shipLength = type.getSize();
        System.out.println("You will place a" + shipTypeName + (shipLength) + "Enter the starting coordinate !\n" );
    }

    public void printBoard(Board board, Player activePlayer) {
        StringBuilder output = new StringBuilder();
        String tableHeader = createTableHeader(board.getSize(), activePlayer);
        for (int row = 0; row < board.getSize(); row++) {
            output.append(row + 1);
            if (row + 1 < 10) output.append(" ");
            for (int column = 0; column < board.getSize(); column++) {
                if (board.getBoard()[row][column].getSquareStatus() == SquareStatus.EMPTY)
                    output.append("|_").append("__");
                else {
                    if (board.getBoard()[row][column].getSquareStatus() == SquareStatus.SHIP) {
                        output.append("|_").append("#_");
                    } else if (board.getBoard()[row][column].getSquareStatus() == SquareStatus.HIT){
                    output.append("|_").append("H_");
                    } else if (board.getBoard()[row][column].getSquareStatus() == SquareStatus.MISS) {
                        output.append("|_").append("M_");
                    }
                }
            }
            output.append("|\n");
        }
        System.out.println(tableHeader);
        System.out.println(output);
    }

    private String createTableHeader(int boardSize, Player activePlayer) {
        StringBuilder tableHeader = new StringBuilder();
        tableHeader.append("Player ").append(activePlayer.getName()).append("'s turn!\n").append("    ");
        for (int index = 0; index < boardSize; index++) {
            tableHeader.append(alphabetString.charAt(index)).append("   ");
        }

        return tableHeader.toString();
    }
    public void printGameplay() {
        System.out.println("");
    }
    public void printResults() {
        System.out.println("");
    }
    public void askForName() {
        System.out.println("Enter a name: \n");
    }

    public void turn(Player activePlayer) {
    }

    public void askForOrientation() {
        System.out.println("Please choose the orientation: ");
    }

    public void clearConsole() {
        System.out.flush();
    }

    public void askForBoardSize() {
        System.out.println("Please choose a board size !");
    }
}