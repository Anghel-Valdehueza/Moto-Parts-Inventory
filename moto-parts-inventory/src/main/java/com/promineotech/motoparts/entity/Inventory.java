/**
 * 
 */
package com.promineotech.motoparts.entity;


import lombok.Builder;
import lombok.Data;

/**
 * @author angva
 *
 */
@Data
@Builder
public class Inventory {
  private String itemCode;
  private int itemTypeId;
  private int quantity;
  private String dateAdded;
  private User addedBy;
}
