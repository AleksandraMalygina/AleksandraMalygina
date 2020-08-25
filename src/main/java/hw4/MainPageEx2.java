package hw4;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageEx2 {

    private WebDriver driver;
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;
    private DifferentElementsPage differentElementsPage;


    public MainPageEx2(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        leftSideMenu = new LeftSideMenu(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @FindBy(xpath = "//div[@class='benefit-icon']/span[contains(@class, 'icons-benefit')]")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> benefitTexts;

    @FindBy(className = "main-title")
    private WebElement mainTitle;

    @FindBy(className = "main-txt")
    private WebElement mainText;

    @FindBy(id = "second_frame")
    private List<WebElement> iframeList;

    @FindBy(id = "epam-logo")
    private WebElement frameLogo;

    private WebElement iframe;

    @FindBy(xpath = "//a[@ui='link']")
    private WebElement subHeader;

    @FindBy(name = "navigation-sidebar")
    private WebElement leftSection;

    @FindBy(className = "footer-bg")
    private WebElement footer;

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

    @Step("Check the list of options of 'Service' subcategory from the Header")
    public List<String> returnHeaderServiceElementsTexts() {
        return headerMenu.returnServiceElementsTexts();
    }

    @Step("Check the list of options of 'Service' subcategory from the Left Section")
    public List<String> returnSideServiceElementsTexts() {
        return leftSideMenu.returnServiceElementsTexts();
    }

    @Step("Check that userName is correct")
    public String returnUserName() {
        return headerMenu.returnUserName();
    }

    @Step("Navigate to 'Different Elements' page")
    public DifferentElementsPage goToDifElementsPage() {
        headerMenu.goToDifElementsPage();
        return differentElementsPage;
    }

}
