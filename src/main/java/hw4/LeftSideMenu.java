package hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSideMenu {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='menu-title' and @index=3]")
    private WebElement sideServiceToggle;

    @FindBy(xpath = "//*[@class='menu-title' and @index=3]/ul/li/a")
    private List<WebElement> sideServiceElements;

    @FindBy(name = "navigation-sidebar")
    private WebElement leftSection;

    public LeftSideMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> returnServiceElementsTexts() {
        sideServiceToggle.click();
        List<String> sideServiceElementsTexts = sideServiceElements
                .stream()
                .map(x -> x.getText().toLowerCase())
                .collect(Collectors.toList());
        return sideServiceElementsTexts;
    }

    public boolean isLeftSectionExists() {
        return leftSection.isDisplayed();
    }
}
