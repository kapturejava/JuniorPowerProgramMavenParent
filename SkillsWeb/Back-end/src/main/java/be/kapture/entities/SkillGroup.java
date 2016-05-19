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
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skillNature == null) ? 0 : skillNature.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillGroup other = (SkillGroup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skillNature == null) {
			if (other.skillNature != null)
				return false;
		} else if (!skillNature.equals(other.skillNature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillGroup [id=" + id + ", name=" + name + ", skillNature=" + skillNature + ", skills=" + skills + "]";
	}}


