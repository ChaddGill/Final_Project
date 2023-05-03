package com.promineotechtimefinal.time.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotechtimefinal.time.entity.Employee;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEmployeeDao implements EmployeeDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Employee> fetchEmployees(String name) {
    log.debug("Employee DAO: name={}", name);
   //@formatter:off
   String sql = ""
       +"SELECT * "
       +"FROM employee "
       +"WHERE name = :name";
  
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
       //@formatter:off
       return Employee.builder()
           .name(rs.getString("name"))
           .minHours(rs.getDouble("minHours"))
           .vacationHours(rs.getDouble("vacationHours"))
           .otEligible(rs.getBoolean("otEligible"))
           .build();
       //@formatter:on
      }
    });

  }

  // Should be made inactive or hidden instead of delete for record keeping, delete for full CRUD
  @Override
  public void deleteEmployee(String name) {
    log.debug("Employee DAO: name={}", name);
    //@formatter:off
    String sql = ""
        +"DELETE FROM employee "
        +"WHERE name = :name";
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);

    jdbcTemplate.update(sql, params);

  }
//POST method
  @Override
  public Employee addEmployee(String name, Double minHours, Double vacationHours,
      boolean otEligible) {
    log.info("DAO: name ={}", name);
    //@formatter:off
    String sql = ""
        + "INSERT INTO employee ("
        + "name, minHours, vacationHours, otEligible"
        + ") VALUES ("
        + ":name, :minHours, :vacationHours, :otEligible"
        + ")";
   
     //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    params.put("minHours", minHours);
    params.put("vacationHours", vacationHours);
    params.put("otEligible", otEligible);
    
    jdbcTemplate.update(sql, params);
    
    return (
    //@formatter:off
      Employee.builder()
      .name(name)
      .minHours(minHours)
      .otEligible(otEligible)
      .vacationHours(vacationHours)
      .build());
  //@formatter:on
  }
//Put method
  @Override
  public Employee updateEmployee(String name, Employee updatedEmployee) {
    log.debug("Update Employee DAO: name= {}", name);
  //@formatter:off
    String sql = ""
        + "UPDATE employee SET "
        + "vacationHours = :vacationHours "
        + "WHERE name = :name;"
        + "";
   
     //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("vacationHours", updatedEmployee.getVacationHours());
    params.put("name", name); 
    
    if(jdbcTemplate.update(sql, params) ==0) {
      throw new NoSuchElementException("update failed");
    }
    return 
        //@formatter:off
          Employee.builder()
          .name(name)
          .vacationHours(updatedEmployee.getVacationHours())
          .build();
      //@formatter:on
  }

}