/**
 * 
 */
package com.promineotech.motoparts.entity;

import java.math.BigDecimal;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author angva
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotoItem implements Comparable<MotoItem> {
  private String itemCode;
  private int itemTypeId;
  private String itemName;
  private BigDecimal unitCost;
  private BigDecimal markup;
  private BigDecimal unitPrice;

  @Override
  public int compareTo(MotoItem that) {
    // @formatter:off
    return Comparator.comparing(MotoItem::getItemTypeId).thenComparing(MotoItem::getItemName)
            .thenComparing(MotoItem::getUnitCost)
            .compare(this, that);
    // @formatter:on
  }  

}
