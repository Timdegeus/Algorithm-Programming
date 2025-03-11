import Dataset.Shot;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShootingAnalysis extends JFrame
{
    private List<Shot> shotList = new ArrayList<>();
    private JTable shotTable;
    private DefaultTableModel tableModel;
    private JPanel targetPanel;
    private JLabel avgScoreLabel, totalScoreLabel;

    public ShootingAnalysis() {
        setTitle("Shooting Analysis");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //table setup
        String[] columnNames = {"Shot number", "Score", "Comparison"};
        tableModel = new DefaultTableModel(columnNames, 0);
        shotTable = new JTable(tableModel);
        add(new JScrollPane(shotTable), BorderLayout.WEST);

        // target visualization panel
        targetPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillOval(100, 100, 200, 200);
                for (Shot s : shotList) {
                    g.setColor(Color.RED);
                    g.fillOval(200 + (int) s.getxCoord(), 200 + (int) s.getyCoord(), 5, 5);
                }
            }
        };
        targetPanel.setPreferredSize(new Dimension(300, 300));
        add(targetPanel, BorderLayout.CENTER);

        // Statistics panel
        JPanel statsPanel = new JPanel();
        avgScoreLabel = new JLabel("Average score: 0.0");
        totalScoreLabel = new JLabel("Total score: 0.0");
        statsPanel.add(avgScoreLabel);
        statsPanel.add(totalScoreLabel);
        add(statsPanel, BorderLayout.SOUTH);

        // add dummy data
        addShot(new Shot(1, 1, 9.8, 3.2, 4.1, 10.5, "+", 9.8, 9.8));
        addShot(new Shot(1, 2, 10.2, 2.9, 4.3, 8.1, "+", 10.0, 20.0));
        addShot(new Shot(1, 3, 8.5, 5.1, 6.2, 12.3, "-", 9.5, 28.5));
    }

        private void addShot(Shot shot)
        {
            shotList.add(shot);
            tableModel.addRow(new Object[]{shot.getShotNumber(), shot.getScore(), shot.getComparison()});
            updateStats();
            repaint();
        }

    private void updateStats() {
        double total = shotList.stream().mapToDouble(s -> s.getScore()).sum();
        double avg = total / shotList.size();
        avgScoreLabel.setText("Average Score: " + String.format("%.2f", avg));
        totalScoreLabel.setText("Total Score: " + String.format("%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShootingAnalysis().setVisible(true));
    }
}
