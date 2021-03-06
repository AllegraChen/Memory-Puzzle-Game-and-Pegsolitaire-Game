package fall2018.csc2017.slidingtiles;

import android.content.Context;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * The Sliding Tiles Movement Controller
 */
class PlaySlidingTilesController {

    /**
     * The board manager.
     */
    private SlidingTilesManager slidingTilesManager;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;

    /**
     * The number of times a user has clicked the undo button.
     */
    static int numberOfUndos = 0;
    /**
     * The number of times a user has made a move.
     */

    static int numberOfMoves = 0;

    /**
     * Create the buttons for displaying the tiles.
     *
     * @param context the context
     */
    void createTileButtons(Context context, SlidingTilesManager inputSlidingTilesManager) {
        slidingTilesManager = inputSlidingTilesManager;
        Board board = slidingTilesManager.getBoard();
        tileButtons = new ArrayList<>();
        for (int row = 0; row != SlidingTilesBoard.NUM_ROWS; row++) {
            for (int col = 0; col != SlidingTilesBoard.NUM_COLS; col++) {
                Button tmp = new Button(context);
                tmp.setBackgroundResource(board.getTile(row, col).getBackground());
                this.tileButtons.add(tmp);
            }
        }
    }

    /**
     * Update the backgrounds on the buttons to match the tiles.
     */
    ArrayList<Button> updateTileButtons() {
        SlidingTilesBoard board = slidingTilesManager.getBoard();
        int nextPos = 0;
        for (Button b : tileButtons) {
            int row = nextPos / SlidingTilesBoard.NUM_ROWS;
            int col = nextPos % SlidingTilesBoard.NUM_COLS;
            b.setBackgroundResource(board.getTile(row, col).getBackground());
            nextPos++;
        }
        return tileButtons;
    }

    /**
     * Return a string that corresponds to if an undo can be used or that are available
     *
     * @return a string that corresponds to if an undo can be used or that are available
     */
    String usedNumberOfUndos() {
        numberOfUndos = GameLauncher.getCurrentUser().getNumOfUndos(SlidingTilesManager.GAME_NAME);
        if (numberOfUndos < SetUpActivity.undoLimit) {
            Stack totalStates = GameLauncher.getCurrentUser().getStackOfGameStates(SlidingTilesManager.GAME_NAME);
            if (totalStates.size() != 0) {
                List state = GameLauncher.getCurrentUser().getState(SlidingTilesManager.GAME_NAME);
                int row1 = (Integer) state.get(2);
                int col1 = (Integer) state.get(3);
                int row2 = (Integer) state.get(0);
                int col2 = (Integer) state.get(1);
                slidingTilesManager.getBoard().swapTiles(row1, col1, row2, col2);
                numberOfUndos++;
                GameLauncher.getCurrentUser().setNumOfUndos(SlidingTilesManager.GAME_NAME, numberOfUndos);
                return "setNumberOfMovesText";
            } else {
                return "NoUndoText";
            }
        }
        return "UndoLimitText";
    }

    /**
     * At the end of the game, do these actions: get the score, and send score to game score board and user score board.
     */
    List<Boolean> endOfGame(SlidingTilesManager slidingTilesManager) {
        Integer score = slidingTilesManager.getScore();
        boolean newGameScore = SlidingTilesManager.gameScoreBoard.takeNewScore(GameLauncher.getCurrentUser().getUsername(), score);
        boolean newUserScore = GameLauncher.getCurrentUser().userScoreBoard.takeNewScore(SlidingTilesManager.GAME_NAME, score);
        return Arrays.asList(newGameScore, newUserScore);
    }

    /**
     * Increase moves by 1 each time a move is made
     */
    static void incrementNumberOfMoves() {
        numberOfMoves++;
    }

    /**
     * Return the number of moves made by the user.
     *
     * @return number of moves
     */
    int getNumberOfMoves() {
        return numberOfMoves;
    }

    /**
     * Return the number of undos made by the user.
     *
     * @return number of undos
     */
    int getNumberOfUndos() {
        return numberOfUndos;
    }

}
