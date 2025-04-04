import javax.swing.*;
import java.awt.*;

public class BottomBarPanel extends JPanel {

    private final JButton backButton;

    public BottomBarPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Align back button to the left
        setBackground(Color.LIGHT_GRAY); // Optional: style the bar

        backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(100, 40));

        add(backButton);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
