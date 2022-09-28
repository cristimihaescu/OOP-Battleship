package src.battleship.ship;

import src.battleship.board.Square;
import src.battleship.board.SquareStatus;

import java.util.ArrayList;

public class Ship {
    private final ArrayList<Square> shipPositions = new ArrayList<>();

    private final ShipType type;


    public Ship(ShipType type) {
        this.type = type;
    }

    public ArrayList<Square> getPositions() {
        return shipPositions;
    }

    public void addPosition(Square square) {
        shipPositions.add(square);
        square.setStatus(SquareStatus.SHIP);
    }

    public ShipType getType() {
        return type;
    }
}