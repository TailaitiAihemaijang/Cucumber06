package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD_old;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_CitizenshipSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to Citizenship")
    public void navigateToCitizenship() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenShip);

    }

    @When("Create a Citizenship")
    public void createACitizenship() {
        String citizenshipName = RandomStringUtils.randomAlphanumeric(8);
        String citizenshipCode = RandomStringUtils.randomNumeric(4);

        dc.myClick(dc.addButton);
        dc.mysendKeys(dc.nameInput, citizenshipName);
        dc.mysendKeys(dc.ShortName, citizenshipCode);
        dc.myClick(dc.saveButton);

    }

    @When("Create a Citizenship name as {string} short name as {string}")
    public void createACitizenshipNameAsShortNameAs(String arg0, String arg1) {
        dc.myClick(dc.addButton);
        dc.mysendKeys(dc.nameInput, arg0);
        dc.mysendKeys(dc.ShortName, arg1);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayd")
    public void alreadyExistMessageShouldBeDisplayd() {
        dc.verifyContaionsText(dc.alreadyExist, "already");
    }


    @When("Delet a CitizenShip name as {string} short name as {string}")
    public void deletACitizenShipNameAsShortNameAs(String arg0, String arg1) {
        dc.mysendKeys(dc.searchInputName,arg0);
        dc.mysendKeys(dc.searchShortName,arg1 + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(GWD_old.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));
        dc.myClick(dc.delete);
        dc.myClick(dc.deleteOnly);

    }
}
