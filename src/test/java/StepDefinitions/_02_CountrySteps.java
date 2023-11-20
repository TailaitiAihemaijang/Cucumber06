package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to country")
    public void navigateToCountry() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.counteries);
    }

    @When("Create a country")
    public void createACountry() {
        String ulkeAdi= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String ulkeKodu= RandomStringUtils.randomNumeric(4); // 4 rakam
        dc.myClick(dc.addButton);
        dc.mysendKeys(dc.nameInput,ulkeAdi);
        dc.mysendKeys(dc.codeInput,ulkeKodu);
        dc.myClick(dc.saveButton);
    }
    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContaionsText(dc.successMessage,"success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String arg0, String arg1) {
        dc.myClick(dc.addButton);
        dc.mysendKeys(dc.nameInput,arg0);
        dc.mysendKeys(dc.codeInput,arg1);
        dc.myClick(dc.saveButton);
    }
}
