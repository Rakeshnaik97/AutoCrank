package com.raki.AutoCrankBackEnd.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.raki.AutoCrankBackEnd.Dao.AuthenticationDao;
import com.raki.AutoCrankBackEnd.Dao.BillingDao;
import com.raki.AutoCrankBackEnd.Dao.CartDao;
import com.raki.AutoCrankBackEnd.Dao.CartItemsDao;
import com.raki.AutoCrankBackEnd.Dao.CategoryDao;
import com.raki.AutoCrankBackEnd.Dao.OrderDao;
import com.raki.AutoCrankBackEnd.Dao.OrderItemsDao;
import com.raki.AutoCrankBackEnd.Dao.ProductDao;
import com.raki.AutoCrankBackEnd.Dao.ShippingDao;
import com.raki.AutoCrankBackEnd.Dao.SupplierDao;
import com.raki.AutoCrankBackEnd.Dao.UserDao;
import com.raki.AutoCrankBackEnd.DaoImpl.AuthenticationDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.BillingDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.CartDaoimpl;
import com.raki.AutoCrankBackEnd.DaoImpl.CartItemsDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.CategoryDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.OrderDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.OrderItemsDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.ProductDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.ShippingDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.SupplierDaoImpl;
import com.raki.AutoCrankBackEnd.DaoImpl.UserDaoImpl;
import com.raki.AutoCrankBackEnd.Model.Authentication;
import com.raki.AutoCrankBackEnd.Model.Billing;
import com.raki.AutoCrankBackEnd.Model.Cart;
import com.raki.AutoCrankBackEnd.Model.CartItems;
import com.raki.AutoCrankBackEnd.Model.Category;
import com.raki.AutoCrankBackEnd.Model.Order;
import com.raki.AutoCrankBackEnd.Model.OrderItems;
import com.raki.AutoCrankBackEnd.Model.Product;
import com.raki.AutoCrankBackEnd.Model.Shipping;
import com.raki.AutoCrankBackEnd.Model.Supplier;
import com.raki.AutoCrankBackEnd.Model.User;

@Configuration // to let know it is configuration
@ComponentScan("com.raki.*") // group id When i refresh compiler should search entire in com.niit.*
@EnableTransactionManagement // when ever i call save or delete to let know where is that object at
								// repsoritry in daoimpl it both should have same name
public class ApplicationContext {
	@Bean("dataSource") // Connection of h2 database
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/AutoCrank");
		dataSource.setUsername("raki");
		dataSource.setPassword("raki");
		return dataSource;
	}

	private Properties getHibernateProperties() { // to connect many databases with same code
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10"); // maxium 10 seize can be given to pool
		properties.put("hibernate.hbm2ddl.auto", "update"); // automatic creation of ddl (all tables) in the database
		properties.put("hibernate.show_sql", "true"); // Statements in databases(sql,insertion,all statements) should
														// show
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // Since usin with h2Dialect
		return properties;
	}

	@Autowired
	@Bean("sessionFactory") // model class as to be referred since that class table ll be created
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager") // save or update method
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired // Accessing @repsoritary and calling all methods inside it
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
		return new AuthenticationDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) {
		return new CartDaoimpl(sessionFactory);
	}

	@Autowired
	@Bean("cartItemsDao")
	public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
		return new CartItemsDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("orderDao")
	public OrderDao getOrderDao(SessionFactory sessionFactory) {
		return new OrderDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
		return new OrderItemsDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory) {
		return new ShippingDaoImpl(sessionFactory);
	}
}
