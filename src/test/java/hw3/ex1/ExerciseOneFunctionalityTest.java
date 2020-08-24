package hw3.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ExerciseOneFunctionalityTest {
    private WebDriver driver;
    private Properties appProperties;
    private MainPage mainPage;
    private Ex1TestData testData;
    private BaseTest baseTest;

    @BeforeClass
    public void initTestClass() {
        initDriver();
        initMainPage();
        initTestData();
        initBaseTest();
    }


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
        mainPage = new MainPage(driver);
    }

    private void initTestData() {
        testData = new Ex1TestData();
    }

    private void initBaseTest() {
        baseTest = new BaseTest();
    }

    @AfterClass
    public void clearActions() {
        //17. Close Browser
        driver.quit();
    }
}
