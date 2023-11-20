package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD_old;
import io.cucumber.java.en.*;


public class _01_LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigate_to_campus() {
        GWD_old.getDriver().get("https://test.mersys.io/");

    }

    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
        dc.mysendKeys(dc.username, "turkeyts");
        dc.mysendKeys(dc.password, "TechnoStudy123");
        dc.myClick(dc.loginButton);

    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        dc.verifyContaionsText(dc.textTechnoStudy,"Techno Study");
    }
}
