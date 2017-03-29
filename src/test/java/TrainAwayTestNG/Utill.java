package TrainAwayTestNG;

/**
 * Created by Krzysztof on 2017-03-26.
 */

public class Utill {

    //Valid web page URL and pop up login and pass
    public static final String BASE_URL = "http://rerere:rerere@trainaway.kitmedia.pl";

    // Valid pop up login and password
    public static final String POPUP_USER = "rerere";
    public static final String POPUP_PASS = "rerere";

    // Expected error value
    public static final String EXPECTED_ERROR_EMAIL = "Email not valid!";
    public static final String EXPECTED_ERROR_PASS = "Wrong password";
    public static final String Name = "Krzysztof";
    public static final String Surname = "Pyz";
    public static final String Profile = Name + " " + Surname;

    //FB valid login and password
    public static final String FBemail = "krzysztof.pyz@ready4s.pl";
    public static final String FBpass = "Kawaleria1313";

    // Valid login and password to the website
    public static final String USER_NAME = "krzysztof.pyz@ready4s.pl";
    public static final String PASSWORD = "Kawaleria1313";

    //Google valid email and password
    public static final String Gmail = "krzysztof.pyz.ready4s.pl";
    public static final String Gpass = "Kawaleria1515";

    //Forgot password email
    public static final String Fpass = "test@test.pl";



// firefox path
    public static final String firefox = "C:\\Users\\Krzysztof\\Desktop\\gec15\\geckodriver.exe";
   // public static final String firefox = "C:\\Users\\Pawl\\Desktop\\driver\\geckodriver.exe"; //pawel
    public static final String geckodriver = "webdriver.gecko.driver";

    // chrome path
    public static final String chrome = "C:\\Users\\Krzysztof\\Desktop\\gec15\\chromedriver.exe";
    public static final String chromedriver = "webdriver.chrome.driver";

    //IE path
    public static final String IE = "C:\\Users\\Krzysztof\\Desktop\\gec15\\IEDriverServer.exe";
    public static final String IEdriver = "webdriver.ie.driver";

    // Time to wait when searching
    public static final int WaitTime =30;
    /**
     * Selenium zawsze przy starcie tworzy nowy profile,
     * wchodzisz w firefox -> opcje ->znak zapytania ->trouble shooting information->open folder -> i kopjujesz zawarosc
     */
    static String profilepath ="C:\\Users\\Pawl\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\w60lpw8m.default";

}
