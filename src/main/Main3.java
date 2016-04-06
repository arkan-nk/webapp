package main;

import ru.javawebinar.webapp.model.ContactType;

/**
 * GKislin
 * 05.04.2016
 */
public class Main3 {
    public static void main(String[] args) {
        ContactType contactType = ContactType.HOME_PAGE;

        String name = contactType.name();
        ContactType contactType2 = ContactType.valueOf(name);
        Class<ContactType> enumClass = ContactType.class;

        Enum ct = Enum.valueOf(enumClass, name);
        System.out.println(ct == contactType2);
        System.out.printf("%d is %s\n", 12, "12");

        char ch2 = 'A';
        System.out.println(ch2);


        String s = "Hello WebApp";
        System.out.println(s.charAt(5));
        System.out.println(s.substring(2, 5));

        String s2 = (new String("Hello ")+ "WebApp").intern();
        System.out.println(s == s2);

        System.out.println();
        System.out.println(new Integer(12) == 12);
        System.out.println(Integer.valueOf(12) == 12);
        System.out.println(12 == Integer.valueOf(12));
        System.out.println(Integer.valueOf(300) == Integer.valueOf(300));

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
