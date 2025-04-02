import javax.swing.*;
import java.awt.*;

class ControlPanel extends JPanel {
    public ControlPanel(GameFrame frame) {
        setLayout(new FlowLayout());
        JButton playAgain = new JButton("Play Again");
        JButton quit = new JButton("Quit");
        playAgain.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame.getStatusPanel(), "Are you sure you want to play again?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION) {
                frame.resetGame();
            }
        });
        quit.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame.getStatusPanel(), "Are you sure you want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        add(playAgain);
        add(quit);
    }
}