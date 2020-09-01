package hw5.hooks;

import hw5.context.TestContext;
import hw5.data.Ex1TestData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

    @Before
    public void setUpActions() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestContext.getInstance().setDriver(driver);
        TestContext.getInstance().setTestData(new Ex1TestData());
    }

    @After
    public void  clearActions() {
        WebDriver driver = TestContext.getInstance().getDriver();
        driver.quit();

    }
}
