package com.ecommerce.ecommerce.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef =  "entityManagerFactory", basePackages = {
        "com.ecommerce.ecommerce.product.productrepository",
        "com.ecommerce.ecommerce.order.orderrepository"
}, transactionManagerRef = "transactionManager")
public class EcommerceDbConfig {
    //this database acts as a primary database
    @Primary
    @Bean(name = "dataSource")
    //enter prefix as the name you used in application.properties file to indicate this database
    @ConfigurationProperties(prefix = "spring.ecommerce.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("dataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("com.ecommerce.ecommerce.product.entity","com.ecommerce.ecommerce.order.entity").persistenceUnit("User").build();
    }
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
