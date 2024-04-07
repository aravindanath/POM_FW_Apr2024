package testScripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class ExampleReport {


    @Test
    public void extTest(){
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark =  new ExtentSparkReporter("./testReport.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setReportName("Arvind");
        spark.config().setDocumentTitle("Regression Report");
        extent.attachReporter(spark);

       ExtentTest test1 =  extent.createTest("Login");
        test1.pass("Login test pass");
        test1.fail("Login test fail");
        test1.info("User is on login page");
        test1.warning("User on log out page");

        ExtentTest test =  extent.createTest("Register");
        test.pass("Login test pass");
       // test.fail("Login test fail");
        test.info("User is on login page");
    //    test.warning("User on log out page");
       extent.flush();




    }
}
