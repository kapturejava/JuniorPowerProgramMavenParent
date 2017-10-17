package be.kapture.spinnenweb.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String naam;

    @Column
    @Type(type = "yes_no")
    private boolean actief;

    @ManyToOne
    private Subcategorie subcategorie;

    public Subcategorie getSubcategorie() {
        return subcategorie;
    }

    private void setSubcategorie(Subcategorie subcategorie) {
        this.subcategorie = subcategorie;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
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

    public static SkillBuilder SkillBuilder() {
        return new SkillBuilder();
    }

    public static class SkillBuilder {
        private Skill skill = new Skill();

        private SkillBuilder() {}

        public SkillBuilder withNaam(String naam) {
            skill.setNaam(naam);
            return this;
        }

        public SkillBuilder withSubcategorie(Subcategorie subcategorie) {
            skill.setSubcategorie(subcategorie);
            return this;
        }

        public Skill build() {
            return skill;
        }

    }
}
