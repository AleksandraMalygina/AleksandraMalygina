package hw4;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[contains(@class, 'uui-profile-menu')]/a")
    private WebElement loginToggle;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/child::li")
    private List<WebElement> headerElements;

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
        loginToggle.click();
        enterLogin(login);
        enterPassword(password);
        pressLogInButton();
    }

    @Step("Check header section items")
    public List<String> returnHeaderItemsText() {
        List<String> itemsText = new ArrayList<>();
        for (WebElement item : headerElements) {
            itemsText.add(item.getText());
        }
        return itemsText;
    }

    @Step("Check that userName is correct")
    public String returnUserName() {
        return userName.getText();
    }

    @Step("Check that number of images on the Index Page is correct")
    public int returnIconsNumber() {
        return benefitIcons.size();
    }

    @Step("Check that images on the Index Page are displayed")
    public boolean iconsAreDisplayed() {
        boolean res = true;
        for (WebElement icon : benefitIcons) {
            res &= icon.isDisplayed();
        }
        return res;
    }

    @Step("Check the number of Texts on the Index Page")
    public int returnBenefitTextsNumber() {
        return benefitTexts.size();
    }

    @Step("Check that there are proper Texts on the Index Page")
    public List<String> returnBenefitTexts() {
        List<String> benTexts = new ArrayList<>();
        for (WebElement element : benefitTexts) {
            benTexts.add(element.getText());
        }
        return benTexts;
    }

    @Step("Check proper text of the main Title")
    public String returnMainTitleText() {
        return mainTitle.getText();
    }

    @Step("Check proper text of the main Text")
    public String returnMainText() {
        return mainText.getText();
    }

    @Step("Check the presence of iframe at the center of the page")
    public int returnFramesNumber() {
        return iframeList.size();
    }

    @Step("Check Logo presence in the iframe header")
    public boolean isLogoInFrameExists() {
        if (iframeList.size() != 0) {
            iframe = iframeList.get(0);
        } else {
            driver.switchTo().defaultContent();
            return false;
        }

        driver.switchTo().frame(iframe);
        List<WebElement> logoList = driver.findElements(By.id("epam-logo"));
        if (logoList.size() == 1) {
            driver.switchTo().defaultContent();
            return true;
        } else {
            driver.switchTo().defaultContent();
            return false;
        }
    }

    @Step("Check a text of the subHeader")
    public String returnSubHeaderText() {
        return subHeader.getText();
    }

    @Step("Check that subHeader is a link with correct url")
    public String returnSubHeaderUrl() {
        Optional<String> optVal = Optional.ofNullable(subHeader.getAttribute("href"));
        String hrefValue = optVal.get();
        return hrefValue;
    }

    @Step("Check the presence of Left Section")
    public boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }

    @Step("Check the presence of Footer")
    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    @Step("Enter login {0}")
    private void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step("Enter password {0}")
    private void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Press login button")
    private void pressLogInButton() {
        enterButton.click();
    }
}
