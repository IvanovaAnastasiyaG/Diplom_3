import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseOnYandexBrowser extends Constants {

    WebDriver driverYandexBrowser;
    final String PATH_DRIVERS = "\\drivers\\yandexdriver.exe";
    final String TYPE_DRIVER = "webdriver.chrome.driver";

    @Before
    public void setUp(){
        System.setProperty(TYPE_DRIVER,System.getProperty("user.dir")+PATH_DRIVERS);
        driverYandexBrowser = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driverYandexBrowser.quit();
    }
}
