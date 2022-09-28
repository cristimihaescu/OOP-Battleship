package src.game;

import src.board.Board;
import src.board.BoardFactory;
import src.ship.Ship;
import src.ship.ShipType
import java.util.ArrayList
import java.util.List;

public class Player {
    private List<Ship> ships;
    private final String name;

    public Player(String name, Game game, Board board){
        this.name = name;
        this.ships = loadUpFleet(game, board);
    }

    private List<Ship> loadUpFleet(Game game, Board board) {
        List<Ship> fleet = new ArrayList<>();
        BoardFactory manualPlace = new BoardFactory();
        manualPlace.manualPlacement(board, this, fleet, game);
        return fleet;
    }

    public List <Ship> getShips(){
        return ships;
    }

    public String getName(){
        return name;
    }

    public boolean isAlive(){
        return true;
    }

    public Player(String name){
        this.name = name;
    }
}
