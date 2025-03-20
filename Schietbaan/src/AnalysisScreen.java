import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class AnalysisScreen extends JFrame {
    private File selectedFile;
    private JComboBox<String> sortingAlgorithmSelection;
    private JComboBox<String> searchAlgorithmSelection;
    private JTextField searchField;
    private JTextArea resultArea;
    private JButton analyzeButton;
    private JButton backButton;

    public AnalysisScreen(File file) {
        this.selectedFile = file;
        setTitle("📊 Data Analysis - " + file.getName());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // **Main Panel with Padding**
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid layout with spacing
        add(mainPanel, BorderLayout.CENTER);

        // **Sorting Selection**
        mainPanel.add(new JLabel("🔀 Sorting Algorithm:", SwingConstants.RIGHT));
        sortingAlgorithmSelection = new JComboBox<>(new String[]{"Bubble Sort", "Quick Sort"});
        mainPanel.add(sortingAlgorithmSelection);

        // **Search Selection**
        mainPanel.add(new JLabel("🔎 Search Algorithm:", SwingConstants.RIGHT));
        searchAlgorithmSelection = new JComboBox<>(new String[]{"Linear Search", "Binary Search"});
        mainPanel.add(searchAlgorithmSelection);

        // **Search Field**
        mainPanel.add(new JLabel("📌 Search Value:", SwingConstants.RIGHT));
        searchField = new JTextField();
        mainPanel.add(searchField);

        // **Analyze Button**
        analyzeButton = new JButton("📈 Analyze");
        analyzeButton.addActionListener(this::analyzeData);
        mainPanel.add(analyzeButton);

        // **Back Button**
        backButton = new JButton("🔙 Back");
        backButton.addActionListener(e -> goBack());
        mainPanel.add(backButton);

        // **Result Area**
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("📊 Analysis Results"));
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void analyzeData(ActionEvent e) {
        String sortMethod = (String) sortingAlgorithmSelection.getSelectedItem();
        String searchMethod = (String) searchAlgorithmSelection.getSelectedItem();
        String searchValue = searchField.getText();

        // Simulated analysis result
        resultArea.setText("🔄 Sorting using: " + sortMethod + "\n" +
                "🔍 Searching using: " + searchMethod + "\n" +
                "📊 Search Value: " + (searchValue.isEmpty() ? "None" : searchValue) + "\n\n" +
                "✅ Analysis Completed!");
    }

    private void goBack() {
        new StartScherm().setVisible(true);
        dispose();
    }
}