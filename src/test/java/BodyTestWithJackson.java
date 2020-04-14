import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.xs.XSAttributeDecl;
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

        User user = ResponseUtils.unmarshall(response, User.class);

        Assert.assertEquals( user.getLogin(), "lazarsimonovski");
    }

    @Test
    public void returnsCorrectId() throws IOException{

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        User user = ResponseUtils.unmarshall(response, User.class);

        Assert.assertEquals( user.getId(), 23380281);
    }


}
