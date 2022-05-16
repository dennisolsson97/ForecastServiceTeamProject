
package se.iths.group.forecastserviceteamproject.business.model.met;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "summary",
    "details"
})
@Generated("jsonschema2pojo")
public class Next1Hours {

    @JsonProperty("summary")
    private Summary__1 summary;
    @JsonProperty("details")
    private Details__1 details;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("summary")
    public Summary__1 getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary__1 summary) {
        this.summary = summary;
    }

    @JsonProperty("details")
    public Details__1 getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details__1 details) {
        this.details = details;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
