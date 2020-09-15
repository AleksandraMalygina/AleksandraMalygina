package hwjdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import hwjdi.entities.User;
import hwjdi.beans.MetalColorEntity;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Map;

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
    public void metalAndColorSubmitFormTest() {
        User roman = new User(DataProviders.login, DataProviders.password, DataProviders.userName);

        //  1. open main page
        Site.open();
        //  2. login as Roman Iovlev
        Site.login(roman);
        //  3. Assert that userName is ROMAN
        Assert.assertEquals(Site.getUserName(), DataProviders.userName);
        //  4. Open metal&Color Page
        Site.goToMetalAndColorsPage();

        Map<String, MetalColorEntity> data = new DataProviders().getData();

        for (Map.Entry<String, MetalColorEntity> entry : data.entrySet()) {
            //  5. Choose pre-defined elements(Fill form)
            Site.fillFormsOnMetalsAndColorsPage(entry.getValue());
            //  6. submit form
            Site.submitFormsOnMetalsAndColorsPage();
            //  7. Assert That result section contains pre-defined data
            assertThat(Site.getLogSummary())
                .containsExactlyInAnyOrderElementsOf(new DataProviders()
                                                        .getExpectedDataAsText(entry.getValue()));

            Site.cleanFormsOnMetalsAndColorsPage();
        }
    }

}
