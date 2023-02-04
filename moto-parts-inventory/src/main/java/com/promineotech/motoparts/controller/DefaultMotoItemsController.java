package com.promineotech.motoparts.controller;

import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import com.promineotech.motoparts.service.MotoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class DefaultMotoItemsController implements  MotoItemsController{

    @Autowired
    private MotoItemService motoItemService;
    @Override
    public List<MotoItem> getItems() {
       return motoItemService.getMotoItems();

    }

    @Override
    public List<MotoItem> getItemsByItemType(MotoItemType motoItemType) {
        return motoItemService.getItemsByItemType(motoItemType);
    }

    @Override
    public void addItemType(MotoItemType motoItemType) {
        motoItemService.addItemType(motoItemType);
    }

    @Override
    public void deleteItemType(int itemTypeId) {
        motoItemService.deleteItemType(itemTypeId);
    }

    @Override
    public MotoItem getItemByItemCode(String itemCode) {
        return motoItemService.getItemByItemCode(itemCode);
    }

    @Override
    public MotoItem addItem(MotoItem motoItem) {
        return motoItemService.addItem(motoItem);
    }

    @Override
    public void deleteItem(String motoItemCode) {
        motoItemService.deleteItem(motoItemCode);
    }

    @Override
    public MotoItem updateUnitCost(BigDecimal unitCost, String itemCode) {
        return motoItemService.updateUnitCost(unitCost, itemCode);
    }

    @Override
    public MotoItem updateMarkup(BigDecimal markup, String itemCode) {
        return motoItemService.updateMarkup(markup, itemCode);
    }
}
