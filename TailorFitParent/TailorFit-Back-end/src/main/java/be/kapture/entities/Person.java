package be.kapture.entities;

import be.kapture.enums.Gender;
import be.kapture.util.InputUtil;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private int size;
    private Gender gender;

    protected Person() {

    }

    public Person(String firstName, String lastName, int size, Gender gender) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSize(size);
        setGender(gender);
    }

    public void setFirstName(String firstname) {
        this.firstName = InputUtil.isStringEmpty(firstname);

    }

    public void setLastName(String lastname) {
        this.lastName = InputUtil.isStringEmpty(lastname);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSize(int size) {
        this.size = InputUtil.isIntStricltyPositive(size);

    }

    public void setGender(Gender gender) {
        this.gender = (Gender) InputUtil.isNotNull(gender);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSize() {
        return size;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (gender != other.gender)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (size != other.size)
            return false;
        return true;
    }

}
