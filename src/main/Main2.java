package main;

import ru.javawebinar.webapp.model.Link;
import ru.javawebinar.webapp.model.Organization;
import ru.javawebinar.webapp.model.OrganizationSection;
import ru.javawebinar.webapp.model.Section;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class Main2 {
    public static void main(String[] args) {
        int i;
        List<Integer> listInteger;

        double d = 1.2;
        i = (int) d;
        d = i;

        Link l1 = new Link("1","1");
        Link l2 = new Link(l1);
        l2.setName("2");
        l2.setUrl("2");
        System.out.println(l1);

        //Section os = new OrganizationSection(Arrays.asList(new Organization(), new Organization()));
    }
}
