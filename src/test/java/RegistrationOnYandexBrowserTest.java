import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends TestBaseOnChrome {
    @Test
    @DisplayName("Check registration with valid user data")
    public void checkRegistrationWithValidData() {
        String profileName =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .clickRegisterButton()
                        .fillUserInfo("Демидова Анастасия", "demidova_24@gmail.com", "123456")
                        .clickSignUpButton()
                        .fillUserInfo("demidova_24@gmail.com", "123456")
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals("demidova_24@gmail.com",profileName);
    }
    @Test
    @DisplayName("Check registration with invalid password with less than 6 symbols")
    public void checkRegistrationWithIncorrectPassword() {
        String errorIncorrectPassword =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .clickRegisterButton()
                        .fillUserInfo("Демидова Анастасия", "demidova_15@gmail.com", "12345")
                        .getPasswordErrorText();
        assertEquals("Некорректный пароль",errorIncorrectPassword);
    }
}
