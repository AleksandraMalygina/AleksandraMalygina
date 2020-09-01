package hw5.steps;

import hw5.DifferentElementsPage;
import hw5.UserTablePage;
import hw5.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionSteps {

    @When("I select {string} checkbox on the Different Elements Page")
    public void iselectCheckboxOnTheDifferentElementsPage(String itemName) {
        new DifferentElementsPage(TestContext.getInstance().getDriver())
                .clickCheckBox(itemName);

        TestContext
                .getInstance()
                .getLogData()
                .add(new DifferentElementsPage(TestContext.getInstance().getDriver())
                        .getLastLogLine());
    }

    @When("I select {string} radiobutton on the Different Elements Page")
    public void iselectRadiobuttonOnTheDifferentElementsPage(String itemName) {
        new DifferentElementsPage(TestContext.getInstance().getDriver())
                .selectRadio(itemName);

        TestContext
                .getInstance()
                .getLogData()
                .add(new DifferentElementsPage(TestContext.getInstance().getDriver())
                        .getLastLogLine());
    }

    @When("I click on color dropdown menu on the Different Elements Page")
    public void iclickOnColorDropdownMenuOnTheDifferentElementsPage() {
        new DifferentElementsPage(TestContext.getInstance().getDriver())
                .clickOnDropdown();
    }

    @When("I click on {string} button in color dropdown on the Different Elements Page")
    public void iclickOnButtonInColorDropdownOnTheDifferentElementsPage(String colorName) {
        new DifferentElementsPage(TestContext.getInstance().getDriver())
                .selectFromDropDrown(colorName);

        TestContext
                .getInstance()
                .getLogData()
                .add(new DifferentElementsPage(TestContext.getInstance().getDriver())
                        .getLastLogLine());
    }

    @When("I select 'vip' checkbox for {string}")
    public void iselectVipCheckboxFor(String userName) {

        new UserTablePage(TestContext.getInstance().getDriver()).selectVipButtonForUser(userName);

    }
}
