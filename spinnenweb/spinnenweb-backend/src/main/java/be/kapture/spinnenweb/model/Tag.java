package be.kapture.spinnenweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String naam;

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
