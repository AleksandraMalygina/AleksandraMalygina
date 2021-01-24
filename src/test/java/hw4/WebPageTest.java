package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;


public abstract class WebPageTest {
    public static final Logger LOGGER = Logger.getLogger(WebPageTest.class.getName());
    protected WebDriver driver;
    protected MainPage mainPage;
    protected BaseTest baseTest;

    @BeforeClass
    public void initTestClass() {
        initDriver();
        initMainPage();
        initTestData();
        initBaseTest();
    }


    protected void initDriver() {
        LOGGER.info("MSG: init driver start");
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        LOGGER.info("MSG: init driver finish" + "driver is null = " + (this.driver == null));
    }

    protected abstract void initMainPage();

    protected abstract void initTestData();

    protected void initBaseTest() {

        LOGGER.info("MSG: initBasePage()  start");
        this.baseTest = new BaseTest();
    }

    @AfterClass
    public void clearActions() {
        //17. Close Browser
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
