import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {
    private FetchSensorData fetchSensorData;
    private JPanel mainPanel;
    private ButtonPanel buttonPanel;
    private JTextArea sensorTextArea;
    private String sensorText;
    private final CardLayout cardLayout;
    private final SensorPanel sensorPanel;
    private final LunchPanel lunchPanel;
    private final ClassroomPanel classroomPanel;

//    private String text;
    public GUI(FetchSensorData fetchSensorData) throws IOException {
        this.fetchSensorData = fetchSensorData;
        setTitle("School Tool");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize main menu and sensor view
        buttonPanel = new ButtonPanel();
        sensorPanel = new SensorPanel();
        lunchPanel = new LunchPanel();
        classroomPanel = new ClassroomPanel();

        setupMainMenu(); // Connect buttons

        mainPanel.add(buttonPanel, "menu");
        mainPanel.add(sensorPanel, "sensor");
        mainPanel.add(lunchPanel, "lunch");
        mainPanel.add(classroomPanel, "classrooms");

        add(mainPanel);
        cardLayout.show(mainPanel, "menu"); // Start with main menu

        setVisible(true);

    }

    private void setupMainMenu() {
        buttonPanel.getSensorButton().addActionListener(e -> {
            try {
                String response = fetchSensorData.sendMessage();
                sensorPanel.updateSensorData("Current number of people: " + response);
                cardLayout.show(mainPanel, "sensor");
            } catch (IOException ex) {
                sensorPanel.updateSensorData("Error fetching data.");
                ex.printStackTrace();
            }
        });

        buttonPanel.getLunchButton().addActionListener(e -> {
            lunchPanel.updateLunchData("Todays Lunch is: ");
            cardLayout.show(mainPanel, "lunch");
        });

        buttonPanel.getClassroomBookedButton().addActionListener(e -> {
            classroomPanel.updateClassroomData("The classrooms booked is: ");
            cardLayout.show(mainPanel, "classrooms");
        });

        // Sensor panel back button returns to menu
        sensorPanel.getBackButton().addActionListener(e ->
                cardLayout.show(mainPanel, "menu")
        );

        lunchPanel.getBackButton().addActionListener(e ->
                cardLayout.show(mainPanel, "menu")
        );

        classroomPanel.getBackButton().addActionListener(e ->
                cardLayout.show(mainPanel, "menu")
        );

    }

//    private void setupButtonPanel() {
//        buttonPanel.getSensorButton().addActionListener(e -> {
//            try {
//                String response = fetchSensorData.sendMessage();
//                sensorPanel.updateSensorData("Current number of people: " + response);
//                cardLayout.show(mainPanel, "sensor");
//            } catch (IOException ex) {
//                sensorPanel.updateSensorData("Error fetching data.");
//                ex.printStackTrace();
//            }
//        });
//
//        // Sensor panel back button returns to menu
//        sensorPanel.getBackButton().addActionListener(e ->
//                cardLayout.show(mainPanel, "menu")
//        );
//    }

    public void setSensorTextArea(String text) {
        sensorTextArea.setText(text);
    }
}
