package com.promineotechtimefinal.time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotechtimefinal.ComponentScanMarker;

/**
 * 
 * @author Gill7
 *
 */

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class TimeCreator {

  public static void main(String[] args) {
    SpringApplication.run(TimeCreator.class, args);
  }
}