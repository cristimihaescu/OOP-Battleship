package src.board;

public class SquareStatus {
    EMPTY('~'),
        SHIP('#'),
            HIT('H'),
                MISS('M');

    char symbol;
    SquareStatus(char symbol){
        this.symbol = symbol;
    }
}
