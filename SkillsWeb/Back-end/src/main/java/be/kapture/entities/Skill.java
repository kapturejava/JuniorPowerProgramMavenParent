package be.kapture.entities;

import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class Skill {

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
}
