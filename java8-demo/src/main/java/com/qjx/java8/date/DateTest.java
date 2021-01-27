package com.qjx.java8.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

/**
 * Created by qincasin on 2021/1/26.
 */
public class DateTest {
    @Test
    public void testLocalDate(){
        LocalDate localDate = LocalDate.of(2018, 1, 1);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(LocalDate.now());
        System.out.println(localDate.get(ChronoField.YEAR));
    }
    @Test
    public void testLocalDateTime(){
        LocalDateTime dateTime = LocalDateTime.of(2018, 10, 10, 12, 12, 22);
        LocalDate localDate = dateTime.toLocalDate();

        Duration between = Duration.between(LocalTime.of(10, 10, 0), LocalTime.of(10, 10, 10));
        System.out.println(between+" "+between.getSeconds());

        Period between2 = Period.between(localDate.of(2010, 10, 1), localDate.of(2010, 10, 10));
        System.out.println(between2+" "+between2.getDays());
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(10);
        System.out.println(localDateTime);

//        TemporalAdjuster
        LocalDateTime with = dateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

    }

}
