package hw3.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {
    private LeftSideMenu leftSideMenu;
    private RightSection rightSection;
    private WebDriver driver;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        rightSection = new RightSection(driver);
        leftSideMenu = new LeftSideMenu(driver);
    }

    @FindBy(xpath = "//label[@class='label-checkbox']/input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[@class='checkbox-row']/label[@class='label-checkbox']")
    private List<WebElement> checkBoxesLabels;

    @FindBy(xpath = "//label[@class='label-radio']/input[@type='radio']")
    private List<WebElement> radios;

    @FindBy(xpath = "//div[@class='checkbox-row']/label[@class='label-radio']")
    private List<WebElement> radiosLabels;

    @FindBy(css = "select.uui-form-element")
    private List<WebElement> dropdowns;

    @FindBy(tagName = "option")
    List<WebElement> dropdownOptions;

    @FindBy(css = "button.uui-button[value='Default Button']")
    private List<WebElement> buttons;

    @FindBy(css = "input[type='button']")
    private List<WebElement> inputButtons;


    public int getCheckBoxNumber() {
        return checkBoxes.size();
    }

    public int getRadiosNumber() {
        return radios.size();
    }

    public int getDropdownNumber() {
        return dropdowns.size();
    }

    public int getButtonsNumber() {
        return (buttons.size() + inputButtons.size());
    }

    public boolean isRightSectionExists() {
        return rightSection.isRightSectionExists();
    }

    public boolean isLeftSectionExists() {
        return leftSideMenu.isLeftSectionExists();
    }

    public void clickCheckBoxes(List<String> names) {
        for (String name : names) {
            checkBoxesLabels
                    .stream()
                    .filter(a -> a.getText().trim().equalsIgnoreCase(name))
                    .findAny()
                    .get()
                    .click();
        }
    }

    public void selectRadio(String name) {
        radiosLabels
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase(name))
                .findAny()
                .get()
                .click();
    }

    public void selectFromDropDrown(String name) {
        WebElement dropdown = dropdowns.get(0);
        dropdown.click();
        dropdownOptions
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(name))
                .findFirst()
                .get()
                .click();
    }

    public List<String> getLastLogLines(int linesNumber) {
        return rightSection.getLastLogLines(linesNumber);
    }

    public boolean isCheckBoxSelected(String name) {
        return checkBoxesLabels
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase(name))
                .findAny()
                .get()
                .findElement(By.tagName("input"))
                .isSelected();
    }

}
