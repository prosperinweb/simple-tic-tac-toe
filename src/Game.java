import java.util.Objects;
import java.util.Scanner;

public class Game {
    private static final int SIZE = 3;
    public boolean isCurrentPlayerX = true;
    private final String[][] BOARD = new String[SIZE][SIZE];

    private final Analyzer analyzer = new Analyzer(BOARD);
    private final Scanner scanner = new Scanner(System.in);
    private static final String BOARD_FORMAT = "" +
            "---------\n" +
            "| %s %s %s |\n" +
            "| %s %s %s |\n" +
            "| %s %s %s |\n" +
            "---------";

    /* TODO
        - Commands method so user chooses whether to start from scratch or enter existing game state
        - choose which player goes first
        - redo ability
        - replay ability
        - add history
        - add custom game such as
            - best of 3 / 5
    */
    public void init() {
        setDefaultBoard();
        printBoard();
        move();
    }

    public void setDefaultBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                BOARD[i][j] = "_";
            }
        }
    }
    public void enterExistingState() {
        System.out.println("Enter cells:");
        try {
            String boardInput = scanner.nextLine();
            String[] lines = boardInput.split("");
            for (int i = 0; i < 3; i++) {
                System.arraycopy(lines, i * 3, BOARD[i], 0, 3);
            }
            analyzer.refreshGameState(BOARD);
            printBoard();
            checkGameState();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    // TODO: Limit player to only X or O case-insensitive
    public void move() {
        System.out.println("Enter the coordinates:");
        String row = scanner.next();
        String col = scanner.next();
        validateCoordinates(row, col);
        printBoard();
        checkGameState();
    }

    // TODO: Custom exception class for error messages
    private void validateCoordinates(String row, String col) {
        try {
            int rowNum = Integer.parseInt(row);
            int colNum = Integer.parseInt(col);
            if (rowNum > 3 || rowNum < 1 || colNum > 3 || colNum < 1) {
                System.out.println("Coordinates should be from 1 to 3");
                move();
            } else if (!Objects.equals(BOARD[rowNum - 1][colNum - 1], "_")) {
                System.out.println("This cell is occupied!, Choose another one!");
                move();
            } else {
                BOARD[rowNum - 1][colNum - 1] = isCurrentPlayerX ? "X" : "O";
                isCurrentPlayerX = !isCurrentPlayerX;
            }
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            move();
        }
    }

    // TODO: create enum for game states
    public void checkGameState() {
        String gameResult = analyzer.printStateResult();
        if ("Game not finished".equals(gameResult)) {
            move();
        } else {
            System.out.println(gameResult);
        }
    }


    public void printBoard() {
        System.out.printf((BOARD_FORMAT) + "%n",
                BOARD[0][0], BOARD[0][1], BOARD[0][2],
                BOARD[1][0], BOARD[1][1], BOARD[1][2],
                BOARD[2][0], BOARD[2][1], BOARD[2][2]
        );
    }

    public void printGameState() {
        printBoard();
        analyzer.printStateResult();
    }

}

