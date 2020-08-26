package hw5;



import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;
    private HeaderMenu headerMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
    }

    @Step("Open page by url {0}")
    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    @Step("Check the title of the page")
    public String returnPageTitle() {
        return driver.getTitle();
    }

    @Step("Perform login")
    public void enterCreds(String login, String password) {
        headerMenu.enterCreds(login, password);
    }

    @Step("Check that userName is correct")
    public String returnUserName() {
        return headerMenu.returnUserName();
    }

    public void clickOnServiceHeaderButton() {
        headerMenu.clickOnServiceHeaderButton();
    }

    public void clickOnServiceElement(String elementName) {
        headerMenu.clickOnServiceElement(elementName);
    }
}
