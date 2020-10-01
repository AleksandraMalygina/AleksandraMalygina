package hwjdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import hwjdi.entities.User;
import hwjdi.beans.MetalColorEntity;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static org.assertj.core.api.Assertions.assertThat;

public class JdiTest {

    @BeforeSuite
    public void setUp() {
        initElements(Site.class);
    }

    @AfterSuite
    public void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @Test
    public void loginTest() {
        //  1. open main page
        Site.open();
        //  2. login as Roman Iovlev
        Site.login(User.ROMAN);
        //  3. Assert that userName is ROMAN
        Assert.assertEquals(Site.getUserName(), User.ROMAN.getUserName());
        //  4. Open metal&Color Page
        Site.goToMetalAndColorsPage();
    }

    @Test(dependsOnMethods = "loginTest",
            dataProvider = "expectedDataProvider",
            dataProviderClass = DataProviders.class)
    public void metalAndColorSubmitFormTest(MetalColorEntity entity, List<String> expectedLog) {
        //  5. Choose pre-defined elements(Fill form)
        //  6. submit form
        Site.submitFormOnMetalsAndColorsPageWith(entity);
        //  7. Assert That result section contains pre-defined data
        assertThat(Site.getLogSummary())
            .containsExactlyInAnyOrderElementsOf(expectedLog);
        Site.cleanFormsOnMetalsAndColorsPage();
    }
}
