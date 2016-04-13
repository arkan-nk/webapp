package main;

import ru.javawebinar.webapp.model.Link;

/**
 * User: gkislin
 * Date: 18.06.2014
 */
public class Main {
    /**
     * First java program
     *
     * @param args : program arguments
     */
    public static void main(String[] args) {
        Link link = new Link("name", "url");
        link.setName("name2");
        link.setUrl("ulr2");
        System.out.println(link.toString());
        System.out.println(link.getName());

    }
}