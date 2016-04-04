package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class Contact {
    public final ContactType getContactType(){
        return type;
    }
    public Link getValue(){
        return value;
    }
    public void setValue(Link l){
        value=l;
    }
    public Contact(final ContactType t, Link v){
        type=t;
        value=v;
    }
    private final ContactType type;
    private Link value;
}
