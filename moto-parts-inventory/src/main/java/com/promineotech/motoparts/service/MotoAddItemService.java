/**
 * 
 */
package com.promineotech.motoparts.service;

import com.promineotech.motoparts.entity.AddInventoryRequest;
import com.promineotech.motoparts.entity.Inventory;

/**
 * @author angva
 *
 */
public interface MotoAddItemService {

Inventory motoAddItem(AddInventoryRequest addInventoryRequest);  
  
}
