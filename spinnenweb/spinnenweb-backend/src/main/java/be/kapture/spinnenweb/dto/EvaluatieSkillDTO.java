package be.kapture.spinnenweb.dto;

import be.kapture.spinnenweb.model.EvaluatieScore;

public class EvaluatieSkillDTO {
    private Long id;

    private String naam;
    private EvaluatieScore evaluatieScore;

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
}
