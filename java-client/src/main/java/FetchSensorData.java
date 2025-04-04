import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FetchSensorData extends JFrame {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GUI gui;


    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage() throws IOException {
        out.println("get_sensor_data");
        String response = in.readLine();
        System.out.println(response);
        return response;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }



    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }




}
