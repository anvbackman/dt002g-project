import javax.swing.*;
import java.awt.*;

public class LunchPanel extends JPanel {
    private final JTextArea lunchTextArea;
    private final BottomBarPanel bottomBarPanel;

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

        bottomBarPanel = new BottomBarPanel();
        add(bottomBarPanel, BorderLayout.SOUTH);
    }

    public void updateLunchData(String text) {
        lunchTextArea.setText(text);
    }

    public JButton getBackButton() {
        return bottomBarPanel.getBackButton();
    }
}
