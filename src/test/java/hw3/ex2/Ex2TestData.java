package hw3.ex2;

import java.util.Arrays;
import java.util.List;

public class Ex2TestData {
    private String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private String pageTitle = "Home Page";
    private String login = "Roman";
    private String password = "Jdi1234";
    private String userName = "ROMAN IOVLEV";
    private List<String> expectedServiceElementsTexts = Arrays.asList("support", "dates", "search",
            "complex table", "simple table",
            "table with pages", "different elements",
            "user table", "performance");
    private int checkboxesNumber = 4;
    private int radioButtonsNumber = 4;
    private int dropdownNumber = 1;
    private int buttonsNumber = 2;
    private List<String> checkBoxesToClick = Arrays.asList("water", "wind");
    private String radioToSelect = "selen";
    private String dropDownToChoose = "yellow";
    private List<String> checkedBoxesLogs = Arrays.asList(
            "wind: condition changed to true",
            "water: condition changed to true");
    private List<String> uncheckedBoxesLogs = Arrays.asList(
            "wind: condition changed to false",
            "water: condition changed to false");
    private List<String> radioLog = Arrays.asList("metal: value changed to selen");
    private List<String> dropDownLog = Arrays.asList("colors: value changed to yellow");


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getExpectedServiceElementsTexts() {
        return expectedServiceElementsTexts;
    }

    public void setExpectedServiceElementsTexts(List<String> expectedServiceElementsTexts) {
        this.expectedServiceElementsTexts = expectedServiceElementsTexts;
    }

    public int getCheckboxesNumber() {
        return checkboxesNumber;
    }

    public void setCheckboxesNumber(int checkboxesNumber) {
        this.checkboxesNumber = checkboxesNumber;
    }

    public int getRadioButtonsNumber() {
        return radioButtonsNumber;
    }

    public void setRadioButtonsNumber(int radioButtonsNumber) {
        this.radioButtonsNumber = radioButtonsNumber;
    }

    public int getDropdownNumber() {
        return dropdownNumber;
    }

    public void setDropdownNumber(int dropdownNumber) {
        this.dropdownNumber = dropdownNumber;
    }

    public int getButtonsNumber() {
        return buttonsNumber;
    }

    public void setButtonsNumber(int buttonsNumber) {
        this.buttonsNumber = buttonsNumber;
    }

    public List<String> getCheckBoxesToClick() {
        return checkBoxesToClick;
    }

    public void setCheckBoxesToClick(List<String> checkBoxesToClick) {
        this.checkBoxesToClick = checkBoxesToClick;
    }

    public String getRadioToSelect() {
        return radioToSelect;
    }

    public void setRadioToSelect(String radioToSelect) {
        this.radioToSelect = radioToSelect;
    }

    public String getDropDownToChoose() {
        return dropDownToChoose;
    }

    public void setDropDownToChose(String dropDownToChoose) {
        this.dropDownToChoose = dropDownToChoose;
    }

    public List<String> getCheckedBoxesLogs() {
        return checkedBoxesLogs;
    }

    public void setCheckedBoxesLogs(List<String> checkedBoxesLogs) {
        this.checkedBoxesLogs = checkedBoxesLogs;
    }

    public List<String> getUncheckedBoxesLogs() {
        return uncheckedBoxesLogs;
    }

    public void setUncheckedBoxesLogs(List<String> uncheckedBoxesLogs) {
        this.uncheckedBoxesLogs = uncheckedBoxesLogs;
    }

    public List<String> getRadioLog() {
        return radioLog;
    }

    public void setRadioLog(List<String> radioLog) {
        this.radioLog = radioLog;
    }

    public List<String> getDropDownLog() {
        return dropDownLog;
    }

    public void setDropDownLog(List<String> dropDownLog) {
        this.dropDownLog = dropDownLog;
    }
}
