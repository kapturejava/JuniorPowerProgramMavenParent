package be.kapture.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class Survey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	private Person person;
	private Set<SurveyDetail> surveyDetails = new HashSet<>();

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
		if (this.person != null && this.person.getSurveys().contains(this)) {
			this.person.removeSurvey(this);
		}
		this.person = person;
		if (person != null && !person.getSurveys().contains(this)) {
			person.addSurvey(this);
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
		if (surveyDetail.getSurvey() != this) {
			surveyDetail.setSurvey(this);
		}
	}

	public void removeSurveyDetail(SurveyDetail surveyDetail) {
		surveyDetails.remove(surveyDetail);
		if (surveyDetail.getSurvey() == this) {
			surveyDetail.setSurvey(null);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		Survey other = (Survey) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", date=" + date + ", person=" + person + ", surveyDetails=" + surveyDetails + "]";
	}

}
