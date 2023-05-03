package com.promineotechtimefinal.time.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.promineotechtimefinal.time.entity.Employee;


public class FetchEmployeeTestSupport extends BaseTest{
  
  protected List<Employee> buildExpected() {

    List<Employee> list = new LinkedList<>();

    //@formatter:off
    list.add(Employee.builder()
    .name("Chadd Gillmore")
    .minHours((double) 80)
    .vacationHours(16.91)
    .otEligible(true)
    .build());
    
   list.add(Employee.builder()
       .name("Jeremy Fix")
       .minHours((double) 80)
       .vacationHours(162.12)
       .otEligible(true)
    .build());
    //@formatter:on
//   Collections.sort(list);
    return list;
  }

  
  protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
    //@formatter:off
    assertThat(error)
    .containsKey("message")
    .containsEntry("status code", status.value())
    .containsEntry("uri", "/time")
    .containsKey("timestamp")
    .containsEntry("reason", status.getReasonPhrase());
    //@formatter:on
  }
 

}