package be.kapture.spinnenweb.dto;

import be.kapture.spinnenweb.model.EvaluatieScore;

import java.util.ArrayList;
import java.util.List;

public class EvaluatieSubcategorieDTO {
    private Long id;

    private String naam;
    private EvaluatieScore evaluatieScore;
    private List<EvaluatieSkillDTO> evaluatieSkillList = new ArrayList<>();

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

    public EvaluatieScore getEvaluatieScore() {
        return evaluatieScore;
    }

    public void setEvaluatieScore(EvaluatieScore evaluatieScore) {
        this.evaluatieScore = evaluatieScore;
    }

    public List<EvaluatieSkillDTO> getEvaluatieSkillList() {
        return evaluatieSkillList;
    }

    public void setEvaluatieSkillList(List<EvaluatieSkillDTO> evaluatieSkillList) {
        this.evaluatieSkillList = evaluatieSkillList;
    }
}
