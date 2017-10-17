package be.kapture.spinnenweb.dto;

import java.util.ArrayList;
import java.util.List;

public class EvaluatieCategorieDTO {
    private Long id;

    private String naam;
    private List<EvaluatieSubcategorieDTO> evaluatieSubcategorieList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<EvaluatieSubcategorieDTO> getEvaluatieSubcategorieList() {
        return evaluatieSubcategorieList;
    }

    public void setEvaluatieSubcategorieList(List<EvaluatieSubcategorieDTO> evaluatieSubcategorieList) {
        this.evaluatieSubcategorieList = evaluatieSubcategorieList;
    }
}
