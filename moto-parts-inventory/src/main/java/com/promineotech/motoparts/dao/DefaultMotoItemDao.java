package com.promineotech.motoparts.dao;


import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class DefaultMotoItemDao implements MotoItemDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<MotoItem> getMotoItems() {
        log.info("Request to get all moto items in Dao");

        // @formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM items ";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        return jdbcTemplate.query(sql, params, new RowMapper<>() {
                    @Override
                    public MotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // @formatter:off
                        return getMotoItem(rs);
                        // @formatter:on
                    }
                }
        );
    }

    @Override
    public List<MotoItem> getItemsByItemType(MotoItemType motoItemType) {
        log.info("Request to get moto item by item type: {} received in Dao ", motoItemType);

        // @formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM items where item_type_id IN (select item_type_id from item_type where item_type_name= :motoItemType)";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        params.put("motoItemType", motoItemType.name());
        return jdbcTemplate.query(sql, params, new RowMapper<>() {
                    @Override
                    public MotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // @formatter:off
                        return getMotoItem(rs);
                        // @formatter:on
                    }
                }
        );
    }

    @Override
    public MotoItem getItemByItemCode(String itemCode) {
        log.info("Request to get moto item by item code: {} received in Dao ", itemCode);

        // @formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM items where item_code= :itemCode";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        params.put("itemCode", itemCode);
        return jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {
                    @Override
                    public MotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // @formatter:off
                        return getMotoItem(rs);
                        // @formatter:on
                    }
                }
        );
    }

    @Override
    public void addItemType(MotoItemType motoItemType) {
    SqlParams sqlParams = generateInsertSql(motoItemType);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);
    }

    @Override
    public void deleteItemType(int itemTypeId) {
        String sql = ""
                + "DELETE from item_type where item_type_id= :item_type_id";
        // @formatter:on

        SqlParams params = new SqlParams();

        params.sql = sql;
        params.source.addValue("item_type_id", itemTypeId);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(params.sql, params.source, keyHolder);
    }

    @Override
    public MotoItem addItem(MotoItem motoItem) {
        SqlParams sqlParams = generateInsertSqlForMotoItem(motoItem);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder, new String[] {"item_code"});

        return motoItem;

    }

    @Override
    public void deleteItem(String motoItemCode) {
        String sql = ""
                + "DELETE FROM items where item_code= :item_code";
        Map<String, Object> params = new HashMap<>();
        params.put("item_code", motoItemCode);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public MotoItem updateMarkup(BigDecimal markup, String itemCode) {
        String sql = ""
                + "Update items "
                + "SET markup= :markup where item_code= :item_code";
        // @formatter:on

        SqlParams params = new SqlParams();

        params.sql = sql;
        params.source.addValue("item_code", itemCode);
        params.source.addValue("markup", markup);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(params.sql, params.source, keyHolder);

        return getItemByItemCode(itemCode);

    }

    @Override
    public MotoItem updateUnitCost(BigDecimal unitCost, String itemCode) {
        String sql = ""
                + "Update items "
                + "SET unit_cost= :unit_cost where item_code= :item_code";
        // @formatter:on

        SqlParams params = new SqlParams();

        params.sql = sql;
        params.source.addValue("item_code", itemCode);
        params.source.addValue("unit_cost", unitCost);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(params.sql, params.source, keyHolder);

        return getItemByItemCode(itemCode);
    }

    private SqlParams generateInsertSql(MotoItemType motoItemType) {
        // @formatter:off
        String sql = ""
                + "INSERT INTO item_type ("
                + "item_type_name"
                + ") VALUES ("
                + ":item_type_name"
                + ")";
        // @formatter:on

        SqlParams params = new SqlParams();

        params.sql = sql;
        params.source.addValue("item_type_name", motoItemType.name());
        return params;
    }

    private SqlParams generateInsertSqlForMotoItem(MotoItem motoItem) {
        // @formatter:off
        String sql = ""
                + "INSERT INTO items ("
                + "item_code, item_type_id, item_name, unit_cost, markup, unit_price"
                + ") VALUES ("
                + ":item_code, :item_type_id, :item_name, :unit_cost, :markup, :unit_price"
                + ")";
        // @formatter:on

        SqlParams params = new SqlParams();

        params.sql = sql;
        params.source.addValue("item_code", motoItem.getItemCode());
        params.source.addValue("item_type_id", motoItem.getItemTypeId());
        params.source.addValue("item_name", motoItem.getItemName());
        params.source.addValue("unit_cost", motoItem.getUnitCost());
        params.source.addValue("markup", motoItem.getMarkup());
        params.source.addValue("unit_price", motoItem.getUnitPrice());
        return params;
    }

    class SqlParams {
        String sql;
        MapSqlParameterSource source = new MapSqlParameterSource();
    }

    private MotoItem getMotoItem(ResultSet rs) throws SQLException {
        return MotoItem.builder()
                .itemCode(rs.getString("item_code"))
                .itemTypeId(rs.getInt("item_type_id"))
                .itemName(rs.getString("item_name"))
                .unitCost(new BigDecimal(rs.getString("unit_cost")))
                .markup(new BigDecimal(rs.getString("markup")))
                .unitPrice(new BigDecimal(rs.getString("unit_price")))
                .build();
    }
}
