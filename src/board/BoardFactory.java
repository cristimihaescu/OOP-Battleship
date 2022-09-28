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

    public void manualPlacement(Board board, Player player, List<Ship> fleet, Game game) {
        fleet.add(new Ship(game.placeShip(ShipType.CARRIER,board) , ShipType.CARRIER));
        boardPlacement(fleet,board);
        fleet.add(new Ship(game.placeShip(ShipType.CRUISER,board) , ShipType.CRUISER));
        fleet.add(new Ship(game.placeShip(ShipType.BATTLESHIP, board) , ShipType.BATTLESHIP));
        fleet.add(new Ship(game.placeShip(ShipType.SUBMARINE, board) , ShipType.SUBMARINE));
        fleet.add(new Ship(game.placeShip(ShipType.DESTROYER, board) , ShipType.DESTROYER));
        boardPlacement(fleet,board);
    }


    public void boardPlacement(List<Ship> fleet, Board board) {
        Square[][] table = board.getBoard();
        for (Ship ship : fleet){
            for(Square coordinate : ship.getPlacement()){
                table[coordinate.getX()][coordinate.getY()].setSquareStatus(SquareStatus.SHIP);
            }
        }
    }

    public void randomPlacement() {
    }
}

