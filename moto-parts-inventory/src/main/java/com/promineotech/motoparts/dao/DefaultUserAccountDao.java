package com.promineotech.motoparts.dao;

import com.promineotech.motoparts.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserAccountDao implements UserAccountDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User addUserAccount(User user) {
        SqlParams sqlParams = generateInsertSql(user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);

        return user;
    }

    private SqlParams generateInsertSql(User user) {
        // @formatter:off
        String sql = ""
                + "INSERT INTO user_accounts ("
                + "id, last_name, first_name, middle_name, username, password"
                + ") VALUES ("
                + ":id, :last_name, :first_name, :middle_name, :username, :password"
                + ")";
        // @formatter:on

        SqlParams params = new SqlParams();

        params.sql = sql;
        params.source.addValue("id", user.getId());
        params.source.addValue("first_name", user.getFirstName());
        params.source.addValue("last_name", user.getLastName());
        params.source.addValue("middle_name", user.getMiddleName());
        params.source.addValue("username", user.getUsername());
        params.source.addValue("password", user.getPassword());
        return params;
    }

    class SqlParams {
        String sql;
        MapSqlParameterSource source = new MapSqlParameterSource();
    }
}
