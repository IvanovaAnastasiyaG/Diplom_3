import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By recoverPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By registrationButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final int STANDARD_TIMEOUT = 5;
    public MainPage clickSignInButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new MainPage(webDriver);
    }
    public RecoverPassword clickRecoverPasswordButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(recoverPasswordButton)).click();
        return new RecoverPassword(webDriver);
    }
    public RegistrationPage clickRegisterButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
        return new RegistrationPage(webDriver);
    }
    public LoginPage fillUserInfo(String email, String password){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public boolean getSignInButtonIsVisible() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        return webDriver.findElement(signInButton).isDisplayed();
    }
}
