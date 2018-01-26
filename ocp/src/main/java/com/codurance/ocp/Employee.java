package com.codurance.ocp;

public class Employee {

    private int salary;
    private int bonus;
    private EmployeeType type;

    Employee(int salary, int bonus, EmployeeType type) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
    }

    public int payAmount() {
        switch (this.type) {
            case ENGINEER:
                return salary;
            case MANAGER:
                return salary + bonus;
            default:
                return 0;
        }
    }

}