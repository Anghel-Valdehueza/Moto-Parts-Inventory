/**
 * 
 */
package com.promineotech.motoparts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.motoparts.entity.AddInventoryRequest;
import com.promineotech.motoparts.entity.Inventory;
import com.promineotech.motoparts.service.MotoAddItemService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author angva
 *
 */
@RestController
@Slf4j
public class DefaultMotoPartsAddInventoryController implements MotoPartsAddInventoryController { 
  @Autowired
  private MotoAddItemService motoAddItemService;

  @Override
  public Inventory addInventory(AddInventoryRequest addInventoryRequest) {
    log.info("Add Inventory Request in controller layer :: {}", addInventoryRequest);

    return motoAddItemService.motoAddItem(addInventoryRequest);
  }

}
