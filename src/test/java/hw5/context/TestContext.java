package hw5.context;

import hw5.data.Ex1TestData;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TestContext {

    private WebDriver driver;
    private Ex1TestData testData;
    private static TestContext instance;
    private List<String> logData = new ArrayList<>();
    private List<String> actualTableItems = new ArrayList<>();
    private List<String> expectedTableItems = new ArrayList<>();

    private TestContext() {

    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }

        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Ex1TestData getTestData() {
        return testData;
    }

    public void setTestData(Ex1TestData testData) {
        this.testData = testData;
    }

    public List<String> getLogData() {
        return logData;
    }

    public void setLogData(List<String> logData) {
        this.logData = logData;
    }

    public List<String> getActualTableItems() {
        return actualTableItems;
    }

    public void setActualTableItems(List<String> actualTableItems) {
        this.actualTableItems = actualTableItems;
    }

    public List<String> getExpectedTableItems() {
        return expectedTableItems;
    }

    public void setExpectedTableItems(List<String> expectedTableItems) {
        this.expectedTableItems = expectedTableItems;
    }
}
