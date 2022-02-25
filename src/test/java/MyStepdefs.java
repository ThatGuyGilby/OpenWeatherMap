import com.magicpythons.owm.ConnectionManager;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyStepdefs {
    private static ConnectionManager connectionManager;
    private static HttpClient httpClient;
    private static HttpResponse<String> httpResponse;
    private static HttpRequest httpRequest;

    @BeforeAll
    public static void setUp(){
        connectionManager = new ConnectionManager();
        httpClient = HttpClient.newHttpClient();
        httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        httpClient = HttpClient.newHttpClient();
        httpResponse = connectionManager.getResponse(httpClient, httpRequest);
    }

    @Given("I have sent an HTTP request")
    public void iHaveSentAnHTTPRequest() {
        Assertions.assertFalse(httpRequest.method().isEmpty());
    }

    @When("it is received by the server")
    public void itIsReceivedByTheServer() {
        Assertions.assertTrue(httpResponse.statusCode()>0);
    }

    @Then("the Status code should be valid")
    public void the_status_code_should_be_valid() {
        Assertions.assertTrue(httpResponse.statusCode()> 199 &&httpResponse.statusCode()< 203);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("I have made a successful request")
    public void iHaveMadeASuccessfulRequest() {
        Assertions.assertTrue(httpResponse.statusCode()> 199 &&httpResponse.statusCode()< 203);
    }

    @When("I get a response")
    public void iGetAResponse() {
        Assertions.assertFalse(httpResponse.body().isEmpty());
    }

    @Then("response type is HttpResponse<String>")
    public void responseTypeIsHttpResponseString() {
        Assertions.assertTrue(httpResponse instanceof HttpResponse<String>);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("I have response of type HttpResponse<String>")
    public void iHaveResponseOfTypeHttpResponseString() {
        Assertions.assertTrue(httpResponse instanceof HttpResponse<String>);
    }

    @When("I process this data")
    public void iProcessThisData() {

    }

    @Then("A DTO is created holding the response data")
    public void eachClassShouldHoldTheRelevantData() {
        //DataTransferObject
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////


}

