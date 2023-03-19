import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstructorBurgerOnYandexBrowserTest extends TestBaseOnYandexBrowser{

    @Test
    @DisplayName("Check transfer to the Buns tab")
    public void checkTransferToTheBunsTab() {
        String activeTab =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickBunsTab()
                                .getTextActiveTab();
        assertEquals("Булки", activeTab);
    }
    @Test
    @DisplayName("Check transfer to the sauces tab")
    public void checkTransferToTheSaucesTab() {
        String activeTab =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickSaucesTab()
                        .getTextActiveTab();
        assertEquals("Соусы", activeTab);
    }
    @Test
    @DisplayName("Check transfer to the sauces tab")
    public void checkTransferToTheFillingsTab() {
        String activeTab =
                new MainPage(driverYandexBrowser)
                        .open(MAIN_PAGE_URL)
                        .clickFillingsTab()
                        .getTextActiveTab();
        assertEquals("Начинки", activeTab);
    }

    @Test
    @DisplayName("Check the transfer from personal account to constructor")
    public void checkTransferFromPersonalAccountToConstructor() {
        boolean isVisibilityMakeBurgerText =
                new MainPage(driverYandexBrowser)
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
    @DisplayName("Check the transfer from personal account by clicking on logo to constructor")
    public void checkTransferFromPersonalAccountBy() {
        boolean isVisibilityMakeBurgerText =
                new MainPage(driverYandexBrowser)
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
