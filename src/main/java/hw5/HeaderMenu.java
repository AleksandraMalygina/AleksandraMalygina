package hw5;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HeaderMenu {

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//a[@class='dropdown-toggle' and contains(text(), 'Service')]")
    private WebElement serviceToggle;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a")
    private List<WebElement> serviceElements;


    public void enterCreds(String login, String password) {
        loginToggle.click();
        enterLogin(login);
        enterPassword(password);
        pressLogInButton();
    }

    public String returnUserName() {
        return userName.getText();
    }

    public void clickOnServiceHeaderButton() {
        serviceToggle.click();
    }

    public void clickOnServiceElement(String elementName) {
        serviceElements
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(elementName))
                .findAny()
                .get()
                .click();
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
