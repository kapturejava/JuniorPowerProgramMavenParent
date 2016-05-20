package be.kapture.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double weight;
	private SkillGroup skillGroup;
	private Set<SurveyDetail> surveyDetails = new HashSet<>();

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
		if(weight < 0 || weight > 100){
			throw new IllegalArgumentException();
		}
		this.weight = weight;
	}

	public SkillGroup getSkillGroup() {
		return skillGroup;
	}

	public void setSkillGroup(SkillGroup skillGroup) {
		if (this.skillGroup != null && this.skillGroup.getSkills().contains(this)) {
			this.skillGroup.removeSkill(this);
		}
		this.skillGroup = skillGroup;
		if (skillGroup != null && !skillGroup.getSkills().contains(this)) {
			skillGroup.addSkill(this);
		}
	}

	public Set<SurveyDetail> getSurveyDetails() {
		return surveyDetails;
	}

	public void setSurveyDetails(Set<SurveyDetail> surveyDetails) {
		this.surveyDetails = surveyDetails;
	}

	public void addSurveyDetail(SurveyDetail surveyDetail) {
		surveyDetails.add(surveyDetail);
		if (surveyDetail.getSkill() != this) {
			surveyDetail.setSkill(this);
		}
	}

	public void removeSurveyDetail(SurveyDetail surveyDetail) {
		surveyDetails.remove(surveyDetail);
		if (surveyDetail.getSkill() == this) {
			surveyDetail.setSkill(null);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", weight=" + weight + ", skillGroup=" + skillGroup + "]";
	}

}
