import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstructorBurgerOnYandexBrowserTest extends TestBaseOnYandexBrowser{
    User user = new User("demidova_15@gmail.com", "123456", null);

    @Test
    @DisplayName("Check transfer to the Buns tab")
    public void linkToBunsInTheBuns() {
        String activeTab =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickBunsTab()
                                .getTextActiveTab();
        assertEquals(BUNS_TAB, activeTab);
    }
    @Test
    @DisplayName("Check transfer to the sauces tab")
    public void linkToSaucesInTheSauces() {
        String activeTab =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickSaucesTab()
                        .getTextActiveTab();
        assertEquals(SAUCES_TAB, activeTab);
    }
    @Test
    @DisplayName("Check transfer to the sauces tab")
    public void linkToFillingInTheFilling() {
        String activeTab =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickFillingsTab()
                        .getTextActiveTab();
        assertEquals(FILLINGS_TAB, activeTab);
    }

    @Test
    @DisplayName("Check the transfer from personal account to constructor")
    public void linkFromPersonalAccountToConstructorBurger() {
        boolean isVisibilityMakeBurgerText =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickConstructorButton()
                        .getVisibilityMakeBurgerText();
        assertTrue(isVisibilityMakeBurgerText);
    }
    @Test
    @DisplayName("Check the transfer from personal account by clicking on logo to constructor")
    public void linkFromPersonalAccountToMainPage() {
        boolean isVisibilityMakeBurgerText =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickMainLogo()
                        .getVisibilityMakeBurgerText();
        assertTrue(isVisibilityMakeBurgerText);
    }
}
