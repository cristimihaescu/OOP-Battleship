package src.battleship;

import src.board.Player1Board;
import src.board.Player2Board;
import src.game.Game;
import src.game.Player;
import src.util.Display;
import src.util.Input;

public class Battleship {
    public static void main(String[] args) {
        mainMenu();
    }

        Display display = new Display();
        Input input = new Input();
        Game game = new Game();

        display.clearConsole();
        display.printMenu();
        int menuInput = input.inpputForMenu();

        switch(menuInput){
            case 1 ->{
                display.askForBoardSize();
                int chosenSize = input.inputForMenu();
                if(chosenSize >= 10 && chosenSize <= 20)
                    game.gameLoop(chosenSize);
                else
                    mainMenu();
            }
            case 2 -> System.exit(0);
            default -> mainMenu();
    }

    public void gameLoop(){

    }
}
