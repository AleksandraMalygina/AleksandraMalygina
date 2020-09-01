package hw5;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {
    private RightSection rightSection;

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


    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        rightSection = new RightSection(driver);
    }

    public void clickCheckBox(String name) {
        checkBoxesLabels
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase(name))
                .findAny()
                .get()
                .click();
    }

    @Step("Select RadioButton with name: {0}")
    public void selectRadio(String name) {
        radiosLabels
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase(name))
                .findAny()
                .get()
                .click();
    }

    public void clickOnDropdown() {
        dropdowns.get(0).click();
    }

    @Step("Select an option from DropDown menu with name: {0}")
    public void selectFromDropDrown(String name) {
        clickOnDropdown();
        dropdownOptions
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(name))
                .findFirst()
                .get()
                .click();
    }

    @Step("Check that log lines are corresponded with the last actions")
    public List<String> getLastLogLines(int linesNumber) {
        return rightSection.getLastLogLines(linesNumber);
    }

    public String getLastLogLine() {
        return rightSection.getLastLogLine();
    }

    @Step("Check whether checkBox with the name '{0}' is selected")
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
