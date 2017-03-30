package TrainAwayTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Krzysztof on 2017-03-28.
 */
public class TestScript02 {

    public WebDriver driver;
    public static String baseUrl;

    @Parameters({ "browser" })
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")) {

            String firefox = Utill.firefox;
            String geckodriver = Utill.geckodriver;
            System.setProperty(geckodriver, firefox);

            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {

            String chrome = Utill.chrome;
            String chromedriver = Utill.chromedriver;
            System.setProperty(chromedriver, chrome);


            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {

            String IE = Utill.IE;
            String IEdriver = Utill.IEdriver;
            System.setProperty(IEdriver, IE);


            driver = new InternetExplorerDriver();
        }

        baseUrl = Utill.BASE_URL;
        driver.manage().timeouts().implicitlyWait(Utill.WaitTime, TimeUnit.SECONDS);
        driver.get(baseUrl);



        if (browser.equalsIgnoreCase("firefox")) {
            Alert alertOK = driver.switchTo().alert();
            alertOK.accept();
        }

        driver.manage().window().maximize();

    }

    WebDriver getDriver(){
        return driver;
    }

    @Test
    public void chromeCheck() throws Exception {


        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("/html/body/header/div[1]/div/div/div[3]/div[2]/div/a[2]")).click();
        System.out.println("Udało się?");
    }

}