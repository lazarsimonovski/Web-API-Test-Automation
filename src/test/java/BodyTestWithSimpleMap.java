import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static entities.User.ID;

public class BodyTestWithSimpleMap extends BaseClass{

    @Test
    public void returnesCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject (jsonBody);

        String loginValue = (String) getValuefor(jsonObject, "login");

        Assert.assertEquals(loginValue, "lazarsimonovski");
    }

    @Test
    public void returnesCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/lazarsimonovski");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject (jsonBody);

        Integer loginValue = (Integer) getValuefor(jsonObject, ID);

        Assert.assertEquals(loginValue, Integer.valueOf(23380281));
    }

    private Object getValuefor(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }
}
