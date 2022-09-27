package src.game;

import src.ship.Ship;

import java.util.List;

public class Player {
    private List<Ship> ships;
    private final String name;

    public boolean isAlive(){
        return true;
    }

    public Player(String name){
        this.name = name;
    }
}
