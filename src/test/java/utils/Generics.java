package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Properties;

public class Generics {


//https://github.com/DiUS/java-faker
    public static String firstName(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().firstName();
    }

    public static String lastName(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().lastName();
    }

    public static String email(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().lastName()+"@faker.com";
    }

    public static String mobileNumber(){
        Faker faker = new Faker();
        return faker.number().digits(10);
    }

    public static String password(){
        return "Password@123";
    }

    public static void verifyTitle(WebElement element, String title){
        Assert.assertEquals(element.getText(), title,"Title Not Match");
    }


    public static String getValue(String key){
        String path= System.getProperty("user.dir")+ File.separator+"config.properties";
        String value = null;
        try{
            FileInputStream fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);
            value = properties.getProperty(key);

        } catch (Exception e) {
        }
        return  value;
    }


    public static void waitforElement(long timeout){

        try{
            Thread.sleep(timeout);
        }catch (Exception ex){

        }

    }


    public static void waitForelementToBeClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static String timestamp(){
        LocalDateTime ld =  LocalDateTime.now();
        return ld.toString().replace("-","_").replace(":","_").replace(".","_");

    }

    public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./screenshot" + timestamp() + ".png");
            FileUtils.copyFile(srcFile, destFile);
        }catch (Exception e){}
    }


}
