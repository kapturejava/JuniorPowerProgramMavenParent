package be.kapture.entities;

import java.util.Date;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class Survey {

	private int id;
	private Date date;
	private Person person;
	private Set<SurveyDetail> surveyDetails;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<SurveyDetail> getSurveyDetails() {
		return surveyDetails;
	}

	public void setSurveyDetails(Set<SurveyDetail> surveyDetails) {
		this.surveyDetails = surveyDetails;
	}
}
