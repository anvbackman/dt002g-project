import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final JButton sensorButton;

    public ButtonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        sensorButton = new JButton("Sensor");
        add(sensorButton, BorderLayout.CENTER);
        sensorButton.setFocusable(false);
    }

    public JButton getSensorButton() {
        return sensorButton;
    }
}
