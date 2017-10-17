package be.kapture.spinnenweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WebDataPointsDTO {
    private String label;

    @JsonProperty("data")
    private List<Integer> dataPoints;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Integer> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<Integer> dataPoints) {
        this.dataPoints = dataPoints;
    }
}
