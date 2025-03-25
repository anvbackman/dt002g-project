import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SensorPanel extends JPanel {

    private final JTextArea sensorTextArea;
    private final JButton backButton;

    public SensorPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        sensorTextArea = new JTextArea();
        sensorTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sensorTextArea.setEditable(false);
        sensorTextArea.setLineWrap(true);
        sensorTextArea.setWrapStyleWord(true);
        sensorTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(sensorTextArea);
        add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(100, 40));
        JPanel backPanel = new JPanel();
        backPanel.add(backButton);

        add(backPanel, BorderLayout.SOUTH);
    }

    public void updateSensorData(String text) {
        sensorTextArea.setText(text);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
