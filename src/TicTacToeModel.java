import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {
    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED}

    ;

    private char[][] grid;
    private boolean turn;
    private Status status;
    private List<TicTacToeView> views;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView view) {
        views.add(view);
    }

    public void removeTicTacToeView(TicTacToeView view) {
        views.remove(view);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus() {

        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                status = (grid[i][0] == 'X') ? Status.X_WON : Status.O_WON;
            }
        }
        for(int j = 0; j < SIZE; j++) {
            if(grid[0][j] != ' ' && grid[0][j] == grid[1][j] && grid[0][j] == grid[2][j]) {
                status = (grid[0][j] == 'X') ? Status.X_WON : Status.O_WON;
            }
        }
        if(grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            status = (grid[0][0] == 'X') ? Status.X_WON : Status.O_WON;
        }
        if(grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            status = (grid[0][2] == 'X') ? Status.X_WON : Status.O_WON;
        }

        boolean Full = true;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(grid[i][j] == ' ') {
                    Full = false;
                    break;
                }
            }
        }
        if(Full) {
            status = Status.TIE;
        }

}

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        for(TicTacToeView view : views){
            view.handleTicTacToeStatusUpdate(this, status, x, y);
        }
        changeTurn();
    }
}




