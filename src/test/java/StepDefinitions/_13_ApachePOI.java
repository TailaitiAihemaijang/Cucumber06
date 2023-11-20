package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _13_ApachePOI {
    DialogContent dl = new DialogContent();
    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> tablo =
        ExcelUtility.getData("src/test/java/ApachePOI4/resource/ApacheExcel2.xlsx","testCitizen",2);
        for (ArrayList<String> satir: tablo){
            dl.myClick(dl.addButton);
            dl.mysendKeys(dl.nameInput, satir.get(0));
            dl.mysendKeys(dl.ShortName, satir.get(1));
            dl.myClick(dl.saveButton);
            dl.verifyContaionsText(dl.successMessage,"success");
        }
    }

    @Then("User delete citizensip with ApachePOI")
    public void userDeleteCitizensipWithApachePOI() {
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getData("src/test/java/ApachePOI4/resource/ApacheExcel2.xlsx","testCitizen",2);
        for (ArrayList<String> satir : tablo){
            dl.deleteItem(satir.get(0));
            dl.myClick(dl.delete);
            dl.verifyContaionsText(dl.successMessage,"success");
        }

    }
}
