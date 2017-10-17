package be.kapture.spinnenweb.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "evaluatiedocument")
public class EvaluatieDocument {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Persoon persoon;

    /// TODO: EvaluatieTimestamp toevoegen, sorteren op datum ipv id

    @Column(name = "evaluatiedoel")
    @Enumerated(EnumType.STRING)
    private EvaluatieDoel evaluatieDoel;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name="evaluatiedocument_id", nullable = false)
    private List<CategorieEvaluatie> categorieEvaluaties;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    private void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public EvaluatieDoel getEvaluatieDoel() {
        return evaluatieDoel;
    }

    private void setEvaluatieDoel(EvaluatieDoel evaluatieDoel) {
        this.evaluatieDoel = evaluatieDoel;
    }

    public List<CategorieEvaluatie> getCategorieEvaluaties() {
        return categorieEvaluaties;
    }

    private void setCategorieEvaluaties(List<CategorieEvaluatie> categorieEvaluaties) {
        this.categorieEvaluaties = categorieEvaluaties;
    }

    public static EvaluatieDocumentBuilder EvaluatieDocumentBuilder() {
        return new EvaluatieDocumentBuilder();
    }

    public static class EvaluatieDocumentBuilder {
        private EvaluatieDocument evaluatieDocument = new EvaluatieDocument();

        private EvaluatieDocumentBuilder() {}

        public EvaluatieDocumentBuilder withPersoon(Persoon persoon) {
            evaluatieDocument.setPersoon(persoon);
            return this;
        }

        public EvaluatieDocumentBuilder withEvaluatieDoel(EvaluatieDoel evaluatieDoel) {
            evaluatieDocument.setEvaluatieDoel(evaluatieDoel);
            return this;
        }

        public EvaluatieDocumentBuilder withCategorieEvaluaties(List<CategorieEvaluatie> categorieEvaluaties) {
            evaluatieDocument.setCategorieEvaluaties(categorieEvaluaties);
            return this;
        }

        public EvaluatieDocument build() {
            return evaluatieDocument;
        }
    }
}
