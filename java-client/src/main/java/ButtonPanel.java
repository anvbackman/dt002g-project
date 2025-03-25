import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final JButton sensorButton;
    private final JButton lunchButton;
    private final JButton classroomBookedButton;

    public ButtonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setBackground(new Color(240, 240, 240));

        sensorButton = new JButton("Check Sensor");
        sensorButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        sensorButton.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        sensorButton.setForeground(Color.WHITE);
        sensorButton.setFocusPainted(false);
        sensorButton.setPreferredSize(new Dimension(160, 40));
        sensorButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        lunchButton = new JButton("Check Lunch");
        lunchButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        lunchButton.setBackground(new Color(237, 116, 100)); // Cornflower Blue
        lunchButton.setForeground(Color.WHITE);
        lunchButton.setFocusPainted(false);
        lunchButton.setPreferredSize(new Dimension(160, 40));
        lunchButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        classroomBookedButton = new JButton("Check Classroom");
        classroomBookedButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        classroomBookedButton.setBackground(new Color(85, 172, 37)); // Cornflower Blue
        classroomBookedButton.setForeground(Color.WHITE);
        classroomBookedButton.setFocusPainted(false);
        classroomBookedButton.setPreferredSize(new Dimension(160, 40));
        classroomBookedButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        add(sensorButton, BorderLayout.NORTH);
        add(lunchButton, BorderLayout.CENTER);
        add(classroomBookedButton, BorderLayout.SOUTH);
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
}
