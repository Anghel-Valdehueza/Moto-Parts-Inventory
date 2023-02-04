/**
 * 
 */
package com.promineotech.motoparts.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultMotoPartsInventoryDao implements MotoPartsInventoryDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<MotoItem> fetchMotoParts(MotoItemType motoItemType, String itemName) {
    log.debug("DAO: motoItemType={}, itemName={}", motoItemType, itemName);
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM items "
        + "WHERE item_code = :item_type_name AND item_name = :item_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("item_type_name", motoItemType.toString());
    params.put("item_name", itemName);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public MotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off  
        return MotoItem.builder()
                  .itemCode(rs.getString("item_code"))
                  .itemTypeId(rs.getInt("item_type_id"))
                  .itemName(rs.getString("item_name"))
                  .unitCost(new BigDecimal(rs.getString("unit_cost")))
                  .markup(new BigDecimal(rs.getString("markup")))
                  .unitPrice(new BigDecimal(rs.getString("unit_price")))
                  .build();
        // @formatter:on
      }
    }
    );
  }
  
}
