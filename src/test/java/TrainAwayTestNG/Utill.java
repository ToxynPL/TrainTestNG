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

    // Valid login and password to website
    public static final String USER_NAME = "krzysztof.pyz@ready4s.pl";
    public static final String PASSWORD = "Kawaleria1313";

// firefox path
    public static final String firefox = "C:\\Users\\Krzysztof\\Desktop\\gec15\\geckodriver.exe";
   // public static final String firefox = "C:\\Users\\Pawl\\Desktop\\driver\\geckodriver.exe"; //pawel
    public static final String geckodriver = "webdriver.gecko.driver";

    // Time to wait when searching
    public static final int WaitTime =30;

    /**
     * Selenium zawsze przy starcie tworzy nowy profile,
     * wchodzisz w firefox -> opcje ->znak zapytania ->trouble shooting information->open folder -> i kopjujesz zawarosc
     */
    static String profilepath ="C:\\Users\\Pawl\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\w60lpw8m.default";

}
