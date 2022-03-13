package com.ecommerce.ecommerce.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef =  "creditEntityManagerFactory", basePackages = {
        "com.ecommerce.ecommerce.credit.repository"
}, transactionManagerRef = "creditTransactionManager")
public class CreditDbConfig {
    @Bean(name = "creditDataSource")
    //enter prefix as the name you used in application.properties file to indicate this database
    @ConfigurationProperties(prefix = "spring.credit.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "creditEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("creditDataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("com.ecommerce.ecommerce.credit.entity").persistenceUnit("credit").build();
    }
    @Bean(name = "creditTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("creditEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
