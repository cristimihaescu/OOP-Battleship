package src.game;

import src.board.Board;
import src.board.Square;
import src.board.SquareStatus;
import src.util.Display;
import src.util.Input;

public class Game {
    public void playRound(int activePlayer, Board board) {
        Display display = new Display();
        display.turn(activePlayer);
        Input input = new Input();
        String shootArea = input.inputCoordinate();
        int[] shootCoordinates = input.toCoordinates(shootArea);
        int row = shootCoordinates[0];
        int col = shootCoordinates[1];
        Square square = board.getSquare()[row][col];
        String status = square.getStatus();
        switch (status) {
            case "EMPTY":
                square.setSquareStatus(SquareStatus.MISS);
            case "SHIP":
                square.setSquareStatus(SquareStatus.HIT);
            default:
                break;
        }
        if (hasWon(activePlayer)) {
            display.printResults();
        }

    }

    public boolean hasWon(int activePlayer) {
        return false;
    }
}
