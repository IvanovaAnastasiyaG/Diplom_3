import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertTrue;

public class LogoutOnChromeTest extends TestBaseOnChrome{
    User user = new User("demidova_15@gmail.com", "123456", null);

    @Test
    @DisplayName("Check logout via button \"Logout\" in personal account")
    public void checkLogout() {
        boolean isSignUpButtonIsVisible =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickLogoutButton()
                        .getSignInButtonIsVisible();
        assertTrue(isSignUpButtonIsVisible);
    }
}
