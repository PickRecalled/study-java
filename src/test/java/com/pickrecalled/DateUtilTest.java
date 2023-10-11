package com.pickrecalled;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtilTest {

    @org.junit.Test
    public void test01() {
        // 创建一个表示 UTC 时间的 LocalDateTime 对象
        LocalDateTime utcTime = LocalDateTime.of(2023, 6, 6, 14, 45, 0);
        // 将 UTC 时间转换为本地日期和时间
        ZonedDateTime localTime = ZonedDateTime.of(utcTime, ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault());
        // 输出本地日期和时间
        System.out.println(localTime);
    }
}
