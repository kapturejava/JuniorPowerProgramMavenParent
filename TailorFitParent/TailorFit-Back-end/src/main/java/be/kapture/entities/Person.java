package be.kapture.entities;

import be.kapture.enums.Gender;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private int size;
    private Gender gender;


    public Person() {
        // TODO Auto-generated constructor stub
    }

    public Person(String string, String string2, int i, Gender male) {
        // TODO Auto-generated constructor stub
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

    public void setFirstName(String string) {
        // TODO Auto-generated method stub

    }

    public void setLastName(String string) {
        // TODO Auto-generated method stub

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setSize(int i) {
        // TODO Auto-generated method stub

    }

    public void setGender(Gender female) {
        // TODO Auto-generated method stub

    }

}
