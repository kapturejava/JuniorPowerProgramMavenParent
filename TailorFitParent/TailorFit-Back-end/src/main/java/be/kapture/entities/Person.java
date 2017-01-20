package be.kapture.entities;

import be.kapture.enums.Gender;
import be.kapture.util.HelperClass;

public class Person {
	
	private String firstname;
	private String lastname;
	private int size;
	private Gender gender;
	

	public Person(String firstname, String lastname, int size, Gender gender) throws IllegalArgumentException{
		setFirstName(firstname);
		setLastName(lastname);
		setSize(size);
		setGender(gender);
	}

	public Person() {
		this.firstname = "default";
		this.lastname = "default";
		this.size = 150;
		this.gender = gender.MALE;
	}

	public void setFirstName(String firstname) {
		this.firstname = HelperClass.isStringEmpty(firstname);
		
	}

	public void setLastName(String lastname) {
		this.lastname = HelperClass.isStringEmpty(lastname);
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSize(int size) {
		this.size = HelperClass.isIntStricltyPositive(size);
		
		
	}

	public void setGender(Gender gender) {
		this.gender = HelperClass.isEnumNotEmpty(gender);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + size;
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
		Person other = (Person) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender != other.gender)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	

}
