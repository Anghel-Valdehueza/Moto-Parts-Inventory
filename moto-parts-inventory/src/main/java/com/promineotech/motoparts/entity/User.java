/**
 * 
 */
package com.promineotech.motoparts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

/**
 * @author angva
 *
 */
@Data
@Builder
public class User {
  private int id;
  private String lastName;
  private String firstName;
  private String middleName;
  private String username;
  private String password;
  
  @JsonIgnore
  public int getId() {
    return id;
  }
  
}
