package hw5.steps;

import hw5.MainPage;
import hw5.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class ModelSteps {
    @Given("I open JDI GitHub site")
    public void iopenJdiGitHubSite() {
       new MainPage(TestContext.getInstance().getDriver())
               .openPage(TestContext.getInstance().getTestData().getUrl());
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void iloginAsUser() {
        new MainPage(TestContext.getInstance().getDriver())
                .enterCreds(TestContext.getInstance().getTestData().getLogin(),
                            TestContext.getInstance().getTestData().getPassword());

    }

    @Given("I click on \"Service\" button in Header")
    public void iclickOnServiceButtonInHeader() {
        new MainPage(TestContext.getInstance().getDriver()).clickOnServiceHeaderButton();

    }

    @Given("I click on {string} button in Service dropdown")
    public void iclickOnDifferentElementsButtonInServiceDropdown(String elementName) {
        new MainPage(TestContext.getInstance().getDriver()).clickOnServiceElement(elementName);
    }



}
