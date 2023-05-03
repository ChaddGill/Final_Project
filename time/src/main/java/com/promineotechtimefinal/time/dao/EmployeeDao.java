package com.promineotechtimefinal.time.dao;

import java.util.List;
import com.promineotechtimefinal.time.entity.Employee;

public interface EmployeeDao {

  List<Employee> fetchEmployees(String name);

  void deleteEmployee(String name);

  Employee addEmployee(String name, Double minHours, Double vacationHours,
      boolean otEligible);

  Employee updateEmployee(String name, Employee updatedEmployee);
}
