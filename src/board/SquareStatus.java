package src.board;

public class SquareStatus {
    EMPTY('~'),
        SHIP('#'),
            HIT('H'),
                MISS('M');

    SquareStatus(char symbol){

    }
}
