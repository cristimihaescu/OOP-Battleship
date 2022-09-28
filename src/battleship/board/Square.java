package src.battleship.board;

public class Square {

    private final int x;
    private final int y;
    private SquareStatus status;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        status = SquareStatus.EMPTY;
    }

    public SquareStatus getStatus() {
        return status;
    }

    public void setStatus(SquareStatus status) {
        this.status = status;
    }

    @Override
    public java.lang.String toString() {
        return status.toString();
    }
}