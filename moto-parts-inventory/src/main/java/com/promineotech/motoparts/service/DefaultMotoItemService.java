package com.promineotech.motoparts.service;

import com.promineotech.motoparts.dao.MotoItemDao;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DefaultMotoItemService implements MotoItemService {

    @Autowired
    private MotoItemDao motoItemDao;
    @Override
    public List<MotoItem> getMotoItems() {
        return motoItemDao.getMotoItems();
    }

    @Override
    public List<MotoItem> getItemsByItemType(MotoItemType motoItemType) {
        return motoItemDao.getItemsByItemType(motoItemType);
    }

    @Override
    public MotoItem getItemByItemCode(String itemCode) {
        return motoItemDao.getItemByItemCode(itemCode);
    }

    @Override
    public void addItemType(MotoItemType motoItemType) {
        motoItemDao.addItemType(motoItemType);
    }

    @Override
    public void deleteItemType(int itemTypeId) {
        motoItemDao.deleteItemType(itemTypeId);
    }

    @Override
    public MotoItem addItem(MotoItem motoItem) {
        return motoItemDao.addItem(motoItem);
    }

    @Override
    public void deleteItem(String motoItemCode) {
        motoItemDao.deleteItem(motoItemCode);
    }

    @Override
    public MotoItem updateMarkup(BigDecimal markup, String itemCode) {
        return motoItemDao.updateMarkup(markup, itemCode);
    }

    @Override
    public MotoItem updateUnitCost(BigDecimal unitCost, String itemCode) {
        return motoItemDao.updateUnitCost(unitCost, itemCode);
    }


}
