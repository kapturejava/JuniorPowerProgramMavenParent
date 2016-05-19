package be.kapture.entities;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class Skill implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double weight;
	private SkillGroup skillGroup;
	private Set<SurveyDetail> surveyDetails;

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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public SkillGroup getSkillGroup() {
		return skillGroup;
	}

	public void setSkillGroup(SkillGroup skillGroup) {
		this.skillGroup = skillGroup;
	}

	public Set<SurveyDetail> getSurveyDetails() {
		return surveyDetails;
	}

	public void setSurveyDetails(Set<SurveyDetail> surveyDetails) {
		this.surveyDetails = surveyDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skillGroup == null) ? 0 : skillGroup.hashCode());
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
		Skill other = (Skill) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skillGroup == null) {
			if (other.skillGroup != null)
				return false;
		} else if (!skillGroup.equals(other.skillGroup))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", weight=" + weight + ", skillGroup=" + skillGroup
				+ ", surveyDetails=" + surveyDetails + "]";
	}
	
	
	
	
}
