package kr.or.connect;

import java.util.List;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.dao.RoleDao;
import kr.or.connect.dto.Role;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class SelectAllTest {
    @Autowired
    RoleDao roleDao;

    @Test
    public void selectAllTest() throws Exception {
        //given
        int count = 2;

        //when
        List<Role> roles = roleDao.selectAll();

        //then
        Assert.assertEquals(count, roles.stream().count());
    }

}
