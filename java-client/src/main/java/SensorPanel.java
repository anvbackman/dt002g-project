import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SensorPanel extends JPanel {

    private final JTextArea sensorTextArea;
    private final BottomBarPanel bottomBarPanel;

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

        bottomBarPanel = new BottomBarPanel();
        add(bottomBarPanel, BorderLayout.SOUTH);
    }

    public void updateSensorData(String text) {
        sensorTextArea.setText(text);
    }

    public JButton getBackButton() {
        return bottomBarPanel.getBackButton();
    }
}
