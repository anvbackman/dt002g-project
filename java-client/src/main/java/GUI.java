import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {
    private FetchSensorData fetchSensorData = null;
    private JPanel mainPanel;
    private ButtonPanel buttonPanel;
    private JTextArea sensorTextArea;
    private String sensorText;
    private final CardLayout cardLayout;
    private final SensorPanel sensorPanel;
    private final LunchPanel lunchPanel;
    private final ClassroomPanel classroomPanel;
    private final InfoPanel infoPanel;

//    private String text;
    public GUI() throws IOException {
//        this.fetchSensorData = fetchSensorData;
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
        infoPanel = new InfoPanel();
        classroomPanel = new ClassroomPanel();

        setupMainMenu(); // Connect buttons

        mainPanel.add(buttonPanel, "menu");
        mainPanel.add(sensorPanel, "sensor");
        mainPanel.add(lunchPanel, "lunch");
        mainPanel.add(infoPanel, "information");
        mainPanel.add(classroomPanel, "classrooms");

        add(mainPanel);
        cardLayout.show(mainPanel, "menu"); // Start with main menu

        setVisible(true);

    }

    private void setupMainMenu() {
        buttonPanel.getSensorButton().addActionListener(e -> {
            try {
                if (fetchSensorData == null) {
                    fetchSensorData = new FetchSensorData();
                    fetchSensorData.startConnection("127.0.0.1", 65432);
                }
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

        buttonPanel.getInfoButton().addActionListener(e -> {
            infoPanel.updateInfoData("Welcome to School Tool, an easy to use tool for you every day campus needs!\n" +
                    "Business inquiries in at mail.com");
            cardLayout.show(mainPanel, "information");
        });

        sensorPanel.getBackButton().addActionListener(e ->
                cardLayout.show(mainPanel, "menu")
        );

        lunchPanel.getBackButton().addActionListener(e ->
                cardLayout.show(mainPanel, "menu")
        );

        classroomPanel.getBackButton().addActionListener(e ->
                cardLayout.show(mainPanel, "menu")
        );

        infoPanel.getBackButton().addActionListener(e ->
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
