package src.battleship.player;

import java.util.Random;

public class ComputerPlayer extends Player {

    private static final Random rand = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void shoot(Player player) {
        int x = rand.nextInt(player.getBoard().getOcean().length);
        int y = rand.nextInt(player.getBoard().getOcean().length);
        player.getHit(x, y);
    }
}