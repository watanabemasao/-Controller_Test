package com.example.mappingtest.form;

public class PersonForm {
    private final String firstName;
    private final String lastName;

    public PersonForm(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
