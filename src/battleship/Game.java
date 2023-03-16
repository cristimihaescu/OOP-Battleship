package src.battleship;

import src.battleship.player.ComputerPlayer;
import src.battleship.player.HumanPlayer;
import src.battleship.player.Player;
import src.battleship.util.*;

public class Game {
    private static final Display display = new Display();

    private Player player1;
    private Player player2;
    private Player currentRoundPlayer;

    public Game(String mode) {
        setup(mode);
    }

    private void setup(String mode) {
        player1 = new HumanPlayer("Player1");
        player2 = mode.equals("1") ? new HumanPlayer("Player2") : new ComputerPlayer("AI");
        currentRoundPlayer = player1;
    }

    public void gameCycle() {
        while (checkWin()) {
            currentRoundPlayer.shoot(getOtherPlayer());
            changeCurrentPlayer();
        }
        display.printWinner(player1.isAlive() ? player1.getName() : player2.getName());
    }

    private void changeCurrentPlayer() {
        currentRoundPlayer = currentRoundPlayer.getName().equals(player1.getName()) ? player2 : player1;
    }

    private Player getOtherPlayer() {
        return currentRoundPlayer.getName().equals(player1.getName()) ? player2 : player1;

    }

    private boolean checkWin() {
        return player1.isAlive() && player2.isAlive();
    }
}