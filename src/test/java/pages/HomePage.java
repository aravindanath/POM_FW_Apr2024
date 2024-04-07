package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Generics;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountMenu;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginButton;

    public void navigateToRegisterPage(){
        myAccountMenu.click();
        Generics.waitforElement(2000);
        registerButton.click();
    }


    public void navigateToLoginPage(){
        Generics.waitForelementToBeClickable(myAccountMenu,driver);
        myAccountMenu.click();
        Generics.waitforElement(2000);
        loginButton.click();
    }





}
