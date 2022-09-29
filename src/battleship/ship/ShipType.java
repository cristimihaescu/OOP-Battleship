package src.battleship.ship;

public enum ShipType {
    CARRIER(5), BATTLESHIP(4), SUBMARINE(3), DESTROYER(2);
    public final int shipSize;

    ShipType(int size) {
        shipSize = size;
    }
}