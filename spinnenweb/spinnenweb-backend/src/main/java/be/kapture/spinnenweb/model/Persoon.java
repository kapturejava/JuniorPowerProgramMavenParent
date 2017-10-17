package be.kapture.spinnenweb.model;

import be.kapture.spinnenweb.dto.TagDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Persoon {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String naam;
    @Column
    @Enumerated(EnumType.STRING)
    private PersoonType persoonType;

    @ManyToMany(targetEntity = Tag.class)
    @JoinTable(name="persoon_tag",
        joinColumns=@JoinColumn(name="tag_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="persoon_id", referencedColumnName = "id"))
    private List<Tag> tags;

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

    public List<Tag> getTags() {
        return tags;
    }

    private void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public PersoonType getPersoonType() {
        return persoonType;
    }

    private void setPersoonType(PersoonType persoonType) {
        this.persoonType = persoonType;
    }

    public static PersoonBuilder PersoonBuilder() {
        return new PersoonBuilder();
    }

    public static class PersoonBuilder {
        private Persoon persoon = new Persoon();

        private PersoonBuilder() {}

        public PersoonBuilder withNaam(String naam) {
            persoon.setNaam(naam);
            return this;
        }

        public PersoonBuilder withTags(List<Tag> tags) {
            persoon.setTags(tags);
            return this;
        }

        public PersoonBuilder withPersoonType(PersoonType persoonType) {
            persoon.setPersoonType(persoonType);
            return this;
        }

        public Persoon build() {
            return persoon;
        }
    }
}
