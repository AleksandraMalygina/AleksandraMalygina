package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class WebPageTest {
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
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    protected abstract void initMainPage();

    protected abstract void initTestData();

    protected void initBaseTest() {
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
