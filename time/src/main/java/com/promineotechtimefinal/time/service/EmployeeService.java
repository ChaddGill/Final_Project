package com.promineotechtimefinal.time.service;

import java.util.List;
import com.promineotechtimefinal.time.entity.Employee;

public interface EmployeeService {

  List<Employee> fetchEmployee(String name);

  void deleteEmployee(String name);

  Employee addEmployee(String name, Double minHours, Double vacationHours,
      boolean otEligible);

  Employee updateEmployee(String name, Employee updatedEmployee);

}