package de.ehex.database.example.relationaldataaccess;

public class Customer {

    private long id;
    private String firstName, lastName, geburtsDatum;

    public Customer(long id, String firstName, String lastName, String geburtsDatum ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s',geburtsDatum=%s']",
                id, firstName, lastName, geburtsDatum);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGeburtsDatum() {
        return geburtsDatum;
    }
}
