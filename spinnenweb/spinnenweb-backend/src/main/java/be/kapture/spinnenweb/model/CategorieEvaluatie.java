package be.kapture.spinnenweb.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
public class CategorieEvaluatie {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Categorie categorie;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name="categorie_evaluatie_id", nullable = false)
    private List<SubcategorieEvaluatie> subcategorieEvaluaties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<SubcategorieEvaluatie> getSubcategorieEvaluaties() {
        return subcategorieEvaluaties;
    }

    public void setSubcategorieEvaluaties(List<SubcategorieEvaluatie> subcategorieEvaluaties) {
        this.subcategorieEvaluaties = subcategorieEvaluaties;
    }

    public static CategorieEvaluatieBuilder CategorieEvaluatieBuilder() {
        return new CategorieEvaluatieBuilder();
    }

    public static class CategorieEvaluatieBuilder {
        private CategorieEvaluatie categorieEvaluatie = new CategorieEvaluatie();

        private CategorieEvaluatieBuilder() {}

        public CategorieEvaluatieBuilder withCategorie(Categorie categorie) {
            categorieEvaluatie.setCategorie(categorie);
            return this;
        }

        public CategorieEvaluatieBuilder withSubcategorieEvaluaties(List<SubcategorieEvaluatie> subcategorieEvaluaties) {
            categorieEvaluatie.setSubcategorieEvaluaties(subcategorieEvaluaties);
            return this;
        }

        public CategorieEvaluatie build() {
            return categorieEvaluatie;
        }
    }
}
