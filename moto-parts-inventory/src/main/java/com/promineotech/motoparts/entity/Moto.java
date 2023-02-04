/**
 * 
 */
package com.promineotech.motoparts.entity;

import java.math.BigDecimal;
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
public class Moto {
    private int itemCode;
    private int itemTypeId;
    private String itemName;
    private BigDecimal unitCost;
    private BigDecimal markup;
    private BigDecimal unitPrice;
    
    
    
}


