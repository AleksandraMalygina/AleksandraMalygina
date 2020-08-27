package hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSection extends BasePage {

    @FindBy(name = "log-sidebar")
    private WebElement rightSection;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement log;

    public RightSection(WebDriver driver) {
        super(driver);
    }

    public List<String> getLastLogLines(int linesNumber) {
        List<String> allLines = new ArrayList<>(Arrays.asList(log.getText().split("\n")));
        List<String> lines = allLines.subList(0, linesNumber);
        lines.replaceAll(a -> a.substring(9).trim().toLowerCase());

        return lines;
    }

    public String getLastLogLine() {
       String line = log.getText()
               .split("\n")[0]
               .substring(9)
               .trim()
               .toLowerCase();

        return line;
    }
}
