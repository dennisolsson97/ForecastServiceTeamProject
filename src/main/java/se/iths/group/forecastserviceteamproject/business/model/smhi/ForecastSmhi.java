
package se.iths.group.forecastserviceteamproject.business.model.smhi;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "approvedTime",
    "referenceTime",
    "geometry",
    "timeSeries"
})
@Generated("jsonschema2pojo")
public class ForecastSmhi {

    @JsonProperty("approvedTime")
    private String approvedTime;
    @JsonProperty("referenceTime")
    private String referenceTime;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("timeSeries")
    private List<TimeSeries> timeSeries = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("approvedTime")
    public String getApprovedTime() {
        return approvedTime;
    }

    @JsonProperty("approvedTime")
    public void setApprovedTime(String approvedTime) {
        this.approvedTime = approvedTime;
    }

    @JsonProperty("referenceTime")
    public String getReferenceTime() {
        return referenceTime;
    }

    @JsonProperty("referenceTime")
    public void setReferenceTime(String referenceTime) {
        this.referenceTime = referenceTime;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("timeSeries")
    public List<TimeSeries> getTimeSeries() {
        return timeSeries;
    }

    @JsonProperty("timeSeries")
    public void setTimeSeries(List<TimeSeries> timeSeries) {
        this.timeSeries = timeSeries;
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
