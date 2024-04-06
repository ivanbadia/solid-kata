package com.codurance.srp;

import java.time.LocalDate;

public class LocalDateClock implements Clock {

    public LocalDate today() {
        return LocalDate.now();
    }

}
