import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {

    private TicTacToeModel model;

    public TicTacToeController(TicTacToeModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] coord = e.getActionCommand().split(" ");
        model.play(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
        if(model.getStatus()== TicTacToeModel.Status.X_WON){
            JOptionPane.showMessageDialog(null,"X won");
        }
        if(model.getStatus()== TicTacToeModel.Status.O_WON){
            JOptionPane.showMessageDialog(null,"O won");
        }
        if(model.getStatus()== TicTacToeModel.Status.TIE){
            JOptionPane.showMessageDialog(null,"Tie");
        }

    }
}
