import SearchAlgorithms.BinarySearch;
import SearchAlgorithms.LinearSearch;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.QuickSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Arrays;

import static java.awt.List.*;

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

        // Sample dataset
        java.util.List<String> fileData = java.util.List.of("34", "12", "9", "45", "78", "56");

        try
        {
            if (fileData.stream().allMatch(s -> s.matches("-?\\d+")))
            {
                Integer[] data = fileData.stream().map(Integer::parseInt).toArray(Integer[]::new);
                Integer searchVal = searchValue.isEmpty() ? null : Integer.parseInt(searchValue);
                analyzeData(data, sortMethod, searchMethod, searchVal); // Calls the generic method
            }
            else if (fileData.stream().allMatch(s ->s.matches("-?\\d+(\\. \\d+)?")))
            {
                Double[] data = fileData.stream().map(Double::parseDouble).toArray(Double[]::new);
                Double searchVal = searchValue.isEmpty() ? null : Double.parseDouble(searchValue);
                analyzeData(data, sortMethod, searchMethod, searchVal);
            }
            else
            {
                String[] data = fileData.toArray(new String[0]);
                analyzeData(data, sortMethod, searchMethod, searchValue);
            }
        }
        catch(NumberFormatException ex)
        {
            resultArea.setText("❌ Error: Invalid input detected.");
        }
    }

    private <T extends Comparable<T>> void analyzeData(T[] data, String sortMethod, String searchMethod, T searchValue)
    {
        T[] sortedData;
        if(sortMethod.equals("Bubble sort"))
        {
            sortedData = BubbleSort.sort(data);
        }
        else
        {
            sortedData = QuickSort.sort(data);
        }

        int searchResult = -1;
        if(searchValue != null)
        {
            if(searchMethod.equals("Linear Search"))
            {
                searchResult = LinearSearch.linearSearch(sortedData, searchValue);
            }
            //else nog toevoegen voor de binarySearch

            //Display the results
            String resultText = "🔄 Sorting using: " + sortMethod + "\n" +
                    "📊 Sorted Data: " + Arrays.toString(sortedData) + "\n" +
                    "\n🔍 Searching using: " + searchMethod +
                    "\n🔎 Search Value: " + searchValue +
                    "\n✅ Search Result: " +
                    (searchResult >= 0 ? "Found at index " + searchResult : "Not Found");
            resultArea.setText(resultText);
        }
    }

    private void goBack() {
        new StartScherm().setVisible(true);
        dispose();
    }
}