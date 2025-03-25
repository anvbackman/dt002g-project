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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        schoolPanel = new SchoolPanel();
        buttonPanel = new ButtonPanel();
        sensorTextArea = new JTextArea();

        schoolPanel.add(buttonPanel, BorderLayout.NORTH);

        sensorTextArea.setEditable(false);
        sensorTextArea.setLineWrap(true);
        sensorTextArea.setWrapStyleWord(true);

//        String response = this.fetchSensorData.sendMessage();


        schoolPanel.add(sensorTextArea, BorderLayout.CENTER);

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
