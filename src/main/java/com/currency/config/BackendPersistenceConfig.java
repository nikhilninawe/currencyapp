package com.currency.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.currency" })
@PropertySource({ "classpath:persistence-mysql.properties" })
@EnableJpaRepositories(basePackages = {"com.currency.jpa"})
public class BackendPersistenceConfig {
	
	@Autowired
	Environment env;
	
	public BackendPersistenceConfig() {
		super();
	}
	
	// beans
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSource());
		lcemfb.setPackagesToScan(new String[] { "com.currency" });
		
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		lcemfb.setJpaVendorAdapter(va);
		
		Properties ps = new Properties();
		ps.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		ps.put("hibernate.show_sql", env.getProperty("hibernate.show_sql", Boolean.class));
		ps.put("jpa.generateDdl", env.getProperty("jpa.generateDdl", Boolean.class));
		lcemfb.setJpaProperties(ps);
		
		lcemfb.afterPropertiesSet();
		
		return lcemfb;
	}
	
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(this.entityManagerFactory().getObject());
		return tm;		
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}	
	
	//
	final Properties additionlProperties() {
		return new Properties() {
			private static final long serialVersionUID = -2370689121001609959L;
			{
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
			}
		};
	}	
}
