import javax.swing.*;
import java.awt.*;

public class LunchPanel extends JPanel {
    private final JTextArea lunchTextArea;
    private final JButton backButton;


    public LunchPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        lunchTextArea = new JTextArea();
        lunchTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lunchTextArea.setEditable(false);
        lunchTextArea.setLineWrap(true);
        lunchTextArea.setWrapStyleWord(true);
        lunchTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(lunchTextArea);
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

    public void updateLunchData(String text) {
        lunchTextArea.setText(text);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
