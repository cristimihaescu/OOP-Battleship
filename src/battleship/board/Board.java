package src.battleship.board;

import src.battleship.ship.Ship;
import src.battleship.ship.ShipType;

public class Board {

    private final Square[][] ocean;

    public Board(int mapSize) {
        ocean = new Square[mapSize][mapSize];
        for (int row = 0; row < ocean.length; row++) {
            for (int column = 0; column < ocean.length; column++) {
                ocean[row][column] = new Square(row, column);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public Square getSquare(int x, int y) {
        return ocean[x][y];
    }

    public void setSquareStatusHit(int x, int y) {
        ocean[x][y].setStatus(ocean[x][y].getStatus() == SquareStatus.SHIP
                ? SquareStatus.HIT
                : SquareStatus.MISSED);
    }

    public void setSquareStatusSunk(int x, int y){
        ocean[x][y].setStatus(ocean[x][y].getStatus() == SquareStatus.HIT
                ? SquareStatus.HIT //NOT operator - converteste true in false si vice-versa
                : SquareStatus.MISSED);
    }

    private boolean isPlacementInsideBoard(int x, int y, int size, String direction) {
        int xEnd = direction.equals("vertical")
                ? x + size
                : x;
        int yEnd = direction.equals("horizontal")
                ? y + size
                : y;
        return x >= 0 &&
                y >= 0 &&
                xEnd < ocean.length &&
                yEnd < ocean.length;
    }

    private boolean isPlacementEmpty(int x, int y, ShipType type, String direction) {
        if (direction.equals("horizontal")) {
            int targetYCoordinate = y + type.shipSize;
            for (int iteratingCoordinate = y; iteratingCoordinate < targetYCoordinate; iteratingCoordinate++) {
                if (!ocean[x][iteratingCoordinate].getStatus().equals(SquareStatus.EMPTY)) {
                    return false;
                }
            }
        } else {
            int targetXCoordinate = x + type.shipSize;
            for (int changingCoordinate = x; changingCoordinate < targetXCoordinate; changingCoordinate++) {
                if (!ocean[changingCoordinate][y].getStatus().equals(SquareStatus.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPlacementOk(int x, int y, Ship ship, String direction) {
        int size = ship.getType().shipSize;
        return isPlacementInsideBoard(x, y, size, direction) && isPlacementEmpty(x, y, ship.getType(), direction);
    }
}