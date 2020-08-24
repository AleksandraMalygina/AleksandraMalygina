package hw3.ex2;

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

    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    public String returnPageTitle() {
        return driver.getTitle();
    }

    public void enterCreds(String login, String password) {
        headerMenu.enterCreds(login, password);
    }

    public List<String> returnHeaderServiceElementsTexts() {
        return headerMenu.returnServiceElementsTexts();
    }

    public List<String> returnSideServiceElementsTexts() {
        return leftSideMenu.returnServiceElementsTexts();
    }

    public String returnUserName() {
        return headerMenu.returnUserName();
    }

    public DifferentElementsPage goToDifElementsPage() {
        headerMenu.goToDifElementsPage();
        return differentElementsPage;
    }

}
