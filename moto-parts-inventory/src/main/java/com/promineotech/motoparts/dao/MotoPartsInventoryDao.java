/**
 * 
 */
package com.promineotech.motoparts.dao;

import java.util.List;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;

/**
 * @author angva
 *
 */
public interface MotoPartsInventoryDao {

  /**
   * @param motoItemType
   * @param itemName
   * @return
   */
  List<MotoItem> fetchMotoParts(MotoItemType motoItemType, String itemName);
  
}
