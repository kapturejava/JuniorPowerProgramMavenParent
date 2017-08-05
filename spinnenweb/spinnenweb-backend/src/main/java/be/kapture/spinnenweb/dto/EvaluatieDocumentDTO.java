package be.kapture.spinnenweb.dto;

import be.kapture.spinnenweb.model.EvaluatieDoel;

import java.util.ArrayList;
import java.util.List;

public class EvaluatieDocumentDTO {
    private PersoonDTO persoon;
    private EvaluatieDoel evaluatieDoel;

    private List<EvaluatieCategorieDTO> evaluatieCategorieList = new ArrayList<>();

    public PersoonDTO getPersoon() {
        return persoon;
    }

    public void setPersoon(PersoonDTO persoon) {
        this.persoon = persoon;
    }

    public EvaluatieDoel getEvaluatieDoel() {
        return evaluatieDoel;
    }

    public void setEvaluatieDoel(EvaluatieDoel evaluatieDoel) {
        this.evaluatieDoel = evaluatieDoel;
    }

    public List<EvaluatieCategorieDTO> getEvaluatieCategorieList() {
        return evaluatieCategorieList;
    }

    public void setEvaluatieCategorieList(List<EvaluatieCategorieDTO> evaluatieCategorieList) {
        this.evaluatieCategorieList = evaluatieCategorieList;
    }
}
