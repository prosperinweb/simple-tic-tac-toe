public class Analyzer {

    private String[][] boardState;
    public Analyzer(String[][] boardState) {
        this.boardState = boardState;
    }

    // TODO: maybe clean up win state
    public boolean isWinner(String player) {
        return boardState[0][0].equals(player) && boardState[0][1].equals(player) && boardState[0][2].equals(player) ||
                boardState[1][0].equals(player) && boardState[1][1].equals(player) && boardState[1][2].equals(player) ||
                boardState[2][0].equals(player) && boardState[2][1].equals(player) && boardState[2][2].equals(player) ||
                boardState[0][0].equals(player) && boardState[1][0].equals(player) && boardState[2][0].equals(player) ||
                boardState[0][1].equals(player) && boardState[1][1].equals(player) && boardState[2][1].equals(player) ||
                boardState[0][2].equals(player) && boardState[1][2].equals(player) && boardState[2][2].equals(player) ||
                boardState[0][0].equals(player) && boardState[1][1].equals(player) && boardState[2][2].equals(player) ||
                boardState[0][2].equals(player) && boardState[1][1].equals(player) && boardState[2][0].equals(player);
    }

    public String winner() {
        String winner = "";
        if (isWinner("X") && isWinner("O")) {
            winner = "XO";
        } else if (isWinner("X")) {
            winner = "X";
        } else if (isWinner("O")) {
            winner = "O";
        }
        return winner;
    }

    public boolean isGameInProgress() {
        boolean isThereEmptyCells = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardState[i][j].equals("_")) {
                    isThereEmptyCells = true;
                    break;
                }
            }
        }
        return isThereEmptyCells && winner().equals("");
    }

    public boolean isDraw() {
        return !isGameInProgress() && !isWinner("X") && !isWinner("O");
    }

    public boolean isGameImpossible() {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardState[i][j].equals("X")) {
                    xCount++;
                } else if (boardState[i][j].equals("O")) {
                    oCount++;
                }
            }
        }

        return Math.abs(xCount - oCount) > 1 || winner().equals("XO");
    }

    public void refreshGameState(String[][] currentGameState) {
        this.boardState = currentGameState;
    }

    public String printStateResult() {
        if (isGameInProgress() && !isGameImpossible()) {
            return "Game not finished";
        } else if (isGameImpossible()) {
            return "Impossible";
        } else if (isDraw()) {
            return "Draw";
        } else {
            return winner() + " wins";
        }
    }
}
