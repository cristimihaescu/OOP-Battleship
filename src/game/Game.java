package src.game;

import src.board.Board;
import src.board.*;
import src.ship.ShipType;
import src.util.Display;
import src.util.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Game {
    private final Display display = new Display();
    private final Input input = new Input();

    public void gameLoop(int size){
        Player1Board player1Board = new Player1Board(size);
        Player2Board player2Board = new Player2Board(size);
        display.askForName();
        Player player1 = new Player(input.askForName(), this,player1Board);
        display.printBoard(player1Board,player1);
        display.askForName();
        Player player2 = new Player(input.askForName(), this, player2Board);
    }
    public void playRound(Player activePlayer, Board board) {
        display.turn(activePlayer);
        String shootArea = input.inputCoordinate();
        int[] shootCoordinates = input.toCoordinates(shootArea);
        int row = shootCoordinates[0];
        int col = shootCoordinates[1];
        Square square = board.getBoard()[row][col];
        String status = square.getSquareStatus();
        switch(status) {
            case EMPTY:
                square.setSquareStatus(SquareStatus.MISS);
            case SHIP:
                square.setSquareStatus(SquareStatus.HIT);
            default:
                break;
        }
        if(hasWon(activePlayer)){
            display.printResults();
        }
    }
    public boolean hasWon(Player activePlayer) {
        return false;
    }

    public List<Square> placeShip(ShipType type, Board board) {
        List<Square> positionList = new ArrayList<>();
        int[] shipNosePosition = getStartingCoordinate(type);
        ArrayList<String> validOrientations = validOrientations(shipNosePosition, type, board);
        Orientation shipOriented = getShipOrientation(type, board);
        while (!validOrientations.contains(shipOriented.getName())){
            display.wrongCoordinates();
            shipOriented = getShipOrientation(type, board);
        }
        positionList.add(new Square(shipNosePosition[0], shipNosePosition[1], SquareStatus.SHIP));
        fillUpPositionList(type, positionList, shipNosePosition, shipOriented);
        System.out.println(positionList);
        return positionList;
    }

    private ArrayList<String> validOrientations(int [] shipNosePosition, ShipType type, Board board){
        ArrayList<String> validDirection = new ArrayList<>();

        if (shipNosePosition[0] - type.getSize() >= 0){
            validDirection.add("N");
        }
        if (shipNosePosition[1] - type.getSize() >= 0){
            validDirection.add("W");
        }
        if (shipNosePosition[0] + type.getSize() <= board.getSize()){
            validDirection.add("S");
        }
        if (shipNosePosition[0] + type.getSize() <= board.getSize()){
            validDirection.add("E");
        }
        return validDirection;
    }

    private void fillUpPositionList(
            ShipType type,
            List<Square> positionList,
            int[] shipNosePosition,
            Orientation shipOriented
    ) {
        int multiplierForShip = 1;
        for (int addition = 0; addition < type.getSize() - 1; addition++) {
            positionList.add(new Square(shipNosePosition[0] + shipOriented.getX() * multiplierForShip,
                    shipNosePosition[1] + shipOriented.getY() * multiplierForShip,
                    SquareStatus.SHIP));
            multiplierForShip++;
        }
    }

    private Orientation getShipOrientation(ShipType type, Board board) {
        display.askForOrientation();
        return defineOrientation(input.askForOrientation(), type, board);
    }

    private int[] getStartingCoordinate(ShipType type) {
        display.askForCoordinates(type);
        return input.toCoordinates(input.inputCoordinate());
    }

    private Orientation defineOrientation(String input, ShipType type, Board board) {
        Orientation output = null;
        switch (input) {
            case "n" -> output = Orientation.NORTH;
            case "w" -> output = Orientation.WEST;
            case "s" -> output = Orientation.SOUTH;
            case "e" -> output = Orientation.EAST;
            default -> placeShip(type);
        } return output;
    }
}
