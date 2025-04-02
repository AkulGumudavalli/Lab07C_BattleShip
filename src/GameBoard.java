import javax.swing.*;
import java.awt.*;
import java.util.Random;

class GameBoard extends JPanel {
    private JButton[][] cells = new JButton[10][10];
    private int[][] shipGrid = new int[10][10];
    private int totalMisses = 0;
    private int totalHits = 0;
    private int totalShipCells = 0;
    private int totalMissCounter = 0;
    private GameFrame frame;
    private int[][] shipPos = new int[10][10];
    public GameBoard(GameFrame frame) {
        this.frame = frame;
        setLayout(new GridLayout(10, 10));
        placeShips();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton button = new JButton("~");
                final int r = row, c = col;
                button.addActionListener(e -> handleMove(button, r, c));
                cells[row][col] = button;
                add(button);
            }
        }
    }

    private void placeShips() {
        Random rand = new Random();
        int[] shipSizes = {5, 4, 3, 3, 2};

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);
                boolean horizontal = rand.nextBoolean();
                if (canPlaceShip(row, col, size, horizontal)) {
                    for (int i = 0; i < size; i++) {
                        if (horizontal) shipGrid[row][col + i] = 1;
                        else shipGrid[row + i][col] = 1;
                    }
                    totalShipCells += size;
                    placed = true;
                }
            }
        }
    }

    private boolean canPlaceShip(int row, int col, int size, boolean horizontal) {
        if (horizontal && col + size > 10) return false;
        if (!horizontal && row + size > 10) return false;
        for (int i = 0; i < size; i++) {
            if (horizontal && shipGrid[row][col + i] == 1) return false;
            if (!horizontal && shipGrid[row + i][col] == 1) return false;
        }
        return true;
    }
    private boolean canPlaceShip(int row, int col) {
        if (shipGrid[row][col]==1){
            return true;
        }return false;

    }

    private void handleMove(JButton button, int row, int col) {
        if (shipGrid[row][col] == 1) {
            button.setText("X");
            button.setBackground(Color.RED);
            totalHits++;
        } else {
            button.setText("M");
            button.setBackground(Color.YELLOW);
            totalMisses++;
            if (totalMisses == 5){
                totalMissCounter++;
                totalMisses = 0;
            }

        }
        button.setEnabled(false);
        frame.getStatusPanel().updateStatus(totalMisses, totalHits, totalMissCounter, totalHits);
        if (totalHits == totalShipCells) {
            frame.endGame(1);
        } else if (totalMissCounter == 3) {
            frame.endGame(-1);
        }
    }
}