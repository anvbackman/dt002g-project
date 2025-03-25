import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {
    private FetchSensorData fetchSensorData;
    private SchoolPanel schoolPanel;
    private ButtonPanel buttonPanel;
    private JTextArea sensorTextArea;
    private String sensorText;
//    private String text;
    public GUI(FetchSensorData fetchSensorData) throws IOException {
        this.fetchSensorData = fetchSensorData;
        setTitle("School Tool");
        setSize(800, 800);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        schoolPanel = new SchoolPanel();
        buttonPanel = new ButtonPanel();

        // Styled sensor text area
        sensorTextArea = new JTextArea(10, 30);
        sensorTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sensorTextArea.setEditable(false);
        sensorTextArea.setLineWrap(true);
        sensorTextArea.setWrapStyleWord(true);
        sensorTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        sensorTextArea.setMargin(new Insets(10, 10, 10, 10));

        // Scroll pane around text area
        JScrollPane scrollPane = new JScrollPane(sensorTextArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to school panel
        schoolPanel.add(buttonPanel, BorderLayout.NORTH);
        schoolPanel.add(scrollPane, BorderLayout.CENTER);

        add(schoolPanel);
        setupButtonPanel();

        setVisible(true);

    }

    private void setupButtonPanel() {
        buttonPanel.getSensorButton().addActionListener(e -> {
            try {
                String response = fetchSensorData.sendMessage();
                sensorTextArea.setText("Current amount of people: " + response);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void setSensorTextArea(String text) {
        sensorTextArea.setText(text);
    }
}
