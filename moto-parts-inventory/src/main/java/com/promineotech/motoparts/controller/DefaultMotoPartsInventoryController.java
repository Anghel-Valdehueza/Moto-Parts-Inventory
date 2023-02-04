/**
 * 
 */
package com.promineotech.motoparts.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import com.promineotech.motoparts.service.MotoPartsInventoryService;
import lombok.extern.slf4j.Slf4j;


/**
 * @author angva
 *
 */
@RestController
@Slf4j
public class DefaultMotoPartsInventoryController implements MotoPartsInventoryController {
  
  @Autowired
  private MotoPartsInventoryService motoPartsInventoryService;

  @Override
  public List<MotoItem> fetchMotoParts(MotoItemType motoItemType, String itemName) {
    log.debug("DAO: item type name={}, item name={}", motoItemType, itemName);  
    return motoPartsInventoryService.fetchMotoParts(motoItemType, itemName);
  }
  

}


