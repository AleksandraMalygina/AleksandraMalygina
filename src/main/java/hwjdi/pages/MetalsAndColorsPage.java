package hwjdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import hwjdi.beans.MetalColorEntity;
import hwjdi.forms.MetalColorForm;
import org.openqa.selenium.By;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {
    @FindBy(xpath = "//div[@class='main-content-hg']/form")
    private MetalColorForm metalColorForm;

    @FindBy(css = ".panel-body-list.results")
    private UIElement dataContainer;

    public List<String> getLogSummary() {
        WebList listOfData = dataContainer.finds(By.tagName("li"));
        return listOfData.values();
    }

    public void submitFormWith(MetalColorEntity mcEntity) {
        metalColorForm.submit(mcEntity);
    }

    public void cleanForm() {
        metalColorForm.cleanForm();
    }
}
