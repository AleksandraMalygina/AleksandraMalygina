package hwjdi.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hwjdi.beans.MetalColorEntity;

import java.util.ArrayList;
import java.util.List;

public class MetalColorForm extends Form<MetalColorEntity> {
    @Css("input[type=radio]")
    private RadioButtons summary;

    // @XPath("//p[@class='checkbox']/input")
    @Css("#elements-checklist [type=checkbox]")
    private Checklist elements;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown color;

    @JDropdown(root = "div#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#vegetables",
            value = "#salad-dropdown > button",
            list = "li",
            expand = ".caret")
    private Dropdown vegetables;

    @UI("['Submit']")
    public Button submit;

    private List<String> vegets = new ArrayList<>();

    @Override
    public void submit(MetalColorEntity mcEntity) {
        for (Integer curSum : mcEntity.getSummary()) {
            summary.select(String.valueOf(curSum));
        }

        for (String element : mcEntity.getElements()) {
            elements.select(element);
        }

        color.select(mcEntity.getColor());
        metals.select(mcEntity.getMetals());
        vegets = mcEntity.getVegetables();

        vegetables.select("vegetables");
        for (String vegetable : mcEntity.getVegetables()) {
            vegetables.select(vegetable);
        }
        submit.click();
    }

    public void cleanForm() {
        List<String> vals = elements.checked();
        for (String val : vals) {
            elements.select(val);
        }
        color.select(1);
        metals.select(1);
        for (String veget : vegets) {
            vegetables.select(veget);
        }
        vegetables.select("vegetables");
    }
}
