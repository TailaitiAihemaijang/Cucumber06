package Pages;

import Utilities.GWD_old;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent{
    WebDriverWait wait = new WebDriverWait(GWD_old.getDriver(), Duration.ofSeconds(20));
    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void mysendKeys(WebElement elment, String yazi) {
        wait.until(ExpectedConditions.visibilityOf(elment));
        elment.clear();
        elment.sendKeys(yazi);
    }

    public void scrollToElement(WebElement elmant){
        JavascriptExecutor js = (JavascriptExecutor) GWD_old.getDriver();
        js.executeScript("arguments[0].scrolIntoView(true);",elmant);
    }

    public void verifyContaionsText(WebElement element,String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }
}
