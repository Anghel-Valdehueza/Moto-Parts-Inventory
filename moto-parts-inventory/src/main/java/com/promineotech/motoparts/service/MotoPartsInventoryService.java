/**
 * 
 */
package com.promineotech.motoparts.service;

import java.util.List;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;

/**
 * @author angva
 *
 */
public interface MotoPartsInventoryService {
  List<MotoItem> fetchMotoParts(MotoItemType motoItemType, String itemName);


}
