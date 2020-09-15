package hwjdi.beans;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "summary",
        "elements",
        "color",
        "metals",
        "vegetables"
})
public class MetalColorEntity extends DataClass<MetalColorEntity> {

    @JsonProperty("summary")
    private List<Integer> summary = new ArrayList<Integer>();
    @JsonProperty("elements")
    private List<String> elements = new ArrayList<String>();
    @JsonProperty("color")
    private String color;
    @JsonProperty("metals")
    private String metals;
    @JsonProperty("vegetables")
    private List<String> vegetables = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("summary")
    public List<Integer> getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    @JsonProperty("elements")
    public List<String> getElements() {
        return elements;
    }

    @JsonProperty("elements")
    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("metals")
    public String getMetals() {
        return metals;
    }

    @JsonProperty("metals")
    public void setMetals(String metals) {
        this.metals = metals;
    }

    @JsonProperty("vegetables")
    public List<String> getVegetables() {
        return vegetables;
    }

    @JsonProperty("vegetables")
    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MetalColorEntity.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null) ? "<null>" : this.summary));
        sb.append(',');
        sb.append("elements");
        sb.append('=');
        sb.append(((this.elements == null) ? "<null>" : this.elements));
        sb.append(',');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null) ? "<null>" : this.color));
        sb.append(',');
        sb.append("metals");
        sb.append('=');
        sb.append(((this.metals == null) ? "<null>" : this.metals));
        sb.append(',');
        sb.append("vegetables");
        sb.append('=');
        sb.append(((this.vegetables == null) ? "<null>" : this.vegetables));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.summary == null) ? 0 : this.summary.hashCode()));
        result = ((result * 31) + ((this.color == null) ? 0 : this.color.hashCode()));
        result = ((result * 31) + ((this.elements == null) ? 0 : this.elements.hashCode()));
        result = ((result * 31) + ((this.metals == null) ? 0 : this.metals.hashCode()));
        result = ((result * 31)
                + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.vegetables == null) ? 0 : this.vegetables.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetalColorEntity) == false) {
            return false;
        }
        MetalColorEntity rhs = ((MetalColorEntity) other);
        return (((((((this.summary == rhs.summary) || ((this.summary != null)
                && this.summary.equals(rhs.summary))) && ((this.color == rhs.color)
                || ((this.color != null) && this.color.equals(rhs.color))))
                && ((this.elements == rhs.elements) || ((this.elements != null)
                && this.elements.equals(rhs.elements)))) && ((this.metals == rhs.metals)
                || ((this.metals != null) && this.metals.equals(rhs.metals))))
                && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))))
                && ((this.vegetables == rhs.vegetables) || ((this.vegetables != null)
                && this.vegetables.equals(rhs.vegetables))));
    }

}
