package com.codurance.dip;

import java.time.MonthDay;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findEmployeesBornOn(MonthDay monthDay);
}
