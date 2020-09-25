package hwjdi;

import hwjdi.beans.MetalColorEntity;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hwjdi.entities.User;
import hwjdi.pages.HomePage;
import hwjdi.pages.MetalsAndColorsPage;

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

    public static void submitFormOnMetalsAndColorsPageWith(MetalColorEntity  mcEntity) {
        metalColorPage.submitFormWith(mcEntity);
    }

    public static void cleanFormsOnMetalsAndColorsPage() {
        metalColorPage.cleanForm();
    }

    public static List<String> getLogSummary() {
        return metalColorPage.getLogSummary();
    }
}
