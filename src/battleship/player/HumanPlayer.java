package src.battleship.player;

import src.battleship.util.Display;
import src.battleship.util.Input;

import java.util.Arrays;

public class HumanPlayer extends Player {
    private static final Display display = new Display();
    private static final Input input = new Input();

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void shoot(Player otherPlayer) {
        display.printBoard(otherPlayer.getBoard(), false);
        int[] validCoordinates = input.askAttackCoordinate(name, otherPlayer.getBoard());
        if (Arrays.equals(validCoordinates, new int[]{0})) {
            initiateNukeCheat(otherPlayer);
        } else {
            otherPlayer.getHit(validCoordinates[0], validCoordinates[1]);
        }
    }

    private void initiateNukeCheat(Player otherPlayer) {
        for (int row = 0; row < board.getOcean().length; row++) {
            for (int col = 0; col < board.getOcean().length; col++) {
                otherPlayer.getHit(row, col);
            }

        }
        display.printBoard(otherPlayer.getBoard(), false);
    }
}

