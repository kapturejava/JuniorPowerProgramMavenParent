package be.kapture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by peeters.t on 17/10/2017.
 */

@Entity
@Table
public class Tag {

    private int id;
    private String tagNaam;

    private Set<Vraag> vragen;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagNaam() {
        return tagNaam;
    }

    public void setTagNaam(String tagNaam) {
        this.tagNaam = tagNaam;
    }

    @ManyToMany(mappedBy = "tags")
    public Set<Vraag> getVragen() {
        return vragen;
    }

    public void setVragen(Set<Vraag> vragen) {
        this.vragen = vragen;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagNaam='" + tagNaam + '\'' +
                ", vragen=" + vragen +
                '}';
    }
}
