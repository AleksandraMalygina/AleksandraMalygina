package hw5.steps;

import hw5.MainPage;
import hw5.RightSection;
import hw5.UserTablePage;
import hw5.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSteps {

    @Then("I check page title")
    public void icheckPageTitle() {
        assertThat(new MainPage(TestContext.getInstance().getDriver()).returnPageTitle())
                .isEqualTo(TestContext.getInstance().getTestData().getPageTitle());
    }

    @Then("I check userName")
    public void icheckUserName() {
        assertThat(new MainPage(TestContext.getInstance().getDriver()).returnUserName())
                .isEqualTo(TestContext.getInstance().getTestData().getUserName());
    }

    @Then("log rows should consist of the following values:")
    public void logRowsShouldConsistOfTheExpectedValues(DataTable expDataTable) {

        List<String> expectedData = expDataTable.asList();
        assertThat(TestContext.getInstance().getLogData())
                .isEqualTo(expectedData);

    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageTitle) {
        assertThat(new UserTablePage(TestContext.getInstance().getDriver())
                .getPageTitle()
                .toLowerCase())
                .isEqualTo(pageTitle.toLowerCase());
    }


    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedItemNumber) {
        assertThat(new UserTablePage(TestContext.getInstance().getDriver())
                .getNumberOfTypeDropDowns())
                .isEqualTo(expectedItemNumber);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedItemNumber) {
        assertThat(new UserTablePage(TestContext.getInstance().getDriver())
                .getNumberOfUserNames())
                .isEqualTo(expectedItemNumber);
    }

    @Then("{int} Description texts under images "
            + "should be displayed on Users Table on User Table Page")
    public void descriptionTextsShouldBeDisplayedOnUsersTableOnUserTablePage(int expItemNumber) {
        assertThat(new UserTablePage(TestContext.getInstance().getDriver())
                .getNumberOfDescriptionTexts())
                .isEqualTo(expItemNumber);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedItemNumber) {
        assertThat(new UserTablePage(TestContext.getInstance().getDriver())
                .getNumberOfCheckBoxes())
                .isEqualTo(expectedItemNumber);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {

        List<List<String>> parameterLines = dataTable.asLists(String.class);
        for (List<String> parameterLine : parameterLines) {
            if (parameterLine.contains("Number")) {
                continue;
            }
            TestContext
                    .getInstance()
                    .getExpectedTableItems()
                    .add(parameterLine
                            .stream()
                            .collect(Collectors.joining(" ")));
        }

        TestContext.getInstance().getActualTableItems().addAll(
                new UserTablePage(TestContext.getInstance().getDriver())
                        .getAllUsers()
                        .stream()
                        .map(a -> a.makeStringFromThisUser())
                        .collect(Collectors.toList()));

        assertThat(TestContext.getInstance().getActualTableItems())
                .containsExactlyInAnyOrderElementsOf(TestContext
                                                        .getInstance()
                                                        .getExpectedTableItems());
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValInColumnTypeForUserRoman(List<String> expDropdownValues) {

        assertThat(new UserTablePage(TestContext.getInstance().getDriver())
                .getDropDownValuesForRomanUser())
                .containsExactlyInAnyOrderElementsOf(
                        expDropdownValues.subList(1, expDropdownValues.size()));
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String logText) {
        assertThat(new RightSection(TestContext.getInstance().getDriver()).getLastLogLine())
                .isEqualToIgnoringCase(logText);
    }
}
