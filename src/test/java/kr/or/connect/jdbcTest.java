package kr.or.connect;


import java.util.List;
import java.util.Optional;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.dao.RoleDao;
import kr.or.connect.dto.Role;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class jdbcTest {
    @Autowired
    RoleDao roleDao;

    @Before
    public void init() {
        Role role = new Role();
        role.setRoleId(1);
        role.setDescription("Programmer");

        Role role2 = new Role();
        role2.setRoleId(2);
        role2.setDescription("Designer");

        roleDao.insert(role);
        roleDao.insert(role2);
    }

    @After
    public void teardown() {
        roleDao.deleteById(1);
        roleDao.deleteById(2);
        roleDao.deleteById(500);
    }

    @Test
    public void selectAllTest() {
        //given
        int count = 2;

        //when
        List<Role> roles = roleDao.selectAll();

        //then
        Assert.assertEquals(count, roles.stream().count());
    }

    @Test
    public void insertTest(){
        //given
        Role role = new Role();
        role.setRoleId(500);
        role.setDescription("CEO");

        //when
        int count = roleDao.insert(role);

        //then
        Assert.assertEquals(1,count);
    }

    @Test
    public void updateTest(){
        //given
        Role role = new Role();
        role.setRoleId(1);
        role.setDescription("Doctor");

        //when
        int count = roleDao.update(role);

        //then
        Assert.assertEquals(1,count);
    }

    @Test
    public void selectByIdTest(){
        //given
        Role role = new Role();
        role.setRoleId(1);
        role.setDescription("Programmer");

        //when
        Optional<Role> findRole = roleDao.selectById(1);

        //then
        Assert.assertEquals(role,findRole.get());
    }

    @Test
    public void deleteByIdTest(){
        //when
        int deleteById = roleDao.deleteById(1);
        System.out.println(deleteById);
    }
}
