package src.util;

import java.util.Scanner;

import src.board.Board;
import src.board.Square;


public class Input {
    private final String alphabetString = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

    public int inputForMenu(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String inputCoordinate(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private boolean inputValidation(Board board, String stringCoordinate){
        if(validateCoordinateInput(board, stringCoordinate, 0) ||
                validateCoordinateInput(board, stringCoordinate, 1) ||
                validateCoordinateStatus(board, stringCoordinate)){
            return false;
        }else{
            return true;
        }
    }

    private boolean validateCoordinateInput(Board board, String stringCoordinate, int rowOrColumnDetector){
        return toCoordinates(stringCoordinate)[rowOrColumnDetector] > board.getSize();
    }

    private boolean validateCoordinateStatus(Board board, String stringCoordinate){
        int[] shootCoordinate = toCoordinates(stringCoordinate);
        Square square = board.getSquare()[shootCoordinate[0]][shootCoordinate[1]];
        return square.getStatus() != "MISS" || square.getStatus() != "HIT";
    }

    @Override
    public String toString(int[] intArrayCoordinate) {
        String coordinate;
        int row = intArrayCoordinate[0] + 1;
        int column = intArrayCoordinate[1];
        String columnLetter= String.valueOf(alphabetString.charAt(column));
        String rowNumber = String.valueOf(row);
        coordinate = columnLetter + rowNumber;
        return coordinate;
    }
    public int[] toCoordinates(String stringCoordinate) {
        int row = Integer.parseInt((stringCoordinate.substring(1)))-1;
        int columnNumber = alphabetString.indexOf(stringCoordinate.charAt(0));
        return new int[] {row, columnNumber};
    }

    public String askForName(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
