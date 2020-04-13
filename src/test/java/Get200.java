import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

public class Get200 {

    public static final String BASE_ENDPOINT = "https://api.github.com";
    HttpClient client = HttpClientBuilder.create().build();

    @Test
    public void baseUrlReturnes200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        client.execute(get);
    }
}
