package TrainAwayTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Krzysztof on 2017-03-26.
 */
public class TestScript01 {
    private WebDriver driver; // Selenium control driver
    private String baseUrl; // baseUrl of Trainaway website
//test

    @BeforeMethod
    public void setUp() throws Exception {

    String firefox = Utill.firefox;
    String geckodriver = Utill.geckodriver;
    System.setProperty(geckodriver,firefox);

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        driver = new FirefoxDriver(firefoxProfile);

        baseUrl = Utill.BASE_URL;
        driver.manage().timeouts().implicitlyWait(Utill.WaitTime, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }
    @Test
    public void testCase01(){

        driver.findElement(By.name("SIGN IN")).click();



    }
}
