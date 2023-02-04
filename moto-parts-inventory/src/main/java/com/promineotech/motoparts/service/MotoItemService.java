package com.promineotech.motoparts.service;


import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;

import java.math.BigDecimal;
import java.util.List;

public interface MotoItemService {
    List<MotoItem> getMotoItems();
    List<MotoItem> getItemsByItemType(MotoItemType motoItemType);
    MotoItem getItemByItemCode(String itemCode);
    void addItemType(MotoItemType motoItemType);

    void deleteItemType(int itemTypeId);
    MotoItem addItem(MotoItem motoItem);

    void deleteItem(String motoItemCode);

    MotoItem updateMarkup(BigDecimal markup, String itemCode);

    MotoItem updateUnitCost(BigDecimal unitCost, String itemCode);
}
