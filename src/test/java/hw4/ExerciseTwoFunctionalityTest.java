package hw4;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExerciseTwoFunctionalityTest {
    private WebDriver driver;
    private Properties appProperties;
    private MainPageEx2 mainPage;
    private Ex2TestData testData;
    private SoftAssertions softAssert;
    private DifferentElementsPage difElPage;
    private BaseTest baseTest;

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssertions();
        initDriver();
        initMainPage();
        initTestData();
        initBaseTest();
    }

    @Test
    public void test() {
        //1. Open test site by URL
        mainPage.openPage(testData.getUrl());

        //2. Assert Browser title
        baseTest.assertString(mainPage.returnPageTitle(), testData.getPageTitle());

        //3. Perform login
        mainPage.enterCreds(testData.getLogin(), testData.getPassword());

        //4. Assert User name in the left-top side of screen that user is logged in
        baseTest.assertString(mainPage.returnUserName(), testData.getUserName());

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        baseTest.assertList(mainPage.returnHeaderServiceElementsTexts(),
                testData.getExpectedServiceElementsTexts());

        //6. Click on Service subcategory in the left section
        // and check that drop down contains options
        baseTest.assertList(mainPage.returnSideServiceElementsTexts(),
                testData.getExpectedServiceElementsTexts());

        //7. Open through the header menu Service -> Different Elements Page
        difElPage = mainPage.goToDifElementsPage();

        //8. Check interface on Different elements page, it contains all needed elements
        baseTest.assertInt(difElPage.getRadiosNumber(),   testData.getRadioButtonsNumber());
        baseTest.assertInt(difElPage.getCheckBoxNumber(), testData.getCheckboxesNumber());
        baseTest.assertInt(difElPage.getDropdownNumber(), testData.getDropdownNumber());
        baseTest.assertInt(difElPage.getButtonsNumber(), testData.getButtonsNumber());

        //9. Assert that there is Right Section
        baseTest.assertTrue(difElPage.isRightSectionExists());

        //10. Assert that there is Left Section
        baseTest.assertTrue(difElPage.isLeftSectionExists());

        //11. Select checkboxes
        difElPage.clickCheckBoxes(testData.getCheckBoxesToClick());

        //12. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        baseTest.assertList(difElPage.getLastLogLines(testData.getCheckBoxesToClick().size()),
                testData.getCheckedBoxesLogs());

        //13. Select radio
        difElPage.selectRadio(testData.getRadioToSelect());

        //14. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        baseTest.assertList(difElPage.getLastLogLines(testData.getRadioLog().size()),
                testData.getRadioLog());

        //15. Select in dropdown
        difElPage.selectFromDropDrown(testData.getDropDownToChoose());

        //16. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        baseTest.assertList(difElPage.getLastLogLines(testData.getDropDownLog().size()),
                testData.getDropDownLog());

        //17. Unselect and assert checkboxes
        difElPage.clickCheckBoxes(testData.getCheckBoxesToClick());

        for (String checkbox : testData.getCheckBoxesToClick()) {
            baseTest.assertFalse(difElPage.isCheckBoxSelected(checkbox));
        }

        //18. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        baseTest.assertList(difElPage.getLastLogLines(testData.getCheckBoxesToClick().size()),
                testData.getUncheckedBoxesLogs());
    }

    private void initDriver() {
        String propertyPath = "./src/main/resources/app.properties";
        appProperties = new Properties();
        try {
            appProperties.load(new FileInputStream(propertyPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driverPath = appProperties.getProperty("driverPath");
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void initMainPage() {
        mainPage = new MainPageEx2(driver);
    }

    private void initTestData() {
        testData = new Ex2TestData();
    }

    private void initBaseTest() {
        baseTest = new BaseTest();
    }


    @AfterClass
    public void clearActions() {
        //19. Close Browser
        driver.quit();
    }
}
