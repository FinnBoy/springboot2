package net.awaken.springboot.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Finn Zhao
 */
@Configuration
public class PrimaryDataSourceConfiguration implements PrimaryBeanName {

    @Primary
    @Bean(DATA_SOURCE_PROPERTIES)
    @ConfigurationProperties(prefix = "app.sql-database.primary.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(DATA_SOURCE)
    @ConfigurationProperties(prefix = "app.sql-database.primary.datasource.configuration")
    public HikariDataSource dataSource(@Qualifier(DATA_SOURCE_PROPERTIES) DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
