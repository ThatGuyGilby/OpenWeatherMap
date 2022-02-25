import com.magicpythons.owm.ConnectionManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyStepdefs {
    private static ConnectionManager connectionManager;
    private static HttpClient httpClient;

    @BeforeAll
            


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



    @Then("The JSON response is converted to String")
    public void responseTypeIsString() {

    }

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
    //////////////////////////////////////////////////////////

    @Given("I have response of type HttpResponse<String>")
    public void iHaveResponseOfTypeHttpResponseString() {
    }

    @When("I process this data")
    public void iProcessThisData() {
    }

    @Then("Each Class should hold the relevant data")
    public void eachClassShouldHoldTheRelevantData() {
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


}

