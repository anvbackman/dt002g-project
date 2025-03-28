import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        FetchSensorData fetchSensorData = new FetchSensorData();
//        fetchSensorData.startConnection("127.0.0.1", 65432);
//
//
//        SwingUtilities.invokeLater(() -> {
//            try {
//                new GUI(fetchSensorData);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

        SwingUtilities.invokeLater(() -> {
            try {
                new GUI();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
