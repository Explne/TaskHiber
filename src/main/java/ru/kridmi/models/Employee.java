package ru.kridmi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    public Employee() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @Column(name = "position_id")
    private int positionId;

//    @ManyToOne
//    @JoinColumn(name = "position_id", referencedColumnName = "id")
//    private Position position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

//    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }
}
