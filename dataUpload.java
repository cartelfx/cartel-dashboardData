import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DashboardDataUploader {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("API URL");

        try {
            String jsonData = "{ \"username\": \"example_user\", \"data\": \"your_data\" }";

            StringEntity entity = new StringEntity(jsonData);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
          System.out.println("HTTP Response: " + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
