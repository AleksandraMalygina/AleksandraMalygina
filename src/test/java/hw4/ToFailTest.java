package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(Listener.class)
public class ToFailTest extends WebPageTest {
    private Ex1TestData testData;

    @BeforeClass
    public void initTestClass(ITestContext testContext) {
        testContext.setAttribute("driver", driver);
    }

    @Feature("Web-portal development")
    @Story("Main Page development")
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
        baseTest.assertString(mainPage.returnMainTitleText(), "Wonderful Text");
        baseTest.assertString(mainPage.returnMainText(), "Even better text");

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
