package hw2.ex2;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseTwoFunctionalityTest {
    private WebDriver driver;
    private SoftAssertions softAssert;

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssertions();
        String driverPath = "C:\\WebDrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        //1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        WebElement profileMenu = driver.findElement(By.cssSelector("li.dropdown.uui-profile-menu"));
        WebElement toggle = profileMenu.findElement(By.className("dropdown-toggle"));
        toggle.click();

        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        loginField.sendKeys("Roman");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys("Jdi1234");
        WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        enterButton.click();

        //4. Assert User name in the left-top side of screen that user is logged in
        WebElement userName = profileMenu.findElement(By.id("user-name"));
        Assert.assertEquals(userName.getText(), "ROMAN IOVLEV");


        //5. Click on "Service" subcategory in the header and check that drop down contains options
        WebElement headMenu = driver
                .findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"));
        List<WebElement> dropdownItems = headMenu.findElements(By.className("dropdown-toggle"));

        long co = dropdownItems
                .stream()
                .filter(a -> a.getText().toLowerCase().contains("service"))
                .count();

        Assert.assertEquals(co, 1);

        WebElement serviceToggle = dropdownItems.stream()
                .filter(a -> a.getText().toLowerCase().contains("service"))
                .collect(Collectors.toList()).get(0);

        serviceToggle.click();
        WebElement dropdownMenu = serviceToggle.findElement(
                By.xpath("following-sibling::*[@class='dropdown-menu']"));

        List<WebElement> serviceElements = dropdownMenu.findElements(By.tagName("a"));
        List<String> serviceMenuItems = serviceElements.stream()
                .map(x -> x.getText().toLowerCase())
                .collect(Collectors.toList());
        List<String> expectedServiceMenuItems = Arrays.asList("support", "dates", "search",
                "complex table", "simple table",
                "table with pages", "different elements",
                "user table", "performance");
        assertThat(serviceMenuItems).containsExactlyInAnyOrderElementsOf(expectedServiceMenuItems);

        //6. Click on Service subcategory in the left section
        // and check that drop down contains options
        WebElement sideBarMenu = driver.findElement(By.className("sidebar-menu"));
        WebElement sideServiceToggle = sideBarMenu
                .findElement(By.xpath("//*[@class='menu-title' and @index=3]"));

        Assert.assertEquals(sideServiceToggle.getText().toLowerCase(), "service");

        sideServiceToggle.click();

        WebElement sideServiceDropdownMenu = sideServiceToggle.findElement(By.className("sub"));
        List<WebElement> sideServiceElements = sideServiceDropdownMenu
                .findElements(By.tagName("a"));
        List<String> sideServiceMenuItems = sideServiceElements.stream()
                .map(x -> x.getText().toLowerCase())
                .collect(Collectors.toList());

        assertThat(sideServiceMenuItems)
                .containsExactlyInAnyOrderElementsOf(expectedServiceMenuItems);


        //7. Open through the header menu Service -> Different Elements Page
        serviceToggle.click();
        dropdownMenu.findElement(By.xpath("//a[text()='Different elements']")).click();

        //8. Check interface on Different elements page, it contains all needed elements
        List<WebElement> elementRows = driver.findElements(By.className("checkbox-row"));

        softAssert.assertThat(elementRows.size()).isEqualTo(2);

        List<WebElement> checkBoxes;
        List<WebElement> radios;
        if (elementRows.get(0).findElements(By.className("label-checkbox")).isEmpty()) {
            radios = elementRows.get(0).findElements(By.className("label-radio"));
            checkBoxes = elementRows.get(1).findElements(By.className("label-checkbox"));
        } else {
            radios = elementRows.get(1).findElements(By.className("label-radio"));
            checkBoxes = elementRows.get(0).findElements(By.className("label-checkbox"));
        }

        softAssert.assertThat(radios.size()).isEqualTo(4);
        softAssert.assertThat(checkBoxes.size()).isEqualTo(4);

        List<WebElement> dropdowns = driver.findElements(By.cssSelector("select.uui-form-element"));
        softAssert.assertThat(dropdowns.size()).isEqualTo(1);

        List<WebElement> buttons = driver
                .findElements(By.cssSelector("button.uui-button[value='Default Button']"));
        softAssert.assertThat(buttons.size()).isEqualTo(1);

        List<WebElement> inputButtons = driver.findElements(By.cssSelector("input[type='button']"));
        softAssert.assertThat(inputButtons.size()).isEqualTo(1);
        softAssert.assertAll();

        //9. Assert that there is Right Section
        WebElement rightSection = driver.findElement(By.name("log-sidebar"));
        Assert.assertTrue(rightSection.isDisplayed());

        //10. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        Assert.assertTrue(leftSection.isDisplayed());

        //11. Select checkboxes
        Actions action = new Actions(driver);

        WebElement waterCheckBox = checkBoxes
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase("water"))
                .findFirst().get();
        WebElement windCheckBox = checkBoxes
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase("wind"))
                .findFirst().get();

        action.moveToElement(waterCheckBox)
                .click()
                .build().perform();
        action.moveToElement(windCheckBox)
                .click()
                .build().perform();

        //12. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        int logLength = 0;
        WebElement log = driver.findElement(By.cssSelector("ul.panel-body-list.logs"));
        String[] logLines = log.getText().split("\n");
        List<String> boxNames = new ArrayList<>();
        List<String> boxStates = new ArrayList<>();
        logLength = logLines.length;

        softAssert.assertThat(logLength).isEqualTo(2);

        System.out.println(logLines);
        for (int i = 0; i < logLength; i++) {
            String[] arr = logLines[i].substring(9).split(":");
            boxNames.add(arr[0].toLowerCase().trim());
            boxStates.add(arr[1].toLowerCase().trim());
        }

        List<String> expectedBoxNames = Arrays.asList("wind", "water");
        List<String> expectedBoxStates = Arrays.asList("condition changed to true",
                "condition changed to true");


        softAssert.assertThat(boxNames).containsExactlyInAnyOrderElementsOf(expectedBoxNames);
        softAssert.assertThat(boxStates).containsExactlyInAnyOrderElementsOf(expectedBoxStates);
        softAssert.assertAll();

        //13. Select radio
        WebElement selenRadio = radios
                .stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase("selen"))
                .findFirst().get();

        action.moveToElement(selenRadio).click().build().perform();
        logLength++;

        //14. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.

        softAssert.assertThat(log.getText().split("\n").length).isEqualTo(logLength);

        String logLine4Radio = log.getText().split("\n")[0]
                .substring(9)
                .trim()
                .toLowerCase();
        Assert.assertEquals(logLine4Radio, "metal: value changed to selen");


        softAssert.assertThat(logLine4Radio).isEqualTo("metal: value changed to selen");
        softAssert.assertAll();

        //15. Select in dropdown
        WebElement dropdown = dropdowns.get(0);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='Yellow']")).click();
        logLength++;

        //16. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.

        softAssert.assertThat(log.getText().split("\n").length).isEqualTo(logLength);

        String logLine4Dropdown = log.getText().split("\n")[0]
                .substring(9)
                .trim()
                .toLowerCase();

        softAssert.assertThat(logLine4Dropdown).isEqualTo("colors: value changed to yellow");
        softAssert.assertAll();

        //17. Unselect and assert checkboxes
        action.moveToElement(waterCheckBox)
                .click()
                .build().perform();

        logLength++;

        action.moveToElement(windCheckBox)
                .click()
                .build().perform();

        logLength++;

        softAssert.assertThat(waterCheckBox.isSelected()).isFalse();
        softAssert.assertThat(windCheckBox.isSelected()).isFalse();
        softAssert.assertAll();

        //18. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.

        softAssert.assertThat(log.getText().split("\n").length).isEqualTo(logLength);

        String logLine4Unchecked = log.getText().split("\n")[0]
                .substring(9)
                .trim()
                .toLowerCase();
        softAssert.assertThat(logLine4Unchecked).isEqualTo("wind: condition changed to false");

        logLine4Unchecked = log.getText().split("\n")[1]
                .substring(9)
                .trim()
                .toLowerCase();
        softAssert.assertThat(logLine4Unchecked).isEqualTo("water: condition changed to false");
        softAssert.assertAll();
    }

    @AfterClass
    public void clearActions() {
        //19. Close Browser
        driver.quit();
    }
}
