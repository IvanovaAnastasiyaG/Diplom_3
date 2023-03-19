import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertEquals;

public class LoginOnChromeTest extends TestBaseOnChrome{
    User user = new User("demidova_15@gmail.com", "123456", null);

    @Test
    @DisplayName("Check the login via \"Personal profile\" button on the main page")
    public void loginViaPersonalProfileOnMainPage() {
        String profileName =
            new MainPage(driverChrome)
                    .open(MAIN_PAGE_URL)
                    .clickLoginPersonalProfileButton()
                    .fillUserInfo(user.getEmail(),user.getPassword())
                    .clickSignInButton()
                    .clickPersonalProfileButton()
                    .clickProfileInfoButton()
                    .getNameUserText();
        assertEquals(user.getEmail(),profileName);
    }

    @Test
    @DisplayName("Check the login via \"Login into account\" button on the main page")
    public void loginViaIntoAccountButtonOnMainPage() {
        String profileName =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginIntoAccountButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals(user.getEmail(),profileName);
    }

    @Test
    @DisplayName("Check the login via the button in registration form")
    public void loginViaButtonInRegistrationForm() {
        String profileName =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginIntoAccountButton()
                        .clickRegisterButton()
                        .clickSignInButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals(user.getEmail(),profileName);
    }

    @Test
    @DisplayName("Check the login via the password reset form")
    public void loginViaPasswordResetForm() {
        String profileName =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginIntoAccountButton()
                        .clickRecoverPasswordButton()
                        .clickSignInButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals(user.getEmail(),profileName);
    }
}
