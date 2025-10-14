package com.example.mymodulith.common.util;

import org.springframework.stereotype.Component;

@Component
public class TimeUtil {

    public static long getCurrentEpochTime() {
        return System.currentTimeMillis();
    }
}
