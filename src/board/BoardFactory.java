package src.board;

import src.game.Game;
import src.game.Player;
import src.ship.Ship;
import src.ship.ShipType;
import src.util.Display;

import java.util.List;
import java.util.Arrays;


public class BoardFactory {
    Display display = new Display();

    public void manualPlacement(Board board, Player activePlayer, List<Ship> fleet, Game game) {
        display.clearConsole();
        for (ShipType type : Arrays.asList(ShipType.CARRIER,
                ShipType.CRUISER,
                ShipType.BATTLESHIP,
                ShipType.SUBMARINE,
                ShipType.DESTROYER)) {
            display.printPlacementPhaseHeader(activePlayer);
            display.printBoard(board, activePlayer);
            if (placeShip(board, fleet, new Ship(game.placeShip(type, board), type))) {
                continue;
            } else {
                placeShip(board, fleet, new Ship(game.placeShip(type, board), type));
            }
            display.clearConsole();
        }
    }

    private boolean placeShip(Board board, List<Ship> fleet, Ship ship) {
        fleet.add(ship);
        if (!board.isPlacementOkay(ship, board)) {
            return false;
        };
        boardPlacement(ship, board);
        return true;
    }


    public void boardPlacement(Ship ship, Board board) {
        Square[][] table = board.getBoard();
        for(Square coordinate : ship.getPlacement()){
                table[coordinate.getX()][coordinate.getY()].setSquareStatus(SquareStatus.SHIP);
            }
        }

    public void randomPlacement() {
    }
}

