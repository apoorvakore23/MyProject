package com.ecom.homedecorbackend.config;

import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.ecom.homedecorbackend.dao.CategoryDAO;
import com.ecom.homedecorbackend.dao.CategoryDAOImpl;
import com.ecom.homedecorbackend.dao.ProductDAO;
import com.ecom.homedecorbackend.dao.ProductDAOImpl;
import com.ecom.homedecorbackend.dao.SupplierDAO;
import com.ecom.homedecorbackend.dao.SupplierDAOImpl;
import com.ecom.homedecorbackend.dao.UserDetailsDAO;
import com.ecom.homedecorbackend.dao.UserDetailsDAOImpl;
import com.ecom.homedecorbackend.model.Category;
import com.ecom.homedecorbackend.model.Product;
import com.ecom.homedecorbackend.model.Supplier;

import com.ecom.homedecorbackend.model.UserDetails;

@Configuration
@ComponentScan("com.ecom")
@EnableTransactionManagement
public class ApplicationContextConfiguration {

	@Bean(name = "h2DataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitDB");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		// properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(UserDetails.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDao")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "productDao")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "suppliertDao")
	public SupplierDAO getSuppliertDao(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "userDetailsDao")
	public UserDetailsDAO getUserDetailsDao(SessionFactory sessionFactory) {
		return new UserDetailsDAOImpl(sessionFactory);
	}

}
