/**
 * 
 */
package com.promineotech.motoparts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author angva
 *
 */
@SpringBootApplication
@EnableWebSecurity
public class MotoPartsInventory {
  public static void main(String[] args) {
    SpringApplication.run(MotoPartsInventory.class, args);
  }


}
