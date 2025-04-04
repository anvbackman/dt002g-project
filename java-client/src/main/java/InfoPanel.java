import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class InfoPanel extends JPanel {

    private final JTextArea infoTextArea;
    private final BottomBarPanel bottomBarPanel;
    public InfoPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        infoTextArea = new JTextArea();
        infoTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        infoTextArea.setEditable(false);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        add(scrollPane, BorderLayout.CENTER);

        bottomBarPanel = new BottomBarPanel();
        add(bottomBarPanel, BorderLayout.SOUTH);
    }

    public void updateInfoData(String text) {
        infoTextArea.setText(text);
    }

    public JButton getBackButton() {
        return bottomBarPanel.getBackButton();
    }
}
