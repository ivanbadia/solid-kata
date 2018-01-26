package com.codurance.dip;

import java.time.LocalDate;
import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public void sendGreetings() {
        LocalDate today = clock.today();
        employeeRepository.findEmployeesBornOn(MonthDay.of(today.getMonth(), today.getDayOfMonth()))
                .forEach(employee -> new EmailSender().send(emailFor(employee)));
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}