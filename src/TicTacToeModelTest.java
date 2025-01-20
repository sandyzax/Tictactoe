import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {

    @Test
    public void getStatus() {
        TicTacToeModel model = new TicTacToeModel(); //testing X wins
        model.play(0,0);
        model.play(0,1);
        model.play(1,1);
        model.play(1,0);
        model.play(2,2);
        //model.play(1,0);
        //model.play(0,2);
        assertEquals(TicTacToeModel.Status.X_WON,model.getStatus());

        TicTacToeModel model2 = new TicTacToeModel();
        model2.play(0, 0); // X
        model2.play(0, 1); // O
        model2.play(0, 2); // X
        model2.play(1, 1); // O
        model2.play(1, 0); // X
        model2.play(1, 2); // O
        model2.play(2, 1); // X
        model2.play(2, 0); // O
        model2.play(2, 2); // X

        assertEquals(TicTacToeModel.Status.TIE,model2.getStatus());

        TicTacToeModel model3 = new TicTacToeModel(); //testing O wins
        model3.play(0,0);
        model3.play(0,1);
        model3.play(0,2);
        model3.play(1,1);
        model3.play(1,2);
        model3.play(2,1);

        assertEquals(TicTacToeModel.Status.O_WON,model3.getStatus());

        TicTacToeModel model4 = new TicTacToeModel(); //testing x diagonals
        model4.play(0, 0); // X
        model4.play(0, 1); // O
        model4.play(1, 1); // X
        model4.play(1, 0); // O
        model4.play(2, 2);

        assertEquals(TicTacToeModel.Status.X_WON,model4.getStatus());
    }
}