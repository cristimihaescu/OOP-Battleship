package src.battleship.board;

public enum SquareStatus {
    EMPTY("\uD83C\uDF0A"), SHIP("⛵"), HIT("\uD83D\uDCA5"), MISSED("⛔"),
    SUNK("\uD83D\uDC80");
    public final String unicodeCharacter;

    SquareStatus(String character) {
        unicodeCharacter = character;
    }
}
