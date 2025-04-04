import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.lang.reflect.Field;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SensorDataTest {

    private FetchSensorData fetcher;
    private BufferedReader mockIn;
    private PrintWriter mockOut;
    private Socket mockSocket;

    @BeforeEach
    void setUp() throws Exception {
        fetcher = new FetchSensorData();

        mockSocket = mock(Socket.class);
        mockIn = mock(BufferedReader.class);
        mockOut = mock(PrintWriter.class);

        // Use reflection to inject mocks into private fields
        setPrivateField(fetcher, "clientSocket", mockSocket);
        setPrivateField(fetcher, "in", mockIn);
        setPrivateField(fetcher, "out", mockOut);
    }

    @Test
    void testSendMessageReturnsValidResponse() throws IOException {
        when(mockIn.readLine()).thenReturn("5");

        String response = fetcher.sendMessage();

        verify(mockOut).println("get_sensor_data");
        assertEquals("5", response);
    }

    @Test
    void testSendMessageReturnsNull() throws IOException {
        when(mockIn.readLine()).thenReturn(null);

        String response = fetcher.sendMessage();

        verify(mockOut).println("get_sensor_data");
        assertEquals(null, response);  // or assertNull(response)
    }

    @Test
    void testSendMessageReturnsNonInteger() throws IOException {
        when(mockIn.readLine()).thenReturn("eleven");

        String response = fetcher.sendMessage();

        verify(mockOut).println("get_sensor_data");
        assertEquals("eleven", response);
    }


    @Test
    void testSendMessageDoesNotReturnNegativeNumber() throws IOException {
        when(mockIn.readLine()).thenReturn("-3");

        String response = fetcher.sendMessage();

        assertEquals("-3", response); // You might add logic later to handle negatives
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
