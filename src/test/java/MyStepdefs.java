import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("I have sent an HTTP request")
    public void iHaveSentAnHTTPRequest() {
        System.out.println("Hello");
    }

    @And("it is received by the server")
    public void itIsReceivedByTheServer() {
    }

    @When("it is accepted")
    public void itIsAccepted() {
    }

    @Then("the Status code should be {int}XX")
    public void theStatusCodeShouldBeXX(int arg0) {
    }
}
