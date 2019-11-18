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

    static DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        until();


//        LocalDateTime date_ = LocalDateTime.parse("2019-09-30 00:00:00", date_formatter);
//        System.out.println(date_.getDayOfWeek().getValue());
//
//
//        String str = LocalDate.now().plus(-1, ChronoUnit.MONTHS).format(DateTimeFormatter.ofPattern("yyyy-MM"));
//        System.out.println(str);
//
//        LocalDateTime date = LocalDateTime.parse("1970-01-01 08:00:00", date_formatter);
//        System.out.println(date.format(date_formatter));
//        System.out.println(date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        System.out.println(ZoneId.systemDefault());
    }

    public static void until(){
        LocalDate repairStartDate = LocalDate.parse("2019-09-01 00:00:00", date_formatter);
        LocalDate repairEndDate = LocalDate.parse("2019-10-02 00:00:00", date_formatter);
        long days = repairStartDate.until(repairEndDate, ChronoUnit.DAYS);
        System.out.println("days:"+days);

        long weeks = repairStartDate.until(repairEndDate, ChronoUnit.WEEKS);
        System.out.println("weeks:"+weeks);

        long months = repairStartDate.until(repairEndDate, ChronoUnit.MONTHS);
        System.out.println("months:"+months);
    }
}
