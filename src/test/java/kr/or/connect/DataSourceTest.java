package kr.or.connect;

import java.sql.Connection;
import javax.sql.DataSource;

import kr.or.connect.config.ApplicationConfig;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void connectTest() throws Exception {
        //when
        Connection conn = dataSource.getConnection();

        //then
        Assert.assertNotNull(conn);
    }
}
