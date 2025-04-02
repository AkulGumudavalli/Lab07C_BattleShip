import javax.swing.*;
import java.awt.*;

class StatusPanel extends JPanel {
    private JLabel missCounterLabel;
    private JLabel strikeCounterLabel;
    private JLabel totalMissLabel;
    private JLabel totalHitLabel;

    public StatusPanel() {
        setLayout(new FlowLayout());
        missCounterLabel = new JLabel("Miss Counter: 0");
        strikeCounterLabel = new JLabel("Hit Counter: 0");
        totalMissLabel = new JLabel("Strike Counter: 0");
        totalHitLabel = new JLabel("Total Hits: 0");
        add(missCounterLabel);
        add(strikeCounterLabel);
        add(totalMissLabel);
        add(totalHitLabel);
    }

    public void updateStatus(int misses, int strikes, int totalMisses, int totalHits) {
        missCounterLabel.setText("Miss Counter: " + misses);
        strikeCounterLabel.setText("Hit Counter: " + strikes);
        totalMissLabel.setText("Strike Counter: " + totalMisses);
        totalHitLabel.setText("Total Hits: " + totalHits);
    }


    public void reset() {
        updateStatus(0, 0, 0, 0);
    }
}
