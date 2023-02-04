/**
 * 
 */
package com.promineotech.motoparts.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.promineotech.motoparts.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.motoparts.entity.Inventory;

/**
 * @author angva
 *
 */
@Component
public class DefaultMotoAddInventoryDao implements MotoAddInventoryDao{

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  /**
   * 
   * @param itemCode
   * @param itemTypeId
   * @param quantity
   * @param dateAdded
   * @param addedBy
   * @return
   */
  private SqlParams generateInsertSql(String itemCode, int itemTypeId, int quantity, String dateAdded, int addedBy) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO inventory ("
        + "item_code, item_type_id, quantity, date_added, added_by"
        + ") VALUES ("
        + ":item_code, :item_type_id, :quantity, :date_added, :added_by"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("item_code", itemCode);
    params.source.addValue("item_type_id", itemTypeId);
    params.source.addValue("quantity", quantity);
    params.source.addValue("date_added", dateAdded);
    params.source.addValue("added_by", addedBy);
    
    return params;
  }

  @Override
  public Inventory addInventory(String itemCode, int itemTypeId, int quantity, String dateAdded, int addedBy) {
    SqlParams sqlParams = generateInsertSql(itemCode, itemTypeId, quantity, dateAdded, addedBy);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder, new String[] {"item_code"});

    return Inventory.builder()
            .itemCode(itemCode)
            .itemTypeId(itemTypeId)
            .quantity(quantity)
            .dateAdded(dateAdded)
            .addedBy(getUser(addedBy).get(0))
            .build();

  }

  private List<User> getUser(int addedBy) {
    String sql = ""
            + "SELECT * "
            + "FROM user_accounts "
            + "WHERE id = :addedBy";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("addedBy", addedBy);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
              @Override
              public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return User.builder()
                        .id(rs.getInt("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .build();
                // @formatter:on
              }
            }
    );
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  @Override
  public Optional<String> fetchItemCode(String itemCode) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<Integer> fetchItemTypeId(int itemTypeId) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public Optional<Integer> fetchQuantity(int quantity) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public Optional<String> fetchDateAdded(String dateAdded) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<User> fetchAddedBy(int addedBy) {
    return Optional.empty();
  }
  
  
}
