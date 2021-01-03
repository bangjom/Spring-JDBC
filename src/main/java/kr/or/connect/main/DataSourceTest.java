package kr.or.connect.main;

import config.ApplicationConfig;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataSourceTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DataSource ds = ac.getBean(DataSource.class);

        try (Connection conn = ds.getConnection()) {
            if (conn != null) {
                System.out.println("connection complete!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
