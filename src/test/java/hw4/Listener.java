package hw4;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Listener implements ITestListener {

    private void attachScreenShot(ITestResult itestResult) {
        WebDriver driver = (WebDriver) itestResult.getTestContext().getAttribute("driver");
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File scrShotFile = scrShot.getScreenshotAs(OutputType.FILE);
        try {
            FileInputStream fileStream = new FileInputStream(scrShotFile);
            Allure.addAttachment("testFailedAttach", fileStream);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + " in Listener::attachScreenShot");
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult itestResult) {
        attachScreenShot(itestResult);
    }

    @Override
    public void onTestStart(ITestResult itestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult itestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult itestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult itestResult) {

    }

    @Override
    public void onStart(ITestContext itestContext) {

    }

    @Override
    public void onFinish(ITestContext itestContext) {

    }
}
