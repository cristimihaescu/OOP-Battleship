package src.board;


import src.ship.Ship;

public abstract class Board{
        private final int size;

        public Board(int size){
            this.size = size;
    }

        public boolean isPlacementOkay(Ship ship, Board board) {
            boolean falseOccurence = false;
            boolean allOkay = false;
            for (Square square : ship.getPlacement()) {
                Square checkNorth;
                Square checkSouth;
                Square checkEast;
                Square checkWest;
                try {
                    checkNorth = board.getBoard()[square.getX() - 1][square.getY()];
                } catch (IndexOutOfBoundsException error) {
                    checkNorth = board.getBoard()[square.getX()][square.getY()];
                }
                try {
                    checkSouth = board.getBoard()[square.getX() + 1][square.getY()];
                } catch (IndexOutOfBoundsException error) {
                    checkSouth = board.getBoard()[square.getX()][square.getY()];
                }
                try {
                    checkEast = board.getBoard()[square.getX()][square.getY() + 1];
                } catch (IndexOutOfBoundsException error) {
                    checkEast = board.getBoard()[square.getX()][square.getY()];
                }
                try {
                    checkWest = board.getBoard()[square.getX()][square.getY() - 1];
                } catch (IndexOutOfBoundsException error) {
                    checkWest = board.getBoard()[square.getX()][square.getY()];
                }
                if (checkEast.getSquareStatus() == SquareStatus.SHIP) {
                    falseOccurence = true;
                }
                if (checkWest.getSquareStatus() == SquareStatus.SHIP) {
                    falseOccurence = true;
                }
                if (checkNorth.getSquareStatus() == SquareStatus.SHIP) {
                    falseOccurence = true;
                }
                if (checkSouth.getSquareStatus() == SquareStatus.SHIP) {
                    falseOccurence = true;
                }
            }
            if (!falseOccurence) {
                allOkay = true;
            };
            return allOkay;
        }

    public int getSize(){
        return size;
    }

    public abstract Square[][] getBoard();
}
