package be.kapture.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class SkillGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private SkillNature skillNature;
	private Set<Skill> skills = new HashSet<>();

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
		if (this.skillNature != null && this.skillNature.getSkillGroups().contains(this)) {
			this.skillNature.removeSkillNature(this);
		}
		this.skillNature = skillNature;
		if (skillNature != null && skillNature.getSkillGroups().contains(this)) {
			skillNature.addSkillGroup(this);
		}
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public void addSkill(Skill skill) {
		skills.add(skill);
		if (skill.getSkillGroup() != this) {
			skill.setSkillGroup(this);
		}
	}

	public void removeSkill(Skill skill) {
		skills.remove(skill);
		if (skill.getSkillGroup() == this) {
			skill.setSkillGroup(null);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "SkillGroup [id=" + id + ", name=" + name + ", skillNature=" + skillNature + "]";
	}

}