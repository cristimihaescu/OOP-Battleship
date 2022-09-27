package src.game;

import src.board.Board;
import src.board.Square;
import src.board.SquareStatus;
import src.util.Display;
import src.util.Input;

public class Game {
    private final Display display = new Display();
    private final Input input = new Input();

    public void playRound() {}

    public boolean hasWon(){
        return false;
    }
}
