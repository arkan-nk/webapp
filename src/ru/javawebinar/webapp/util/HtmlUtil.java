package ru.javawebinar.webapp.util;

import ru.javawebinar.webapp.model.Organization;

/**
 * GKislin
 * 29.04.2016
 */
public class HtmlUtil {
    public static String formatDates(Organization.Position position) {
        return DateUtil.format(position.getStartDate()) + " - " + DateUtil.format(position.getEndDate());
    }

}
