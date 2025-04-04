import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleFetcher {



    public static void main(String[] args) throws Exception {
        String authUrl = "https://schema.dsv.nu/admin/Web/Services/Authentication/Authenticate";
        String reservationUrl = "https://schema.dsv.nu/admin/Web/Services/Reservations/";

        CloseableHttpClient client = HttpClients.createDefault();

        // Step 1: Authenticate
        HttpPost authRequest = new HttpPost(authUrl);
        String authJson = "{\"username\": \"dsvschema\", \"password\": \"ds09sdkjhw45\"}";
        authRequest.setEntity(EntityBuilder.create()
                .setText(authJson)
                .setContentType(ContentType.APPLICATION_JSON)
                .build());

        String authResponseStr = EntityUtils.toString(client.execute(authRequest).getEntity());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode authJsonNode = mapper.readTree(authResponseStr);

        String token = authJsonNode.get("sessionToken").asText();
        String userId = authJsonNode.get("userId").asText();

        // Step 2: Fetch Reservations
        HttpGet reservationRequest = new HttpGet(reservationUrl);
        reservationRequest.addHeader("X-Booked-SessionToken", token);
        reservationRequest.addHeader("X-Booked-UserId", userId);

        String reservationResponseStr = EntityUtils.toString(client.execute(reservationRequest).getEntity());
        JsonNode reservationJson = mapper.readTree(reservationResponseStr);

        JsonNode reservations = reservationJson.get("reservations");

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        if (reservations != null && reservations.isArray()) {
            for (JsonNode reservation : reservations) {
                JsonNode roomNode = reservation.get("resourceName");
                JsonNode startDateNode = reservation.get("startDate");
                JsonNode endDateNode = reservation.get("endDate");


                if (roomNode != null && startDateNode != null && endDateNode != null) {
                    String room = roomNode.asText();

                    if ("Björnidet (Q167b)".equals(room) || "Hundkojan (Q167a)".equals(room)) {
                        ZonedDateTime start = ZonedDateTime.parse(startDateNode.asText(), inputFormatter);
                        ZonedDateTime end = ZonedDateTime.parse(endDateNode.asText(), inputFormatter);

                        String date = start.format(dateFormatter);
                        String startTime = start.format(timeFormatter);
                        String endTime = end.format(timeFormatter);

                        System.out.println(room + " is booked on " + date + " from " + startTime + " to " + endTime);
                    }
                }
            }
        } else {
            System.out.println("No reservations found.");
        }

        client.close();
    }
}
