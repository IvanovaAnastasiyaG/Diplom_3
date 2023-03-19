import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver webDriver;
    public ProfilePage(WebDriver driver) {
        this.webDriver = driver;
    }
    private final By profileButton = By.linkText("Профиль");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By nameUser = By.xpath(".//input[@name='name']");
    private final By mainLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final int STANDARD_TIMEOUT = 5;
    public ProfilePage clickProfileInfoButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(profileButton)).click();
        return this;
    }
    public LoginPage clickLogoutButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return new LoginPage(webDriver);
    }
    public MainPage clickMainLogo() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(mainLogo)).click();
        return new MainPage(webDriver);
    }
    public MainPage clickConstructorButton() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(constructorButton)).click();
        return new MainPage(webDriver);
    }
    public String getNameUserText() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(nameUser));
        return webDriver.findElement(nameUser).getAttribute("value");
    }
}
