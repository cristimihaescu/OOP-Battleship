package src.board;
import java.util.Arrays;

public class Player1Board extends Board{
    private Square[][] ocean;

    public Player1Board(int size){
        super(size);
        this.ocean = new Square[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                this.ocean[row][col] = new Square(row, col, SquareStatus.EMPTY);
            }
        }
    }

    @Override
    public void printOcean(int size){
        System.out.println(Arrays.deepToString(this.ocean));
    }

    @Override
    public void printDetailedOcean(int size){
        System.out.println("Player 1's Board");
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.println(this.ocean[row][col].getX());
                System.out.println(this.ocean[row][col].getY());
                System.out.println(this.ocean[row][col].showSquareStatus());
            }
        }
    }
}
