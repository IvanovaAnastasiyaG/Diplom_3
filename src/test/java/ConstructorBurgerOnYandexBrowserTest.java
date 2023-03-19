import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstructorBurgerTest {

    WebDriver driver;
    MainPage mainPage;
    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    @Before
    public void setUp(){
        final String PATH_DRIVERS = "\\drivers\\chromedriver.exe";
        final String TYPE_DRIVER = "webdriver.chrome.driver";
        System.setProperty(TYPE_DRIVER,System.getProperty("user.dir")+PATH_DRIVERS);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    //@DisplayName("Check transfer to the Buns tab")
    public void checkTransferToTheBunsTab() {
        String activeTab =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickBunsTab()
                                .getTextActiveTab();
        assertEquals("Булки", activeTab);
    }
    @Test
    //@DisplayName("Check transfer to the sauces tab")
    public void checkTransferToTheSaucesTab() {
        String activeTab =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickSaucesTab()
                        .getTextActiveTab();
        assertEquals("Соусы", activeTab);
    }
    @Test
    //@DisplayName("Check transfer to the sauces tab")
    public void checkTransferToTheFillingsTab() {
        String activeTab =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickFillingsTab()
                        .getTextActiveTab();
        assertEquals("Начинки", activeTab);
    }

    @Test
    //@DisplayName("Check the transfer from personal account to constructor")
    public void checkTransferFromPersonalAccountToConstructor() {
        boolean isVisibilityMakeBurgerText =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .fillUserInfo("demidova_15@gmail.com","123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickConstructorButton()
                        .getVisibilityMakeBurgerText();
        assertTrue(isVisibilityMakeBurgerText);
    }
    @Test
    //@DisplayName("Check the transfer from personal account by clicking on logo to constructor")
    public void checkTransferFromPersonalAccountBy() {
        boolean isVisibilityMakeBurgerText =
                new MainPage(driver)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .fillUserInfo("demidova_15@gmail.com","123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickMainLogo()
                        .getVisibilityMakeBurgerText();
        assertTrue(isVisibilityMakeBurgerText);
    }
}
