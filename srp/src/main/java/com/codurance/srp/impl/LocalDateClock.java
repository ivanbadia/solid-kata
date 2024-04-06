package com.codurance.srp.impl;

import com.codurance.srp.Clock;

import java.time.LocalDate;

public class LocalDateClock implements Clock {

    public LocalDate today() {
        return LocalDate.now();
    }

}
