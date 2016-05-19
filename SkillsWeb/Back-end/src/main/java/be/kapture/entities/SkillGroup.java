package be.kapture.entities;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class SkillGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private SkillNature skillNature;
    private Set<Skill> skills;

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

    public SkillNature getSkillNature() {
        return skillNature;
    }

    public void setSkillNature(SkillNature skillNature) {
        this.skillNature = skillNature;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }}
