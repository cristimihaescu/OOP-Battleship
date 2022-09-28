package src.game;

import src.battleship.Battleship;
import src.board.*;
import src.ship.Ship;
import src.ship.ShipType;
import src.util.Display;
import src.util.Input;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Display display;
    private final Input input;
    private final Player1Board player1Board;
    private final Player2Board player2Board;
    private final Player player1;
    private final Player player2;

    public Game(int size) {
        this.display = new Display();
        this.input = new Input();

        this.player1Board = new Player1Board(size);
        this.player2Board = new Player2Board(size);

        display.clearConsole();
        display.askForName();
        this.player1 = new Player(input.askForName(), this, player1Board, placementOption);
        display.clearConsole();
        display.askForName();
        this.player2 = new Player(input.askForName(), this, player2Board, placementOption);
    }

    public void gameLoop() {
        int currentRound = round;
        boolean isRunning = true;
        while (isRunning) {
            Player activePlayer = currentRound % 2 == 0 ? player2 : player1;
            Player opponent = activePlayer == player1 ? player2 : player1;
            Board activeBoard = activePlayer == player1 ? player2Board : player1Board;
            try {
                playRound(activePlayer, opponent, activeBoard);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException | StringIndexOutOfBoundsException error) {
                gameLoop(currentRound);
            }
            if (hasWon(opponent) && !opponent.isAlive()) {
                display.clearConsole();
                display.printResults(activePlayer);
                isRunning = false;
            }
            currentRound++;
        }
        display.askForEnter();
        input.askEnter();
        Battleship.main(new String[]{});
    }

    public void playRound(Player activePlayer, Player opponent, Board board){
        prepareRound(activePlayer);
        String shootArea = input.inputCoordinate();
        int[] shootCoordinates = input.toCoordinates(shootArea);
        Square square = board.getBoard()[shootCoordinates[0]][shootCoordinates[1]];
        SquareStatus status = square.getSquareStatus();
        switch(status){
            case EMPTY:
                square.setSquareStatus(SquareStatus.MISS);
                break;
            case SHIP:
                hitShip(opponent, shootCoordinates);
                break;
        }
        finishRound(opponent, activePlayer);
    }
private void finishRound(Player opponent, Player activePlayer){
        display.clearConsole();
        display.turn(activePlayer);
        lookForSunkShips(opponent.getShips(), opponent.getSunkShips());
        display.askForEnter();
        input.askEnter();
    }
    private void prepareRound(Player activePlayer){
        display.clearConsole();
        display.turn(activePlayer);
    }

    private void hitShip(Player opponent, int[] shootCoordinates){
        if(Square.getSquareStatus() == SquareStatus.HIT){
            System.out.println("Already hit !");
        }else{
            Square.setSquareStatus(SquareStatus.HIT);
            damageEnemyShip(opponent.getShips(), shootCoordinates);
            opponent.setShipSquares();
        }
    }

    private void lookForSunkShips(List<Ship> enemiShips, List<Ship> enemySunkShips){
        for(Ship ship : enemiShips){
            int damagedTiles = 0;
            for(Square tile : ship.getPlacement()){
                if(tile.getSquareStatus() == SquareStatus.HIT)
                    damagedTiles++;
            }
            if(damagedTiles == ship.getPlacement().size() && !enemySunkShips.contains(ship)){
                display.deliverSunkMessage(ship.getType().getName());
                enemySunkShips.add(ship);
            }
        }
    }

    private void damageEnemyShip(List<Ship> enemyShips, int[] shootCoordinates){
        for(Ship ship : enemyShips){
            for(Square coordinate : ship.getPlacement()){
                if(coordinate.getX() == shootCoordinates[0] &&
                coordinate.getY() == shootCoordinates[1]){
                    coordinate.setSquareStatus(SquareStatus.HIT);
                }
            }
        }
    }

    public boolean hasWon(Player opponent){
        return opponent.getShipSquares() == 0;
    }
}
