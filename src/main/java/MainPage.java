import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final By loginIntoAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalProfileButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By bunsTab = By.xpath(".//div/span[text()='Булки']");
    private final By saucesTab = By.xpath(".//div/span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//div/span[text()='Начинки']");
    private final By tabs = By.xpath(".//div/main/section[1]/div[1]");
    private final By activeTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
    private final By makeBurgerText = By.xpath((".//h1[text()='Соберите бургер']"));
    private final int STANDARD_TIMEOUT = 5;

    public MainPage open(String Url){
        webDriver.get(Url);
        return this;
    }
    public LoginPage clickLoginIntoAccountButton(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(loginIntoAccountButton)).click();
        return new LoginPage(webDriver);
    }
    public LoginPage clickLoginPersonalProfileButton(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(personalProfileButton)).click();
        return new LoginPage(webDriver);
    }
    public ProfilePage clickPersonalProfileButton(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(personalProfileButton)).click();
        return new ProfilePage(webDriver);
    }
    public MainPage clickBunsTab(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
        webDriver.findElement(tabs).click();
        webDriver.findElement(bunsTab).click();
        return this;
    }
    public MainPage clickSaucesTab(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
        webDriver.findElement(saucesTab).click();
        return this;
    }
    public MainPage clickFillingsTab(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
        webDriver.findElement(fillingsTab).click();
        return this;
    }
    public String getTextActiveTab() {
        return webDriver.findElement(activeTab).getText();
    }
    public boolean getVisibilityMakeBurgerText() {
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(makeBurgerText));
        return webDriver.findElement(makeBurgerText).isDisplayed();
    }
}
