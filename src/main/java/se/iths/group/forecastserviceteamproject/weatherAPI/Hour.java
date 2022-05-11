
package se.iths.group.forecastserviceteamproject.weatherAPI;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "time_epoch",
    "time",
    "temp_c",
    "temp_f",
    "condition",
    "humidity"
})
@Generated("jsonschema2pojo")
public class Hour {

    @JsonProperty("time_epoch")
    private Integer timeEpoch;
    @JsonProperty("time")
    private String time;
    @JsonProperty("temp_c")
    private Double tempC;
    @JsonProperty("temp_f")
    private Double tempF;
    @JsonProperty("condition")
    private Condition__2 condition;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("time_epoch")
    public Integer getTimeEpoch() {
        return timeEpoch;
    }

    @JsonProperty("time_epoch")
    public void setTimeEpoch(Integer timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("temp_c")
    public Double getTempC() {
        return tempC;
    }

    @JsonProperty("temp_c")
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    @JsonProperty("temp_f")
    public Double getTempF() {
        return tempF;
    }

    @JsonProperty("temp_f")
    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    @JsonProperty("condition")
    public Condition__2 getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(Condition__2 condition) {
        this.condition = condition;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
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
