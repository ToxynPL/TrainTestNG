package TrainAwayTestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
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

    @Parameters({ "browser" })

    @BeforeMethod
    public void setUp(@Optional ("firefox") String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")){

            String firefox = Utill.firefox;
            String geckodriver = Utill.geckodriver;
            System.setProperty(geckodriver,firefox);

            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {

            String chrome = Utill.chrome;
            String chromedriver = Utill.chromedriver;
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            System.setProperty(chromedriver,chrome);


            driver = new ChromeDriver(options);
        }

        else if (browser.equalsIgnoreCase("IE")) {

            String IE = Utill.IE;
            String IeDriver = Utill.IEdriver;
            System.setProperty(IeDriver,IE);


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

        Thread.sleep(5000);


        try{

            getDriver().switchTo().defaultContent();
            actualBoxMsg = getDriver().findElement(By.cssSelector("html.ng-scope body header.header div.header-inner div.container div.row.flex-sm div.col-xs-12.col-sm-5.col-md-4.flex-sm-2.nav-header div.nav-header__item.profile.text-right.ng-scope span.profile__text.ng-binding")).getText();

            Assert.assertEquals(actualBoxMsg,Utill.Profile);
        }

        catch (NoSuchElementException Ex){

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            int mil = calendar.get(Calendar.MILLISECOND);


            File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\tmp\\screenshoot"+ hour + minute + sec + mil +".png"));
            System.out.println("An error message has been catch and it's stored in tmp folder on the desktop");
        }
    }

    @Test
    public void SignInFb() throws Exception  {

        String actualBoxMsg;

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("/html/body/header/div[1]/div/div/div[3]/div[2]/div/a[2]")).click();
        getDriver().switchTo().defaultContent();

        // Fb click
        getDriver().findElement(By.cssSelector("html.ng-scope body div.ng-scope div.ng-scope div.sign-bg.ng-scope div.sign-content div.sign-content__inner div.container div.block-sign div.col-sm-6.sign-link-wrapper a.sign-link.facebook")).click();
        Thread.sleep(2000);

        List<String>window = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println("size "+window.size());
        getDriver().switchTo().window(window.get(1));
        System.out.println("switching to the other window");

        getDriver().manage().window().maximize();
        getDriver().findElement(By.id("email")).sendKeys(Utill.FBemail);
        getDriver().findElement(By.id("pass")).sendKeys(Utill.FBpass);
        getDriver().findElement(By.cssSelector("html#facebook body.login_page.booklet.gecko.win.x1.Locale_en_US div#booklet div#content.fb_content.clearfix div.login_form_container form#login_form div#loginform div#buttons.form_row.clearfix label#loginbutton.uiButton.uiButtonConfirm.uiButtonLarge input#u_0_2")).click();
        Thread.sleep(5000);

        System.out.println("closing the window");
        System.out.println("switchig to parent window");
        getDriver().switchTo().window(window.get(0));

        try{

            getDriver().switchTo().defaultContent();
            actualBoxMsg = getDriver().findElement(By.cssSelector("html.ng-scope body header.header div.header-inner div.container div.row.flex-sm div.col-xs-12.col-sm-5.col-md-4.flex-sm-2.nav-header div.nav-header__item.profile.text-right.ng-scope span.profile__text.ng-binding")).getText();

            Assert.assertEquals(actualBoxMsg,Utill.Profile);
        }

        catch (NoSuchElementException Ex){

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            int mil = calendar.get(Calendar.MILLISECOND);

            File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\tmp\\screenshoot"+ hour + minute + sec + mil +".png"));
            System.out.println("An error message has been catch and it's stored in tmp folder on the desktop");
        }
    }

    @Test
    public void SignInGp() throws Exception {

        String actualBoxMsg;

        //SignIn click
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("/html/body/header/div[1]/div/div/div[3]/div[2]/div/a[2]")).click();
        getDriver().switchTo().defaultContent();

        //Google signin
        getDriver().findElement(By.cssSelector("html.ng-scope body div.ng-scope div.ng-scope div.sign-bg.ng-scope div.sign-content div.sign-content__inner div.container div.block-sign div.col-sm-6.sign-link-wrapper a.sign-link.google")).click();
        Thread.sleep(2000);

        List<String>window = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println("size "+window.size());
        getDriver().switchTo().window(window.get(1));
        System.out.println("switching to the other window");

        getDriver().manage().window().maximize();
        getDriver().findElement(By.id("Email")).sendKeys(Utill.Gmail);
        getDriver().findElement(By.id("next")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.id("Passwd")).sendKeys(Utill.Gpass);
        getDriver().findElement(By.id("signIn")).click();
        Thread.sleep(5000);
        System.out.println("closing the window");

        System.out.println("switchig to parent window");
        getDriver().switchTo().window(window.get(0));

        try{

            getDriver().switchTo().defaultContent();
            actualBoxMsg = getDriver().findElement(By.cssSelector("html.ng-scope body header.header div.header-inner div.container div.row.flex-sm div.col-xs-12.col-sm-5.col-md-4.flex-sm-2.nav-header div.nav-header__item.profile.text-right.ng-scope span.profile__text.ng-binding")).getText();

            Assert.assertEquals(actualBoxMsg,Utill.Profile);
        }
        catch (NoSuchElementException Ex){

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            int mil = calendar.get(Calendar.MILLISECOND);

            File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\tmp\\screenshoot"+ hour + minute + sec + mil +".png"));
            System.out.println("An error message has been catch and it's stored in tmp folder on the desktop");
        }
    }
    @Test
    public void ForgotPass() throws Exception {

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("/html/body/header/div[1]/div/div/div[3]/div[2]/div/a[2]")).click();
        getDriver().switchTo().defaultContent();

        getDriver().findElement(By.className("btn-popup")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.name("forgotEmail")).sendKeys(Utill.Fpass);
        getDriver().findElement(By.className("btn")).click();
        System.out.println("Email has been sent");
        //do usuniecia
        System.out.println("Email has been sent");
    }

    @Test
    public void Register() throws Exception {

        String actualBoxMsg;

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.cssSelector("html.ng-scope body header.header div.header-inner div.container div.row.flex-sm div.col-xs-12.col-sm-5.col-md-4.flex-sm-2.nav-header div.nav-header__item.text-right.ng-scope div.group-btn.header-buttons a")).click();
        getDriver().switchTo().defaultContent();
        Thread.sleep(2000);
        // click on "I want to register as a new user"
        getDriver().findElement(By.cssSelector("html.ng-scope body div.ng-scope div.ng-scope div.registration.ng-scope div.registration__buttons div.choice-block-wrapper div.choice-block div.choice-block__item div.choice-block__image a.btn.btn-registration._bg1")).click();

        // method to generate random email
        String contain = "qwertyuiopasdfghjklzxcvbnm0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(contain.charAt(rnd.nextInt(contain.length())));
        }
        String random = sb.toString();
        String email = random + "@ready4s.pl";
        System.out.println("Your adress email: " + email);

        // sending data
        Thread.sleep(2000);
        getDriver().findElement(By.name("firstName")).sendKeys(Utill.Name);
        getDriver().findElement(By.name("lastName")).sendKeys(Utill.Surname);
        getDriver().findElement(By.name("email")).sendKeys(email);
        getDriver().findElement(By.name("password")).sendKeys("testowe");
        getDriver().findElement(By.name("confirmPassword")).sendKeys("testowe");
        getDriver().findElement(By.cssSelector("html.ng-scope body.modal-open div.ng-scope div.ng-scope div#sign-up-popup.modal.fade.ng-scope.in div.popup.modal-dialog.popup_big div.modal-content div.modal-body.popup__content._padding div.content-wrapper div.popup__form._width form.form-sign._light.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-minlength.ng-valid-pattern.ng-dirty.ng-valid-parse div.popup__form__input.radio.text-center label span")).click();
        getDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/div[3]/form/div[7]/button")).click();

        try {

            getDriver().switchTo().defaultContent();
            actualBoxMsg = getDriver().findElement(By.cssSelector("html.ng-scope body header.header div.header-inner div.container div.row.flex-sm div.col-xs-12.col-sm-5.col-md-4.flex-sm-2.nav-header div.nav-header__item.profile.text-right.ng-scope span.profile__text.ng-binding")).getText();

            Assert.assertEquals(actualBoxMsg, Utill.Profile);
        } catch (NoSuchElementException Ex) {

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            int mil = calendar.get(Calendar.MILLISECOND);

            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\tmp\\screenshoot" + hour + minute + sec + mil + ".png"));
            System.out.println("An error message has been catch and it's stored in tmp folder on the desktop");
        }
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();

    }
}
