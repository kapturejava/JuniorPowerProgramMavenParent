package be.kapture.entities;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class SkillNature implements Serializable{
	private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Set<SkillGroup> skillGroups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SkillGroup> getSkillGroups() {
        return skillGroups;
    }

    public void setSkillGroups(Set<SkillGroup> skillGroups) {
        this.skillGroups = skillGroups;
    }
}
