package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Generics;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement emailtextField;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement passwordTextField;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountTitle;




    public void userLogin(String email, String password){
        emailtextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        Generics.waitforElement(3000);
        loginButton.click();
    }

    public void verifyAccountsTitle(){
        Generics.verifyTitle(myAccountTitle,"My Account");
        Generics.takeScreenshot(driver);
    }



}
