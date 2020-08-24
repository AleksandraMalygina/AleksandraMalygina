package hw4;

import org.testng.annotations.Test;


public class ExerciseOneFunctionalityTest extends WebPageTest {
    private Ex1TestData testData;

    @Test
    public void mainPageTest() {
        // 1. Open test site by URL
        mainPage.openPage(testData.getUrl());

        // 2. Assert Browser title
        baseTest.assertString(mainPage.returnPageTitle(), testData.getPageTitle());

        //3. Perform login
        mainPage.enterCreds(testData.getLogin(), testData.getPassword());

        //4. Assert User name in the left-top side of screen that user is logged in
        baseTest.assertString(mainPage.returnUserName(), testData.getUserName());

        //5. Assert Browser title
        baseTest.assertString(mainPage.returnPageTitle(), testData.getPageTitle());

        //6. Assert that there are 4 items on the header section displayed
        // and they have proper texts
        baseTest.assertList(mainPage.returnHeaderItemsText(), testData.getHeaderItemsNames());

        //7.Assert that there are 4 images on the Index Page and they are displayed
        baseTest.assertInt(mainPage.returnIconsNumber(), testData.getIconsNumber());
        baseTest.assertTrue(mainPage.iconsAreDisplayed());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        baseTest.assertInt(mainPage.returnBenefitTextsNumber(), testData.getIconsNumber());
        baseTest.assertList(mainPage.returnBenefitTexts(), testData.getBenefitTexts());

        //9. Assert a text of the main headers
        baseTest.assertString(mainPage.returnMainTitleText(), testData.getMainTitle());
        baseTest.assertString(mainPage.returnMainText(), testData.getMainText());

        //10. Assert that there is the iframe in the center of page
        baseTest.assertInt(mainPage.returnFramesNumber(), testData.getFramesNumber());

        //11. Switch to the iframe and check that
        // there is Epam logo in the left top conner of iframe
        //12. Switch to original window back
        baseTest.assertTrue(mainPage.isLogoInFrameExists());

        //13. Assert a text of the sub header
        baseTest.assertString(mainPage.returnSubHeaderText(), testData.getSubHeaderText());

        //14. Assert that JDI GITHUB is a link and has a proper URL
        baseTest.assertString(mainPage.returnSubHeaderUrl(), testData.getSubHeaderUrl());

        //15. Assert that there is Left Section
        baseTest.assertTrue(mainPage.isLeftSectionDisplayed());

        //16. Assert that there is Footer
        baseTest.assertTrue(mainPage.isFooterDisplayed());
    }

    @Override
    protected void initTestData() {
        testData = new Ex1TestData();
    }

    @Override
    protected void initMainPage() {
        this.mainPage = new MainPage(driver);
    }
}
