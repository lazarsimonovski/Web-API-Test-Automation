import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.xs.XSAttributeDecl;
import entities.NotFound;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BodyTestWithJackson extends BaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        User user = ResponseUtils.unmarshallGeneric(response, User.class);

        Assert.assertEquals( user.getLogin(), "lazarsimonovski");
    }

    @Test
    public void returnsCorrectId() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        User user = ResponseUtils.unmarshallGeneric(response, User.class);

        Assert.assertEquals( user.getId(), 23380281);
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexixtingendpoint");

        response = client.execute(get);

        NotFound notFoundMessage = ResponseUtils.unmarshallGeneric(response, NotFound.class);

        Assert.assertEquals(notFoundMessage.getMessage(), "Not Found");
    }

}
