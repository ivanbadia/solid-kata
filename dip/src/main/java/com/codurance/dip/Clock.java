package com.codurance.dip;

import java.time.MonthDay;

public class Clock {
    public MonthDay today(){
        return MonthDay.now();
    }
}