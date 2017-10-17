package be.kapture.spinnenweb.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
public class SubcategorieEvaluatie {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Subcategorie subcategorie;

    @Column
    @Enumerated(EnumType.STRING)
    private EvaluatieScore evaluatieScore;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name="subcategorie_evaluatie_id", nullable = false)
    private List<SkillEvaluatie> skillEvaluaties;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Subcategorie getSubcategorie() {
        return subcategorie;
    }

    private void setSubcategorie(Subcategorie subcategorie) {
        this.subcategorie = subcategorie;
    }

    public EvaluatieScore getEvaluatieScore() {
        return evaluatieScore;
    }

    private void setEvaluatieScore(EvaluatieScore evaluatieScore) {
        this.evaluatieScore = evaluatieScore;
    }

    public List<SkillEvaluatie> getSkillEvaluaties() {
        return skillEvaluaties;
    }

    private void setSkillEvaluaties(List<SkillEvaluatie> skillEvaluaties) {
        this.skillEvaluaties = skillEvaluaties;
    }

    public static SubcategorieEvaluatieBuilder SubcategorieEvaluatieBuilder() {
        return new SubcategorieEvaluatieBuilder();
    }

    public static class SubcategorieEvaluatieBuilder {
        private SubcategorieEvaluatie subcategorieEvaluatie = new SubcategorieEvaluatie();

        private SubcategorieEvaluatieBuilder() {}

        public SubcategorieEvaluatieBuilder withSubcategorie(Subcategorie subcategorie) {
            subcategorieEvaluatie.setSubcategorie(subcategorie);
            return this;
        }

        public SubcategorieEvaluatieBuilder withEvaluatieScore(EvaluatieScore evaluatieScore) {
            subcategorieEvaluatie.setEvaluatieScore(evaluatieScore);
            return this;
        }

        public SubcategorieEvaluatieBuilder withSkillEvaluaties(List<SkillEvaluatie> skillEvaluaties) {
            subcategorieEvaluatie.setSkillEvaluaties(skillEvaluaties);
            return this;
        }

        public SubcategorieEvaluatie build() {
            return subcategorieEvaluatie;
        }
    }
}
