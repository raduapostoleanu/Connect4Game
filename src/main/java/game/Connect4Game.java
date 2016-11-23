package game;

/**
 * Created by Radu on 22.11.2016.
 */
public class Connect4Game {
    public static final int GRID_SIZE = 7;
    public static final int RED = 1;
    public static final int YELLOW = 2;
    private int[][] matrix;
    private boolean redTurn;
    private boolean gameOver;

    public Connect4Game() {
        this.matrix = new int[GRID_SIZE][GRID_SIZE];
        this.redTurn = true;
        this.gameOver = false;
    }

    /**
     * Returns if the game is over or not
     * @return boolean true if the game has ended with a victor
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Adds a color token to the column provided as parameter
     * @param column integer with the column on which the next token needs to be place
     * @return Message a message with the result of the operation, see Message Enum
     */
    public Message addToken(int column){
        for(int row = GRID_SIZE - 1; row >= 0; row--){
            if(matrix[row][column] == 0){
                if(redTurn){
                    matrix[row][column] = RED;
                    redTurn = !redTurn;
                    if(isWin(row,column)){
                        return Message.RED_WINS;
                    } else {
                        return Message.YELLOW_TURN;
                    }
                } else {
                    matrix[row][column] = YELLOW;
                    redTurn = !redTurn;
                    if(isWin(row,column)){
                        return Message.YELLOW_WINS;
                    } else {
                        return Message.RED_TURN;
                    }
                }
            }
        }
        return Message.COLUMN_FULL;
    }

    /**
     * Retrieves the status of the board as a matrix
     * @return int[][] matrix representation of the board
     */
    public int[][] getMatrix() {
        return matrix;
    }

    public void printMatrix(){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public boolean isWin(int r, int c){
        this.gameOver = isLineWin(r,c) || isMainDiagonalWin(r,c) || isSecondaryDiagonalWin(r,c);
        return this.gameOver;
    }

    /**
     * Checks if the win condition is met on vertical or horizontal positions for the given location
     * @param row
     * @param column
     * @return boolean true if there are 4 tokens in a line horizontally/vertically in the matrix
     */
    public boolean isLineWin(int row, int column){
        int horizontalLine = 0;
        int verticalLine = 0;
        for(int k = 0; k < GRID_SIZE; k++){
            if(matrix[row][k] == matrix[row][column]){
                horizontalLine++;
                if(horizontalLine == 4) {
                    return true;
                }
            } else {
                horizontalLine = 0;
            }
            if(matrix[k][column] == matrix[row][column]){
                verticalLine++;
                if(verticalLine == 4) {
                    return true;
                }
            } else {
                verticalLine = 0;
            }
        }
        return false;
    }

    /**
     * Checks if the win condition is met on the main diagonal(or parallel lines) for the given location
     * @param row
     * @param column
     * @return boolean true if there are 4 tokens in a line (main) diagonally in the matrix
     */
    public boolean isMainDiagonalWin(int row, int column){
        int delta = row - column;
        int mainDiagonal = 0;
        for(int i = Math.max(0, delta); i < Math.min(GRID_SIZE, GRID_SIZE + delta); i++){
            if(matrix[i][i-delta] == matrix[row][column]){
                mainDiagonal++;
                if(mainDiagonal == 4) {
                    return true;
                }
            } else {
                mainDiagonal = 0;
            }
        }
        return false;
    }


    /**
     * Checks if the win condition is met on the secondary diagonal(or parallel lines) for the given location
     * @param row
     * @param column
     * @return boolean true if there are 4 tokens in a line (secondary) diagonally in the matrix
     */
    public boolean isSecondaryDiagonalWin(int row, int column){
        int sum = row + column;
        int secondaryDiagonal = 0;
        for(int i = Math.max(sum - GRID_SIZE + 1, 0); i < Math.min(GRID_SIZE, sum + 1); i++){
            if(matrix[i][sum - i] == matrix[row][column]){
                secondaryDiagonal++;
                if(secondaryDiagonal == 4) {
                    return true;
                }
            } else {
                secondaryDiagonal = 0;
            }
        }
        return false;
    }




}
