package be.kapture.entities;

import java.util.Set;

/**
 * Created by cromhjo on 11/05/2016.
 */
public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private Set<Survey> surveys;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public Set<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(Set<Survey> surveys) {
		this.surveys = surveys;
	}
}
