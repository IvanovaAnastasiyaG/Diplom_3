import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class LoginTest {
    WebDriver driver;

    @Before
    public void setUp(){
        final String PATH_DRIVERS = "\\drivers\\chromedriver.exe";
        final String TYPE_DRIVER = "webdriver.chrome.driver";
        System.setProperty(TYPE_DRIVER,System.getProperty("user.dir")+PATH_DRIVERS);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    //@DisplayName("Check the login via \"Personal profile\" button on the main page")
    public void loginViaPersonalProfileOnMainPage() {
        String profileName =
            new MainPage(driver)
                    .open(MAIN_PAGE_URL)
                    .clickLoginPersonalProfileButton()
                    .fillUserInfo("demidova_15@gmail.com", "123456")
                    .clickSignInButton()
                    .clickPersonalProfileButton()
                    .clickProfileInfoButton()
                    .getNameUserText();
        assertEquals("demidova_15@gmail.com",profileName);
    }

    @Test
    //@DisplayName("Check the login via \"Login into account\" button on the main page")
    public void loginViaIntoAccountButtonOnMainPage() {
        String profileName =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickLoginIntoAccountButton()
                        .fillUserInfo("demidova_15@gmail.com", "123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals("demidova_15@gmail.com",profileName);
    }

    @Test
    //@DisplayName("Check the login via the button in registration form")
    public void loginViaButtonInRegistrationForm() {
        String profileName =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickLoginIntoAccountButton()
                        .clickRegisterButton()
                        .clickSignInButton()
                        .fillUserInfo("demidova_15@gmail.com", "123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals("demidova_15@gmail.com",profileName);
    }

    @Test
    //@DisplayName("Check the login via the password reset form")
    public void loginViaPasswordResetForm() {
        String profileName =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickLoginIntoAccountButton()
                        .clickRecoverPasswordButton()
                        .clickSignInButton()
                        .fillUserInfo("demidova_15@gmail.com", "123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals("demidova_15@gmail.com",profileName);
    }
}
