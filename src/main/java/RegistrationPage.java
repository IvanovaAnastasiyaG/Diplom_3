import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final WebDriver webDriver;
    public RegistrationPage(WebDriver driver) {
        this.webDriver = driver;
    }
    private final By inputNameField = By.xpath(".//fieldset[1]//input");
    private final By inputEmailField = By.xpath(".//fieldset[2]//input");
    private final By inputPasswordField = By.xpath(".//fieldset[3]//input");
    private final By passwordIncorrectText = By.xpath(".//p[text()='Некорректный пароль']");
    private final By signUpButton = By.xpath(".//div/main/div/form/button");
    private final By signInButton = By.xpath(".//div/main//p/a");
    private final int STANDARD_TIMEOUT = 10;
    public RegistrationPage fillUserInfo(String name, String email, String password){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(inputNameField)).click();
        webDriver.findElement(inputNameField).sendKeys(name);
        webDriver.findElement(inputEmailField).sendKeys(email);
        webDriver.findElement(inputPasswordField).sendKeys(password);
        return this;
    }
    public RegistrationPage clickInputNameField() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(inputNameField)).click();
        return this;
    }
    public LoginPage clickSignUpButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
        return new LoginPage(webDriver);
    }
    public LoginPage clickSignInButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new LoginPage(webDriver);
    }
    public String getPasswordErrorText() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(passwordIncorrectText));
        return webDriver.findElement(passwordIncorrectText).getText();
    }
}
