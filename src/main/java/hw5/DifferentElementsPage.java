package hw5;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {
    private RightSection rightSection;
    private WebDriver driver;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        rightSection = new RightSection(driver);
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


    //    @Step("Check number of CheckBoxes")
    //    public int getCheckBoxNumber() {
    //        return checkBoxes.size();
    //    }
    //
    //    @Step("Check number of RadioButtons")
    //    public int getRadiosNumber() {
    //        return radios.size();
    //    }
    //
    //    @Step("Check number of Dropdown menus")
    //    public int getDropdownNumber() {
    //        return dropdowns.size();
    //    }
    //
    //    @Step("Check number of Buttons")
    //    public int getButtonsNumber() {
    //        return (buttons.size() + inputButtons.size());
    //    }
    //
    //    @Step("Check that Right Section is displayed")
    //    public boolean isRightSectionExists() {
    //        return rightSection.isRightSectionExists();
    //    }

    //    @Step("Select Checkboxes with names: {0}")
    //    public void clickCheckBoxes(List<String> names) {
    //        for (String name : names) {
    //            clickCheckBox(name);
    //        }
    //    }

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
