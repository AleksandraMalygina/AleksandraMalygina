package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(Listener.class)
public class ToFailTest {
    private WebDriver driver;
    private Properties appProperties;
    private MainPage mainPage;
    private Ex1TestData testData;
    //    private Listener listener;

    @BeforeClass
    public void initTestClass(ITestContext testContext) {
        initDriver();
        initMainPage();
        initTestData();
        testContext.setAttribute("driver", driver);
    }

    @Feature("Web-portal development")
    @Story("Main Page development")
    @Test
    public void mainPageTest() {
        // 1. Open test site by URL
        mainPage.openPage(testData.getUrl());

        // 2. Assert Browser title
        Assert.assertEquals(mainPage.returnPageTitle(), testData.getPageTitle());

        //3. Perform login
        mainPage.enterCreds(testData.getLogin(), testData.getPassword());

        //4. Assert User name in the left-top side of screen that user is logged in
        Assert.assertEquals(mainPage.returnUserName(), testData.getUserName());

        //5. Assert Browser title
        Assert.assertEquals(mainPage.returnPageTitle(), testData.getPageTitle());

        //6. Assert that there are 4 items on the header section displayed
        // and they have proper texts
        assertThat(mainPage.returnHeaderItemsText())
                .containsExactlyInAnyOrderElementsOf(testData.getHeaderItemsNames());

        //7.Assert that there are 4 images on the Index Page and they are displayed
        Assert.assertEquals(mainPage.returnIconsNumber(), testData.getIconsNumber());
        assertThat(mainPage.iconsAreDisplayed()).isTrue();


        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        Assert.assertEquals(mainPage.returnBenefitTextsNumber(), testData.getIconsNumber());
        assertThat(mainPage.returnBenefitTexts())
                .containsExactlyInAnyOrderElementsOf(testData.getBenefitTexts());

        //9. Assert a text of the main headers
        assertThat(mainPage.returnMainTitleText()).isEqualTo("Wonderful Text");
        assertThat(mainPage.returnMainText()).isEqualTo("Even better text");

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

    @AfterClass
    public void clearActions() {
        //17. Close Browser
        driver.quit();
    }
}
