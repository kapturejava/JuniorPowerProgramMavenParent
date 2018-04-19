package be.kapture.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class TestDAOConfig {
    @Bean
    PersonDAO personDAO() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring4.xml");
        PersonDAO personDAO = context.getBean(PersonDAO.class);
        return personDAO;
    }

}
