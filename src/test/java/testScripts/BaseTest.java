package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Generics;

import java.time.Duration;

public class BaseTest {




   protected WebDriver driver;

    @BeforeClass
    public void setup(){
        ChromeOptions ops =  new ChromeOptions();
        ops.addArguments("--headless");
        driver = new ChromeDriver( );
        driver.get(Generics.getValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterClass
    public void tearDown(){
        Generics.waitforElement(5000);
        driver.quit();
    }



}
