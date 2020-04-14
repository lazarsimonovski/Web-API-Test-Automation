import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.xs.XSAttributeDecl;
import entities.NotFound;
import entities.RateLimit;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class BodyTestWithJackson extends BaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        User user = ResponseUtils.unmarshallGeneric(response, User.class);

        assertEquals( user.getLogin(), "lazarsimonovski");
    }

    @Test
    public void returnsCorrectId() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        User user = ResponseUtils.unmarshallGeneric(response, User.class);

        assertEquals( user.getId(), 23380281);
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexixtingendpoint");

        response = client.execute(get);

        NotFound notFoundMessage = ResponseUtils.unmarshallGeneric(response, NotFound.class);

        assertEquals(notFoundMessage.getMessage(), "Not Found");
    }

    @Test
    public void correctRateLimitsAreSet() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");

        response = client.execute(get);

        RateLimit rateLimits = ResponseUtils.unmarshallGeneric(response, RateLimit.class);

        assertEquals(rateLimits.getCoreLimit(), 60);
        //assertEquals(rateLimits.getSearchLimit(), 10);
    }

}
