package src.game;

import src.board.Board;
import src.board.BoardFactory;
import src.board.Square;
import src.ship.Ship;
import java.util.ArrayList;
import java.util.List;
import src.board.Square;

public class Player {
    private List<Ship> ships;
    private final String name;

    private int shipSquares;


    public Player(String name, Game game, Board board){
        this.name = name;
        this.ships = loadUpFleet(game, board);
        this.shipSquares = 0;
        for(Ship ship : ships){
            for(Square ignored : ship.getPlacement()){
                shipSquares++;
            }
        }
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
        return shipSquares > 0;
    }

    public Player(String name){
        this.name = name;
    }

    public int getShipSquares(){
        return shipSquares;
    }

    public void setShipSquares(){
        this.shipSquares --;
    }
}
