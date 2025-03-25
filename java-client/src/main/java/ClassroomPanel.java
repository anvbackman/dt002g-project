import javax.swing.*;
import java.awt.*;

public class ClassroomPanel extends JPanel {

    private final JTextArea classroomTextArea;
    private final JButton backButton;


    public ClassroomPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        classroomTextArea = new JTextArea();
        classroomTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        classroomTextArea.setEditable(false);
        classroomTextArea.setLineWrap(true);
        classroomTextArea.setWrapStyleWord(true);
        classroomTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(classroomTextArea);
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

    public void updateClassroomData(String text) {
        classroomTextArea.setText(text);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
