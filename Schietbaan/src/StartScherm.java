import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class StartScherm extends JFrame
{
    private JComboBox<String> schutterSelectie;
    private JComboBox<Integer> aantalSchotenSelectie;
    private JComboBox<String> positieSelectie;
    private List<String> schuttersLijst = new ArrayList<>();

    public StartScherm()
    {
        setTitle("Start Schietsessie");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // **Schutter-selectie**
        add(new JLabel("Schutter:"));
        schutterSelectie = new JComboBox<>();
        schutterSelectie.addItem("Nieuwe schutter toevoegen...");
        schutterSelectie.addActionListener(e -> checkNieuweSchutter());
        add(schutterSelectie);

        // **Aantal schoten-selectie**
        add(new JLabel("Aantal schoten:"));
        aantalSchotenSelectie = new JComboBox<>(new Integer[]{10, 20, 30, 40, 50, 60});
        add(aantalSchotenSelectie);

        // **Positie-selectie**
        add(new JLabel("Positie:"));
        positieSelectie = new JComboBox<>(new String[]{"Staand", "Opgelegd"});
        add(positieSelectie);

        // **Startknop**
        JButton startButton = new JButton("Start sessie");
        startButton.addActionListener(this::startSchietsessie);
        add(startButton);
    }

    private void checkNieuweSchutter()
    {
        if (schutterSelectie.getSelectedItem().equals("Nieuwe schutter toevoegen..."))
        {
            String nieuweNaam = JOptionPane.showInputDialog(this, "Voer naam van nieuwe schutter in:");
            if (nieuweNaam != null && !nieuweNaam.trim().isEmpty())
            {
                schuttersLijst.add(nieuweNaam);
                schutterSelectie.insertItemAt(nieuweNaam, 0);
                schutterSelectie.setSelectedIndex(0);
            }
        }
    }

    private void startSchietsessie(ActionEvent e)
    {
        String schutter = (String) schutterSelectie.getSelectedItem();
        int aantalSchoten = (Integer) aantalSchotenSelectie.getSelectedItem();
        String positie = (String) positieSelectie.getSelectedItem();

        new SchietbaanGUI(schutter, aantalSchoten, positie).setVisible(true);
        dispose();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new StartScherm().setVisible(true));
    }
}
