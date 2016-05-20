package be.kapture.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class SkillNature implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<SkillGroup> skillGroups = new HashSet<>();

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
		for (SkillGroup skillGroup : skillGroups) {
			if (!skillGroup.getSkillNature().equals(this)) {
				skillGroup.setSkillNature(this);
			}
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
		SkillNature other = (SkillNature) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillNature [id=" + id + ", name=" + name + "]";
	}

	public void addSkillGroup(SkillGroup skillGroup) {
		skillGroups.add(skillGroup);
		if (skillGroup.getSkillNature() != this) {
			skillGroup.setSkillNature(this);
		}
	}

	public void removeSkillNature(SkillGroup skillGroup) {
		skillGroups.remove(skillGroup);
		if (skillGroup.getSkillNature() == this) {
			skillGroup.setSkillNature(null);
		}

	}

}
