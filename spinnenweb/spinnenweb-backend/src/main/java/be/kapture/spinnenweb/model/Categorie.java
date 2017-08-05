package be.kapture.spinnenweb.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String naam;

    @Column
    @Type(type = "yes_no")
    private boolean actief;

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

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public static CategorieBuilder CategorieBuilder() {
        return new CategorieBuilder();
    }

    public static class CategorieBuilder {
        private Categorie categorie = new Categorie();

        private CategorieBuilder() {}

        public CategorieBuilder withNaam(String naam) {
            categorie.setNaam(naam);
            return this;
        }

        public Categorie build() {
            return categorie;
        }
    }
}
