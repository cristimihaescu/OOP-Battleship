package src.battleship.util;
import src.battleship.board.Board;
import src.battleship.board.SquareStatus;

public class Display {
    private final static int ASCII_CHARACTER_A = 65;

    public void println(String print) {
        System.out.println(print);
    }

    public void print(String print) {
        System.out.print(print);
    }

    public void printMainMenu() {
        println("                                     # #  ( )\n" +
                        "                                  ___#_#___|__\n" +
                        "                              _  |____________|  _\n" +
                        "                       _=====| | |            | | |==== _\n" +
                        "                 =====| |.---------------------------. | |====\n" +
                        "   <--------------------'   .  .  .  .  .  .  .  .   '--------------/\n" +
                        "     \\                           BATTLESHIP                        /\n" +
                        "      \\___________________________________________________________/\n" +
                        "  wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\n" +
                        "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\n" +
                        "   wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww \n"+"\n"+

                "Welcome to the battleship game !\n"+"\n"+
                "Please choose an option:\n"+"\n"+

                "1.Player vs Player \n" +
                "2.Player vs Computer\n" +
                "3.Quit");
    }

    public void printBoard(Board board, boolean isPlacementPhase) {
        for (int i = 0; i < 10; i++) {
            print("\n");
        }
        int boardSize = board.getOcean().length;
        print("   ");
        for (int i = 1; i <= boardSize; i++) {
            print(i + "   ");
        }
        println("");
        for (int i = 0; i < boardSize; i++) {
            print((char) (i + ASCII_CHARACTER_A) + "  ");
            for (int j = 0; j < boardSize; j++) {
                if (!isPlacementPhase) {
                    print(board.getOcean()[i][j].getStatus() == SquareStatus.SHIP ?
                            SquareStatus.EMPTY.unicodeCharacter + "  " :
                            board.getOcean()[i][j].getStatus().unicodeCharacter + "  ");
                } else {
                    print(board.getOcean()[i][j].getStatus().unicodeCharacter + "  ");
                }

            }
            println("");
        }
    }

    public void printWinner(String player) {
        println(player + " You won !");
    }
}