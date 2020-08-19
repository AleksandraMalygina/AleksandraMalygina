package hw3.ex1;

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

    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    public String returnPageTitle() {
        return driver.getTitle();
    }

    public void enterCreds(String login, String password) {
        loginToggle.click();
        enterLogin(login);
        enterPassword(password);
        pressLogInButton();
    }

    public List<String> returnHeaderItemsText() {
        System.out.println(headerElements.size());

        List<String> itemsText = new ArrayList<>();
        for (WebElement item : headerElements) {
            itemsText.add(item.getText());
        }
        return itemsText;
    }

    public String returnUserName() {
        return userName.getText();
    }

    public int returnIconsNumber() {
        return benefitIcons.size();
    }

    public boolean iconsAreDisplayed() {
        boolean res = true;
        for (WebElement icon : benefitIcons) {
            res &= icon.isDisplayed();
        }
        return res;
    }

    public int returnBenefitTextsNumber() {
        return benefitTexts.size();
    }

    public List<String> returnBenefitTexts() {
        List<String> benTexts = new ArrayList<>();
        for (WebElement element : benefitTexts) {
            benTexts.add(element.getText());
        }
        return benTexts;
    }

    public String returnMainTitleText() {
        return mainTitle.getText();
    }

    public String returnMainText() {
        return mainText.getText();
    }

    public int returnFramesNumber() {
        return iframeList.size();
    }

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

    public String returnSubHeaderText() {
        return subHeader.getText();
    }

    public String returnSubHeaderUrl() {
        Optional<String> optVal = Optional.ofNullable(subHeader.getAttribute("href"));
        String hrefValue = optVal.get();
        return hrefValue;
    }

    public boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }

    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    private void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    private void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void pressLogInButton() {
        enterButton.click();
    }
}
