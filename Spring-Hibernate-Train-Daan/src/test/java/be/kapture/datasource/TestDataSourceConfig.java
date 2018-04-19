package be.kapture.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class TestDataSourceConfig {

    @Bean
    DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:mysql://localhost/integrationproject?useSSL=false",
                "root", "azerty16");
    }
}