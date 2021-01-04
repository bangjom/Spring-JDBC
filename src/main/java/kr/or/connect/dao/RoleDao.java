package kr.or.connect.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;

import kr.or.connect.dto.Role;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
            .withTableName("role");
    }

    public List<Role> selectAll() {
        return jdbc.query(RoleDaoSqls.SELECT_ALL, Collections.emptyMap(), rowMapper);
    }

    public int insert(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return insert.execute(params);
    }

    public int update(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbc.update(RoleDaoSqls.UPDATE, params);
    }

    public int deleteById(Integer id) {
        Map<String, Integer> params = Collections.singletonMap("roleId", id);
        return jdbc.update(RoleDaoSqls.DELETE_BY_ROLE_ID, params);
    }

    public Optional<Role> selectById(Integer id) {
        Map<String, Integer> params = Collections.singletonMap("roleId", id);
        return Optional
            .ofNullable(jdbc.queryForObject(RoleDaoSqls.SELECT_BY_ROLE_ID, params, rowMapper));
    }
}
