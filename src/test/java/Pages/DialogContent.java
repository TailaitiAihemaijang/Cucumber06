package Pages;

import Utilities.GWD_old;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD_old.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css = "span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement textTechnoStudy;


    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code' ]//input")
    public WebElement codeInput;
    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement ShortName;
    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;

    @FindBy(xpath = "(//ms-text-field[contains(@placeholder,'NAME')]//input)[1]")
    public WebElement searchInputName;
    @FindBy(xpath = "(//ms-text-field[contains(@placeholder,'NAME')]//input)[2]")
    public WebElement searchShortName;
    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement delete;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteOnly;
    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;
    @FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[2]")
    public List<WebElement> nameList;

    public void deleteItem(String searchText) {
        mysendKeys(searchInputName, searchText);
        myClick(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));

        myClick(delete);
        myClick(deleteOnly);


    }

    public WebElement getWebElement(String strElement) {
        switch (strElement) {
            case "addButton":
                return this.addButton;
            case "nameInput":
                return this.nameInput;
            case "saveButton":
                return this.saveButton;
            case "codeInput":
                return this.codeInput;

        }
        return null;
    }
}
