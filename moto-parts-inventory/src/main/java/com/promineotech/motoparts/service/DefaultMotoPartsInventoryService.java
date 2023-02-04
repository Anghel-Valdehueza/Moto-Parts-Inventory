/**
 * 
 */
package com.promineotech.motoparts.service;


import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.motoparts.dao.MotoPartsInventoryDao;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author angva
 *
 */
@Service
@Slf4j
public class DefaultMotoPartsInventoryService implements MotoPartsInventoryService{

  @Autowired
  private MotoPartsInventoryDao motoPartsInventoryDao;
  
  @Override
  public List<MotoItem> fetchMotoParts(MotoItemType motoItemType, String itemName) {
    log.info("Received a Request in Moto Parts Inventory Sa service with moto item type {}, item name {}", motoItemType, itemName);
    List<MotoItem> motos = motoPartsInventoryDao.fetchMotoParts(motoItemType, itemName);
    Collections.sort(motos);
    return motos;
  }
  
}  
