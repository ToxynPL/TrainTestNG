package TrainAwayTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
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

        return data;
    }

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
/**
   @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
**/
    @Test(dataProvider = "Test")
    public void SignIn(String username, String password) throws Exception {

        String actualBoxMsg;

        getDriver().switchTo().defaultContent();

        getDriver().findElement(By.xpath("/html/body/header/div[1]/div/div/div[3]/div[2]/div/a[2]")).click();

        getDriver().switchTo().defaultContent();
        // username
        getDriver().findElement(By.name("email")).clear();
        getDriver().findElement(By.name("email")).sendKeys(username);
        // password
        getDriver().findElement(By.name("password")).clear();
        getDriver().findElement(By.name("password")).sendKeys(password);


        // Click login
        getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[3]/form/div[3]/button")).click();
/**
        try{

            actualBoxMsg = getDriver().findElement(By.xpath("/x:html/x:body/x:div[2]/x:div/x:div[1]/x:div/x:div/x:div/x:div[3]/x:form/x:div[2]/x:span[1]/x:span")).getText();

            Assert.assertEquals(actualBoxMsg,Utill.EXPECTED_ERROR_EMAIL );
        }

        catch (NoAlertPresentException Ex){

                System.out.println("cos zle poszlo");
        }


**/



    }
}
