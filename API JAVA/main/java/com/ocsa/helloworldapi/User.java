package com.ocsa.helloworldapi;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String university;

    public User(int id, String firstName, String lastName, String university) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
