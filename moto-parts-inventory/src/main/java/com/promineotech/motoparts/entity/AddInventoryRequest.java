/**
 * 
 */
package com.promineotech.motoparts.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

/**
 * @author angva
 *
 */
@Data
public class AddInventoryRequest {

  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String itemCode;
  
  @Positive
  @Min(2)
  @Max(4)
  private int itemTypeID;
  
  @Positive
  @Min(2)
  @Max(4)
  private int quantity;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String dateAdded;
  
  @Positive
  @Min(2)
  @Max(4)
  private int addedBy;

}
