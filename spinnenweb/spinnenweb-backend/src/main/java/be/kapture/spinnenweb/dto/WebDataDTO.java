package be.kapture.spinnenweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WebDataDTO {
    private String categorie;
    private List<String> labels;
    @JsonProperty("data")
    private List<WebDataPointsDTO> dataPoints;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<WebDataPointsDTO> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<WebDataPointsDTO> dataPoints) {
        this.dataPoints = dataPoints;
    }
}
