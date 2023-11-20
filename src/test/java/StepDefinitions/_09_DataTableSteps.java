package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _09_DataTableSteps {
    LeftNav ln  = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Click on the elment in LeftNav")
    public void clickOnTheElmentInLeftNav(DataTable linkler) {

        List<String> strlinkList =linkler.asList(String.class);

        for (String strlink : strlinkList){
            WebElement linkWebElement = ln.getWebElement(strlink);
            ln.myClick(linkWebElement);
        }
    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable linkler) {
        List<String> strlinkList = linkler.asList(String.class);

        for (int i = 0;i < strlinkList.size();i++){
            WebElement linkWebElement = dc.getWebElement(strlinkList.get(i));
            dc.myClick(linkWebElement);
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dt) {

        List< List<String> >   items=  dt.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement e=dc.getWebElement(items.get(i).get(0)); // 0. webelement
            String yazi = items.get(i).get(1);//1. yazısı

            dc.mysendKeys(e, yazi);
        }
    }

    @And("User delete the element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable delet) {
        List<String> deltes = delet.asList(String.class);
        for (int i = 0;i < deltes.size();i++){
            dc.deleteItem(deltes.get(i));
        }


    }
}
