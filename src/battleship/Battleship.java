package src.battleship;

import src.game.Game;
import src.game.Player;
import src.util.Display;
import src.util.Input;

public class Battleship {
    public static void main(String[] args){

        Display display = new Display();
        Input input = new Input();
        Game game = new Game();
        display.askForName();
        Player player1 = new Player(input.askForName(), game);
        display.askForName();
        Player player2 = new Player(input.askForName(), game);
    }

    public void gameLoop(){

    }
}
