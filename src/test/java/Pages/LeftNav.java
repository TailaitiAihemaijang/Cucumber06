package Pages;

import Utilities.GWD_old;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{
    public LeftNav(){
        PageFactory.initElements(GWD_old.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setup;

    @FindBy(xpath ="(//span[text()='Parameters'])[1]" )
    public WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement counteries;
    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    public WebElement citizenShip;
@FindBy(xpath = "//span[contains(text(),'States')]")
public WebElement states;
    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "setup" : return this.setup;
            case "parameters" : return  this.parameters;
            case "counteries"  : return  this.counteries;
            case "citizenShip"  : return  this.citizenShip;
            case "states": return this.states;
        }
        return null;
    }
}
