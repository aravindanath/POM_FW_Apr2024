package testScripts.register;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import testScripts.BaseTest;

public class TC_RF_001 extends BaseTest {


    @Test
    public void TC_RF_001(){

        HomePage hp = new HomePage(driver);
        hp.navigateToRegisterPage();

        RegisterPage rp = new RegisterPage(driver);
        rp.registerWithMandatoryFields();
        rp.verifyAccountSuccessMsg();


    }
}
