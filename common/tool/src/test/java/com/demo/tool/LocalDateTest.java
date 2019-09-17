package com.demo.tool;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019-09-17
 */
public class LocalDateTest {

    public static void main(String[] args) {
        String str = LocalDate.now().plus(-1, ChronoUnit.MONTHS).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println(str);

        LocalDateTime date = LocalDateTime.parse("1970-01-01 08:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(ZoneId.systemDefault());
    }
}
