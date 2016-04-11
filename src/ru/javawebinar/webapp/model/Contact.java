package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class Contact {
    @Override
    public String toString() {
        return "Contact{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (type != contact.type) return false;
        return value.equals(contact.value);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    public final ContactType getContactType() {
        return type;
    }

    public Link getValue() {
        return value;
    }

    public void setValue(Link l) {
        value = l;
    }

    public Contact(final ContactType t, Link v) {
        type = t;
        value = v;
    }

    private final ContactType type;
    private Link value;
}
