package hw4;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExerciseTwoFunctionalityTest extends WebPageTest {

    private MainPageEx2 mainPage;
    private Ex2TestData testData;
    private SoftAssertions softAssert;
    private DifferentElementsPage difElPage;

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssertions();
    }

    @Test
    public void test() {
        LOGGER.info("MSG: ExerciseTwoFunctionalityTest start");
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


    @Override
    protected void initMainPage() {
        LOGGER.info("MSG: initMainPage()  start");
        mainPage = new MainPageEx2(driver);
    }

    @Override
    protected void initTestData() {
        LOGGER.info("MSG: initTestData()  start");
        testData = new Ex2TestData();
    }

}
