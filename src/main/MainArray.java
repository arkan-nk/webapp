package main;

import ru.javawebinar.webapp.model.ContactType;

import java.util.Arrays;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArray {
    public static void main(String[] args) {
        ContactType[] contactTypes = new ContactType[]{ContactType.HOME_PAGE, ContactType.EMAILHOME, ContactType.CELLPHONE};
        ContactType[] contactTypes2 = new ContactType[5];
        System.out.println(contactTypes.length);
        System.out.println(contactTypes[0]);
//        System.out.println(contactTypes[3]);
        Object[] objects = (Object[]) contactTypes;
//        objects[2] = 12;
        System.out.println(Arrays.toString(contactTypes));
    }
}
