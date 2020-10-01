package hwjdi.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import hwjdi.entities.User;
import hwjdi.forms.LoginForm;

public class HomePage extends WebPage {
    @Css("#login-form")
    private LoginForm loginForm;

    @Css("img#user-icon")
    private Icon userIcon;

    @FindBy (id = "user-name")
    private Label userName;

    @FindBy(xpath = "//a[contains(text(), 'Metals')]")
    private Link metalAndColorsPageLink;

    public void login(User user) {
        userIcon.click();
        loginForm.loginAs(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void goToMetalAndColorsPage() {
        metalAndColorsPageLink.click();
    }
}
