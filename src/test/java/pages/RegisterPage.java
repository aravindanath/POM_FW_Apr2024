package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Generics;

public class RegisterPage  extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='input-firstname']")
    public WebElement firstNameTextArea;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public WebElement lastNameTextArea;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement emailTextArea;

    @FindBy(xpath = "//input[@id='input-telephone']")
    public WebElement telephoneTextArea;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement passwordTextArea;

    @FindBy(xpath = "//input[@id='input-confirm']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement privacyPolicyCb;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    public WebElement successMsg;




    public void registerWithMandatoryFields(){
        firstNameTextArea.sendKeys(Generics.firstName());
        lastNameTextArea.sendKeys(Generics.lastName());
        String email = Generics.email();
        System.out.println("Email: " + email);
        emailTextArea.sendKeys(email);
        telephoneTextArea.sendKeys(Generics.mobileNumber());
        passwordTextArea.sendKeys(Generics.password());
        confirmPassword.sendKeys(Generics.password());
        privacyPolicyCb.click();
        Generics.waitforElement(3000);
        continueButton.click();
    }


    public void verifyAccountSuccessMsg(){
        System.out.println("Msg: "+successMsg.getText());
        Generics.verifyTitle(successMsg,"Your Account Has Been Created!");
        Generics.takeScreenshot(driver);
    }




}
