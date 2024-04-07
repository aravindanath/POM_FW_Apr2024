package testScripts.login;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testScripts.BaseTest;

public class TC_LF_001 extends BaseTest {


    @Test
    public void TC_LF_001(){

        String email ="Prajapat@faker.com", password = "Password@123";

        HomePage hp = new HomePage(driver);
        hp.navigateToLoginPage();

        LoginPage lp = new LoginPage(driver);
        lp.userLogin(email, password);
        lp.verifyAccountsTitle();

    }
}
