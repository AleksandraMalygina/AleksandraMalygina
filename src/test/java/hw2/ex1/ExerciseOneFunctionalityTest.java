package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExerciseOneFunctionalityTest {
    private WebDriver driver;

    @BeforeClass
    public void initTestClass() {
        String driverPath = "C:\\WebDrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mainPageTest() {
        // 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        WebElement profileMenu = driver.findElement(By.cssSelector("li.dropdown.uui-profile-menu"));
        WebElement toggle = profileMenu.findElement(By.className("dropdown-toggle"));
        toggle.click();

        WebElement loginField = driver.findElement(By.id("name"));
        loginField.sendKeys("Roman");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Jdi1234");
        WebElement enterButton = driver.findElement(By.id("login-button"));
        enterButton.click();

        //4. Assert User name in the left-top side of screen that user is logged in
        WebElement userName = profileMenu.findElement(By.id("user-name"));
        Assert.assertEquals(userName.getText(), "ROMAN IOVLEV");

        //5. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section displayed
        // and they have proper texts
        WebElement header = driver
                .findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"));
        List<WebElement> headerElements = header.findElements(By.xpath("child::*"));
        Assert.assertEquals(headerElements.size(), 4);
        List<String> itemsNames = Arrays.asList("HOME",
                "CONTACT FORM",
                "SERVICE",
                "METALS & COLORS");
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(headerElements.get(i).getText(), itemsNames.get(i));
        }

        //7.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(benefitIcons.size(), 4);
        WebElement curElement;
        curElement = benefitIcons.get(0)
                .findElement(By.cssSelector("span.icons-benefit.icon-practise"));
        Assert.assertTrue(curElement.isDisplayed());

        curElement = benefitIcons.get(1)
                .findElement(By.cssSelector("span.icons-benefit.icon-custom"));
        Assert.assertTrue(curElement.isDisplayed());

        curElement = benefitIcons
                .get(2).findElement(By.cssSelector("span.icons-benefit.icon-multi"));
        Assert.assertTrue(curElement.isDisplayed());

        curElement = benefitIcons
                .get(3).findElement(By.cssSelector("span.icons-benefit.icon-base"));
        Assert.assertTrue(curElement.isDisplayed());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(benefitTexts.size(), 4);
        List<String> texts = Arrays.asList(
                "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",

                "To be flexible and\n"
                        + "customizable",

                "To be multiplatform",

                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…");

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(benefitTexts.get(i).getText(), texts.get(i));
        }

        //9. Assert a text of the main headers
        WebElement mainTitle = driver.findElement(By.className("main-title"));
        Assert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement mainText = driver.findElement(By.className("main-txt"));
        String text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
                + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
                + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO "
                + "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE"
                + " IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM"
                + " DOLORE EU FUGIAT NULLA PARIATUR.";

        Assert.assertEquals(mainText.getText(), text);

        //10. Assert that there is the iframe in the center of page
        List<WebElement> iframeList = driver.findElements(By.id("second_frame"));
        Assert.assertEquals(iframeList.size(), 1);
        WebElement iframeCenter = iframeList.get(0);

        //11. Switch to the iframe and check that
        // there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iframeCenter);
        List<WebElement> logoList = driver.findElements(By.id("epam-logo"));
        Assert.assertEquals(logoList.size(), 1);

        //12. Switch to original window back
        driver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.xpath("//a[@ui='link']"));
        Assert.assertTrue(subHeader.isDisplayed());
        Assert.assertEquals(subHeader.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        Optional<String> optVal = Optional.ofNullable(subHeader.getAttribute("href"));
        Assert.assertTrue(optVal.isPresent());
        String hrefValue = optVal.get();
        Assert.assertTrue(hrefValue.equals("https://github.com/epam/JDI"));

        //15. Assert that there is Left Section
        List<WebElement> leftSectionList = driver.findElements(By.name("navigation-sidebar"));
        Assert.assertEquals(leftSectionList.size(), 1);
        Assert.assertTrue(leftSectionList.get(0).isDisplayed());

        //16. Assert that there is Footer
        List<WebElement> footerList = driver.findElements(By.className("footer-bg"));
        Assert.assertEquals(footerList.size(), 1);
        Assert.assertTrue(footerList.get(0).isDisplayed());
    }


    @AfterClass
    public void clearActions() {
        //17. Close Browser
        driver.quit();
    }
}
