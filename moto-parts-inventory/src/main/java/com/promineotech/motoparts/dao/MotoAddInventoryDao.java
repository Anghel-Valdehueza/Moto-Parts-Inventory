/**
 *
 */
package com.promineotech.motoparts.dao;

import java.util.Optional;
import com.promineotech.motoparts.entity.Inventory;
import com.promineotech.motoparts.entity.User;

/**
 * @author angva
 *
 */
public interface MotoAddInventoryDao {

  Optional<String> fetchItemCode(String itemCode);
  Optional<Integer> fetchItemTypeId(int itemTypeId);
  Optional<Integer> fetchQuantity(int quantity);
  Optional<String> fetchDateAdded(String dateAdded);

  Optional<User> fetchAddedBy(int addedBy);
  Inventory addInventory(String itemCode, int itemTypeId, int quantity, String dateAdded, int addedBy);

}
