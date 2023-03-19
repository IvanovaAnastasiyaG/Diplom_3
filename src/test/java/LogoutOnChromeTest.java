import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LogoutTest {
    WebDriver driver;
    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    @Before
    public void setUp(){
        final String PATH_DRIVERS = "\\drivers\\chromedriver.exe";
        final String TYPE_DRIVER = "webdriver.chrome.driver";
        System.setProperty(TYPE_DRIVER,System.getProperty("user.dir")+PATH_DRIVERS);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    //@DisplayName("Check logout via button \"Logout\" in personal account")
    public void checkLogout() {
        boolean isSignUpButtonIsVisible =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .fillUserInfo("demidova_15@gmail.com","123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickLogoutButton()
                        .getSignInButtonIsVisible();
        assertTrue(isSignUpButtonIsVisible);
    }
}
