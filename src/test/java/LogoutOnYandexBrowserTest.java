import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogoutOnChromeTest extends TestBaseOnChrome{
    @Test
    @DisplayName("Check logout via button \"Logout\" in personal account")
    public void checkLogout() {
        boolean isSignUpButtonIsVisible =
                new MainPage(driverChrome)
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
