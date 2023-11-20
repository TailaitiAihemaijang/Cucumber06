package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

public class _14_JDBCSteps {
    DialogContent el = new DialogContent();
    @Then("Send The Query the Database {string} and control math")
    public void sendTheQueryTheDatabaseAndControlMath(String sql) {

        // db den oku
        // Web den UI dan oku
        // karislastir
        DBUtility db = new DBUtility();
       List<List<String>> dataList = db.getDataList(sql);
//        for (List<String> ls : dataList){
//            System.out.println(ls);
//        }
        List<WebElement> UIList = el.nameList;
//        for (int i = 0;i< UIList.size();i++){
//            System.out.println(UIList.get(i).getText());
//        }

        for (int i = 0;i < dataList.size();i++){
            Assert.assertEquals(dataList.get(i).get(0).trim(),UIList.get(i).getText().trim(),"Eslestirme yapilmadi");
        }
    }
}
