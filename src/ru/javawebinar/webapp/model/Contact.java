package ru.javawebinar.webapp.model;

import java.util.Objects;

/**
 * GKislin
 * 01.04.2016
 */
public class Contact {
    private final ContactType type;
    private String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + type + ',' + value + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return type == contact.type &&
                Objects.equals(value, contact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
