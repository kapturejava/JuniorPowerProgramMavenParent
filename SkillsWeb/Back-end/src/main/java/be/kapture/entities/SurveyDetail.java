package be.kapture.entities;

import java.io.Serializable;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class SurveyDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int score;
	private Survey survey;
	private Skill skill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		if (this.survey != null && this.survey.getSurveyDetails().contains(this)) {
			this.survey.removeSurveyDetail(this);
		}
		this.survey = survey;
		if (survey != null && !survey.getSurveyDetails().contains(this)) {
			survey.addSurveyDetail(this);
		}
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		if (this.skill != null && this.skill.getSurveyDetails().contains(this)) {
			this.skill.removeSurveyDetail(this);
		}
		this.skill = skill;
		if (skill != null && !skill.getSurveyDetails().contains(this)) {
			skill.addSurveyDetail(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + score;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
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
		SurveyDetail other = (SurveyDetail) obj;
		if (score != other.score)
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return survey + " " + skill + " " + score;
	}

}
