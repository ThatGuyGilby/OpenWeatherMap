import com.magicpythons.owm.ConnectionManager;
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

    HttpResponse<String> httpResponse;
    @Given("I have sent an HTTP request")
    public void iHaveSentAnHTTPRequest() {
        connectionManager = new ConnectionManager();
        httpClient = HttpClient.newHttpClient();
        System.out.println("Hello");
    }

    @And("it is received by the server")
    public void itIsReceivedByTheServer() {
        HttpRequest httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        HttpClient httpClient = HttpClient.newHttpClient();
        httpResponse = connectionManager.getResponse(httpClient, httpRequest);
    }

    @When("it is accepted")
    public void itIsAccepted() {
        httpResponse.statusCode();
    }

    @Then("the Status code should be valid")
    public void the_status_code_should_be_valid() {
        Assertions.assertTrue(httpResponse.statusCode()> 199 &&httpResponse.statusCode()< 203);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Given("My request has been accepted")
    public void iHaveMadeASuccessfulRequest() {
        Assertions.assertTrue(httpResponse.statusCode()> 199 &&httpResponse.statusCode()< 203);
    }

    @When("I receive a response")
    public void iReceiveAResponse() {
        Assertions.assertFalse(httpResponse.body().isEmpty());
    }

    @Then("The JSON response is converted to String")
    public void responseTypeIsString() {
        Assertions.assertTrue(httpResponse instanceof HttpResponse<String>);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


}

