package TrainAwayTestNG;

/**
 * Created by Krzysztof on 2017-03-26.
 */

public class Utill {

    //Valid web page URL
    public static final String BASE_URL = "http://trainaway.kitmedia.pl/#/";

    // Valid pop up login and password
    public static final String POPUP_USER = "rerere";
    public static final String POPUP_PASS = "rerere";

// firefox path
    public static final String firefox = "C:\\Users\\Krzysztof\\Desktop\\geckodriver.exe";
    public static final String geckodriver = "webdriver.gecko.driver";

    // Time to wait when searching
    public static final int WaitTime =30;

    /**
     * Selenium zawsze przy starcie tworzy nowy profile,
     * wchodzisz w firefox -> opcje ->znak zapytania ->trouble shooting information->open folder -> i kopjujesz zawarosc
     */
    static String profilepath ="C:\\Users\\Pawl\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\w60lpw8m.default";

}
