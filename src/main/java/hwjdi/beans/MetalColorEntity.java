package hwjdi.beans;

import com.epam.jdi.tools.DataClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetalColorEntity extends DataClass<MetalColorEntity> {
    private List<Integer> summary = new ArrayList<Integer>();
    private List<String> elements = new ArrayList<String>();
    private String color;
    private String metals;
    private List<String> vegetables = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public List<String> getAsList() {
        List<String> dataList = new ArrayList<>();

        dataList.add("Summary: " + this.getSummary()
                .stream()
                .mapToInt(Integer::intValue)
                .sum());
        dataList.add("Elements: " + this.getElements()
                .stream()
                .collect(Collectors.joining(", ")));
        dataList.add("Color: " + this.getColor());
        dataList.add("Metal: " + this.getMetals());
        dataList.add("Vegetables: " + this.getVegetables()
                .stream()
                .collect(Collectors.joining(", ")));
        return dataList;
    }
}
