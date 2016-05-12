package be.kapture.entities;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class SurveyDetail {

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
		this.survey = survey;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
    
    
    
}
