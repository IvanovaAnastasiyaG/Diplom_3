import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoverPassword {
    private final WebDriver webDriver;
    private final int STANDARD_TIMEOUT = 5;
    public RecoverPassword(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    public LoginPage clickSignInButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new LoginPage(webDriver);
    }
}
