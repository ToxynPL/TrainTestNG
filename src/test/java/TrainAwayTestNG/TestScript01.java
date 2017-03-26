package TrainAwayTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

/**
    @DataProvider(name = "Test")
    public Object[][] testData(){

        Object[][] data = new Object[4][2];

        //1st row
        data[0][0] = Utill.USER_NAME;
        data[0][1] = Utill.PASSWORD;

        //1st row
        data[1][0] = "invalid";
        data[1][1] = Utill.PASSWORD;

        //1st row
        data[2][0] = Utill.USER_NAME;
        data[2][1] = "invalid";

        //1st row
        data[3][0] = "invalid";
        data[3][1] = "invalid";

    }
    **/
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

        driver.manage().window().maximize();

    }
    WebDriver getDriver(){
        return driver;
    }

   /** @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
**/
    @Test//(dataProvider = "Test")
    public void testCase01() throws Exception {



// tu nie wiem co wpisac bo nie moglem znalesc
        getDriver().switchTo().frame();










    }
}
