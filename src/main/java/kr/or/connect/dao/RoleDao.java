package kr.or.connect.dao;

import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;

import kr.or.connect.dto.Role;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Role> selectAll(){
        return jdbc.query(RoleDaoSqls.SELECT_ALL, Collections.emptyMap(), rowMapper);
    }
}
