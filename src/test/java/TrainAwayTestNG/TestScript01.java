package TrainAwayTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static TrainAwayTestNG.Utill.profilepath;

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


        FirefoxProfile firefoxProfile = new FirefoxProfile(new File(profilepath));
        driver = new FirefoxDriver(firefoxProfile);

        baseUrl = Utill.BASE_URL;
        driver.manage().timeouts().implicitlyWait(Utill.WaitTime, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }
//jest to po to ze jak np. masz jakies inne przegladarki albo inne karty to sie selenium nie zgubi
    WebDriver getDriver(){
        return driver;
    }

    @Test
    public void testCase01(){

        getDriver().findElement(By.name("SIGN IN")).click();



    }
}
