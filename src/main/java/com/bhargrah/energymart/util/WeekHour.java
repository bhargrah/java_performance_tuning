package com.bhargrah.energymart.util;

import java.time.ZonedDateTime;

public class WeekHour {
    public static int fromDateTime(ZonedDateTime dateTime) {
        int dayOfWeek = dateTime.getDayOfWeek().getValue() - 1 ;
        int hourOfDay = dateTime.getHour();

        return (dayOfWeek * 24) + hourOfDay;
    }
}
