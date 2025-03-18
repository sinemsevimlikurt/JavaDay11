package org.example.mobile;

import java.util.Objects;

public class Contact {
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Static method to create a Contact instance
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getName(), contact.getName()) && Objects.equals(getPhoneNumber(), contact.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber());
    }
}

