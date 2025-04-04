import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final JButton sensorButton;
    private final JButton lunchButton;
    private final JButton classroomBookedButton;
    private final JButton infoButton;

    public ButtonPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // spacing between buttons

        sensorButton = createStyledButton("Check Sensor", new Color(100, 149, 237));
        lunchButton = createStyledButton("Check Lunch", new Color(237, 116, 100));
        classroomBookedButton = createStyledButton("Check Classroom", new Color(85, 172, 37));
        infoButton = createStyledButton("Information", new Color(154, 37, 172));

        // Position buttons in a 2x2 grid
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sensorButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(lunchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(classroomBookedButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(infoButton, gbc);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(250, 250));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return button;
    }

    public JButton getSensorButton() {
        return sensorButton;
    }

    public JButton getLunchButton() {
        return lunchButton;
    }

    public JButton getClassroomBookedButton() {
        return classroomBookedButton;
    }

    public JButton getInfoButton() {
        return infoButton;
    }
}
