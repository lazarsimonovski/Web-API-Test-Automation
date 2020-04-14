import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class BodyTestWithSimpleMap extends BaseClass{

    @Test
    public void returnesCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        System.out.println(jsonBody);
    }
}
