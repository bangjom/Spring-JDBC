package kr.or.connect.main;

import java.util.List;
import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.dao.RoleDao;
import kr.or.connect.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SelectAllTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = ac.getBean(RoleDao.class);

        List<Role> roles = roleDao.selectAll();

        roles.stream()
            .forEach(System.out::println);

    }
}
