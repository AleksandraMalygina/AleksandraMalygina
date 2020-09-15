package hwjdi;

import hwjdi.beans.MetalColorEntity;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hwjdi.entities.User;
import hwjdi.pagesandforms.HomePage;
import hwjdi.pagesandforms.MetalsAndColorsPage;

import java.util.List;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class Site {

    @Url("/index.html")
    public static HomePage homePage;
    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalColorPage;


    public static void open() {
        homePage.openSite();
    }

    public static void login(User user) {
        homePage.login(user);
    }

    public static String getUserName() {
        return homePage.getUserName();
    }

    public static void goToMetalAndColorsPage() {
        homePage.goToMetalAndColorsPage();
        metalColorPage.checkOpened();
    }

    public static void fillFormsOnMetalsAndColorsPage(MetalColorEntity  mcEntity) {
        metalColorPage.fillForms(mcEntity);
    }

    public static void submitFormsOnMetalsAndColorsPage() {
        metalColorPage.submitForms();
    }

    public static void cleanFormsOnMetalsAndColorsPage() {

        metalColorPage.cleanForm();
    }

    public static void assertSummaryLog() {

    }


    public static List<String> getLogSummary() {

        return metalColorPage.getLogSummary();
    }
}
