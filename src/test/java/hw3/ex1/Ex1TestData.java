package hw3.ex1;

import java.util.Arrays;
import java.util.List;

public class Ex1TestData {

    private String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private String pageTitle = "Home Page";
    private String login = "Roman";
    private String password = "Jdi1234";
    private String userName = "ROMAN IOVLEV";
    private List<String> headerItemsNames = Arrays.asList("HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS");

    private int iconsNumber = 4;

    private List<String> benefitTexts = Arrays.asList(
            "To include good practices\n"
                    + "and ideas from successful\n"
                    + "EPAM project",

            "To be flexible and\n"
                    + "customizable",

            "To be multiplatform",

            "Already have good base\n"
                    + "(about 20 internal and\n"
                    + "some external projects),\n"
                    + "wish to get more…");

    private String mainTitle = "EPAM FRAMEWORK WISHES…";
    private String mainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
            + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
            + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO "
            + "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE"
            + " IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM"
            + " DOLORE EU FUGIAT NULLA PARIATUR.";

    private int framesNumber = 1;

    private String subHeaderText = "JDI GITHUB";
    private String subHeaderUrl = "https://github.com/epam/JDI";

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

    public List<String> getHeaderItemsNames() {
        return headerItemsNames;
    }

    public void setHeaderItemsNames(List<String> headerItemsNames) {
        this.headerItemsNames = headerItemsNames;
    }

    public int getIconsNumber() {
        return iconsNumber;
    }

    public void setIconsNumber(int iconsNumber) {
        this.iconsNumber = iconsNumber;
    }

    public List<String> getBenefitTexts() {
        return benefitTexts;
    }

    public void setBenefitTexts(List<String> benefitTexts) {
        this.benefitTexts = benefitTexts;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public int getFramesNumber() {
        return framesNumber;
    }

    public void setFramesNumber(int framesNumber) {
        this.framesNumber = framesNumber;
    }

    public String getSubHeaderText() {
        return subHeaderText;
    }

    public void setSubHeaderText(String subHeaderText) {
        this.subHeaderText = subHeaderText;
    }

    public String getSubHeaderUrl() {
        return subHeaderUrl;
    }

    public void setSubHeaderUrl(String subHeaderUrl) {
        this.subHeaderUrl = subHeaderUrl;
    }

}
