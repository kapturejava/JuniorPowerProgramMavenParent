package be.kapture.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * Created by peeters.t on 17/10/2017.
 */

@Entity
@Table
public class Vraag {

    private int id;
    private String vraagTekst;
    private String antwoord;

    private Thema thema;
    private Set<Tag> tags;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVraagTekst() {
        return vraagTekst;
    }

    public void setVraagTekst(String vraagTekst) {
        this.vraagTekst = vraagTekst;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thema.id")
    public Thema getThema() {
        return thema;
    }

    public void setThema(Thema thema) {
        this.thema = thema;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vraag_table",joinColumns = @JoinColumn(name="tag.id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "vraag.id",referencedColumnName = "id"))
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Vraag{" +
                "id=" + id +
                ", vraagTekst='" + vraagTekst + '\'' +
                ", antwoord='" + antwoord + '\'' +
                ", thema=" + thema +
                ", tags=" + tags +
                '}';
    }
}
