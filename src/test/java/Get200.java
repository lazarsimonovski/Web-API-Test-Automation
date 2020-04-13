import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

public class Get200 {

    @Test
    public  void baseUrlReturns200(){
        HttpGet get = new HttpGet("https://api.github.com");
    }
}
