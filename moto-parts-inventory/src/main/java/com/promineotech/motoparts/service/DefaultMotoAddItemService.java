/**
 *
 */
package com.promineotech.motoparts.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.motoparts.dao.MotoAddInventoryDao;
import com.promineotech.motoparts.entity.AddInventoryRequest;
import com.promineotech.motoparts.entity.Inventory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author angva
 *
 */
@Service
@Slf4j
public class DefaultMotoAddItemService implements MotoAddItemService {

    @Autowired
    private MotoAddInventoryDao motoAddInventoryDao;

    @Override
    @Transactional
    public Inventory motoAddItem(AddInventoryRequest addInventoryRequest) {
        log.info("Order request in order service layer :: {}", addInventoryRequest);

        return motoAddInventoryDao.addInventory(addInventoryRequest.getItemCode(), addInventoryRequest.getItemTypeID(),
                addInventoryRequest.getQuantity(), addInventoryRequest.getDateAdded(), addInventoryRequest.getAddedBy());

    }
}
