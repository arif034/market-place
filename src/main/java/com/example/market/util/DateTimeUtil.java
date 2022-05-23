package com.example.market.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private DateTimeUtil() {
    }

    private static final String IST_ZONE_ID = "Asia/Kolkata";

    public static String getCurrentServerTime() {
        LocalDateTime ldt = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.of(IST_ZONE_ID)).toLocalDateTime();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ldt.format(format1);
    }
}
