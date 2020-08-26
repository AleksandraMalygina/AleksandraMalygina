package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage {

    private WebDriver driver;

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = ("//*[@id=\"user-table\"]/tbody/tr"))
    List<WebElement> tableRows;

    @FindBy(xpath = "//*[@id=\"user-table\"]")
    private WebElement userTable;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public int getNumberOfTypeDropDowns() {
        return userTable.findElements(By.tagName("select")).size();
    }

    public int getNumberOfUserNames() {
        return userTable.findElements(By.tagName("a")).size();
    }

    public int getNumberOfDescriptionTexts() {
        return userTable.findElements(By.tagName("span")).size();
    }

    public int getNumberOfCheckBoxes() {
        return userTable.findElements(By.tagName("input")).size();
    }

    public UserTableItem getUserTableItemByIndex(int id) {

        UserTableItem item = new UserTableItem();

            for (WebElement tableRow : tableRows) {
                if (tableRow.getText().toLowerCase().contains("number")
                | tableRow.getText().toLowerCase().contains("type")
                | tableRow.getText().toLowerCase().contains("User")) {
                    continue;
                }
                if (Integer.parseInt(tableRow.findElement(By.tagName("td")).getText()) == id) {
                    item.setNumber(id);
                    item.setUser(tableRow.findElement(By.tagName("a")).getText());
                    item.setDescription(tableRow.findElement(By.tagName("span"))
                                                    .getText().replace("\n", " "));
                }
            }
        return item;
    }

    public List<UserTableItem> getAllUsers() {
        List<UserTableItem> list = new ArrayList<>();
        for (WebElement tableRow : tableRows) {
            UserTableItem item = new UserTableItem();
            if (tableRow.getText().toLowerCase().contains("number")
            | tableRow.getText().toLowerCase().contains("type")
            | tableRow.getText().toLowerCase().contains("User")) {
                continue;
            }

            item.setNumber(Integer.parseInt(tableRow.findElement(By.tagName("td")).getText()));
            item.setUser(tableRow.findElement(By.tagName("a")).getText());
            item.setDescription(tableRow.findElement(By.tagName("span"))
                                                    .getText().replace("\n", " "));
            list.add(item);
        }
        return list;
    }

    public List<String> getDropDownValuesForRomanUser() {
        List<String> dropDownValues = new ArrayList<>();

        for (WebElement tableRow : tableRows) {
            if (tableRow.getText().toLowerCase().contains("number")
            | tableRow.getText().toLowerCase().contains("type")
            | tableRow.getText().toLowerCase().contains("User")) {
                continue;
            }

            if (tableRow
                //.findElement(By.tagName("a"))
                .findElement(By.tagName("a"))
                .getText()
                .trim()
                .equalsIgnoreCase("roman")) {

                dropDownValues = tableRow
                        .findElements(By.tagName("option"))
                        .stream()
                        .map(a -> a.getText().trim())
                        .collect(Collectors.toList());
                System.out.println(dropDownValues);
                break;
            }
        }
        return dropDownValues;
    }

    public void selectVipButtonForUser(String userName) {
        for (WebElement tableRow : tableRows) {
            if (tableRow.getText().toLowerCase().contains("number")
            | tableRow.getText().toLowerCase().contains("type")
            | tableRow.getText().toLowerCase().contains("User")) {
                continue;
            }

           if (tableRow.findElement(By.tagName("a")).getText().trim().equalsIgnoreCase(userName)) {
               tableRow.findElement(By.xpath("//input[@type='checkbox' and @id='ivan']")).click();
               break;
           }
        }
    }



}
