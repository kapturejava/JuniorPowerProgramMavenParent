package be.kapture.tdd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 25/07/2018
 * Time: 20:51
 */

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;

    public Car() {
    }

    public Car(String name, String type) {

        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
