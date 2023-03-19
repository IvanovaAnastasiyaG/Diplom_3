import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertEquals;

public class RegistrationOnChromeTest extends TestBaseOnChrome {
    @Test
    @DisplayName("Check registration with valid user data")
    public void registrationWithValidData() {
        User user= new User("25_demidova@gmail.com", "123456", "Демидова Анастасия");
        String profileName =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .clickRegisterButton()
                        .fillUserInfo(user.getName(),user.getEmail(),user.getPassword())
                        .clickSignUpButton()
                        .fillUserInfo(user.getEmail(),user.getPassword())
                        .clickSignInButton()
                        .clickPersonalProfileButton()
                        .clickProfileInfoButton()
                        .getNameUserText();
        assertEquals(user.getEmail(),profileName);
    }
    @Test
    @DisplayName("Check registration with invalid password with less than 6 symbols")
    public void registrationWithIncorrectPassword() {
        User user= new User("demidova_15@gmail.com", "12345", "Демидова Анастасия");
        String errorIncorrectPassword =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickLoginPersonalProfileButton()
                        .clickRegisterButton()
                        .fillUserInfo(user.getName(),user.getEmail(),user.getPassword())
                        .clickInputNameField()
                        .getPasswordErrorText();
        assertEquals(MESSAGE_INCORRECT_PASSWORD,errorIncorrectPassword);
    }
}
