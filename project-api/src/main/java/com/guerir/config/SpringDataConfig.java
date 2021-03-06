package com.project.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration for Spring Data/JPA using annotations. This assumes the
 * datasource is configured as a jndi resource as in tomcat's server.xml with
 * name {@code jndiDBresource}
 *
 * @author Jay Paulynice (jay.paulynice@gmail.com)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.project.repository")
public class SpringDataConfig {
    @Bean
    EntityManagerFactory entityManagerFactory() {
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(false);

        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setJpaProperties(hibernateProperties());
        factory.setPackagesToScan("com.project.repository.entity");
        factory.setDataSource((DataSource) jndiDataSource().getObject());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    JndiObjectFactoryBean jndiDataSource() {
        final JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/jndiDBresource");
        bean.setResourceRef(true);

        return bean;
    }

    @Bean
    Properties hibernateProperties() {
        final Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");

        return props;
    }

    @Bean
    PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

    /**
     * @return persistence exception translator
     */
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
