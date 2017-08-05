package be.kapture.spinnenweb.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.websocket.ClientEndpoint;
import java.util.List;

@Entity
public class Subcategorie {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Categorie categorie;

    @Column
    private String naam;

    @Column
    @Type(type = "yes_no")
    private boolean actief;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    private void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNaam() {
        return naam;
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isActief() {
        return actief;
    }

    private void setActief(boolean actief) {
        this.actief = actief;
    }

    public static SubcategorieBuilder SubcategorieBuilder() {
        return new SubcategorieBuilder();
    }

    public boolean isPersisted() {
        return getId() != null;
    }

    public static class SubcategorieBuilder {
        private Subcategorie subcategorie = new Subcategorie();

        private SubcategorieBuilder() {}

        public SubcategorieBuilder withNaam(String naam) {
            subcategorie.setNaam(naam);
            return this;
        }

        public SubcategorieBuilder withCategorie(Categorie categorie) {
            subcategorie.setCategorie(categorie);
            return this;
        }

        public Subcategorie build() {
            return subcategorie;
        }
    }
}
