package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import DAO.GenericDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Hikari {

    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/orm_competicion");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");

        // Otras configuraciones opcionales
        hikariConfig.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.connection.datasource", dataSource);

    }


}

