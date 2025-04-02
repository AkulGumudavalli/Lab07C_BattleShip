import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GameBoard board;
    private StatusPanel statusPanel;
    private ControlPanel controlPanel;

    public GameFrame() {
        setTitle("Battleship Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        board = new GameBoard(this);
        statusPanel = new StatusPanel();
        controlPanel = new ControlPanel(this);
        add(statusPanel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    public void resetGame() {
        getContentPane().remove(board);
        board = new GameBoard(this);
        add(board, BorderLayout.CENTER);
        statusPanel.reset();
        revalidate();
        repaint();
    }

    public void endGame( int type) {
        if(type==1){
            JOptionPane.showMessageDialog(this, " Congratulations! You've sunk all the ships!  Game Over");
        }
        else if(type==-1){
            JOptionPane.showMessageDialog(this, "     YOU LOOOSE !!!!!    Game Over");
        }
    }
}