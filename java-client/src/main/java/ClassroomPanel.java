import javax.swing.*;
import java.awt.*;

public class ClassroomPanel extends JPanel {

    private final JTextArea classroomTextArea;
    private final BottomBarPanel bottomBarPanel;


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

        bottomBarPanel = new BottomBarPanel();
        add(bottomBarPanel, BorderLayout.SOUTH);
    }

    public void updateClassroomData(String text) {
        classroomTextArea.setText(text);
    }

    public JButton getBackButton() {
        return bottomBarPanel.getBackButton();
    }
}
