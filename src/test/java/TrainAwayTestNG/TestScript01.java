package TrainAwayTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Krzysztof on 2017-03-26.
 */
public class TestScript01 {
    public WebDriver driver;
    public static String baseUrl;
//test

    @BeforeMethod
    public void setUp() throws Exception {

        String firefox = Utill.firefox;
        String geckodriver = Utill.geckodriver;
        System.setProperty(geckodriver,firefox);

        driver = new FirefoxDriver();

        baseUrl = Utill.BASE_URL;
        driver.manage().timeouts().implicitlyWait(Utill.WaitTime, TimeUnit.SECONDS);
        driver.get(baseUrl);

        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();


    }
    WebDriver getDriver(){
        return driver;
    }

    @Test
    public void testCase01(){

        getDriver().findElement(By.name("SIGN IN")).click();



    }
}
