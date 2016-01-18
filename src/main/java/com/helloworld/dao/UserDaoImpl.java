package com.helloworld.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.helloworld.model.User;
@Repository( "userDao" )
public class UserDaoImpl implements UserDao<User, Long> {

	private Session currentSession;
	private Transaction currentTransaction;
	
	public UserDaoImpl () {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction () {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public User findById(Long id) {
		User user = (User) getCurrentSession().get(User.class,  id);
		return user;
	}

	public List<User> findAll() {
		List<User> users = (List<User>) getCurrentSession().createCriteria(User.class).addOrder(Order.desc("registerDate")).list();
		
		return users;
	}

	public void save(User entity) {
		getCurrentSession().save(entity);
	}

	public void update(User entity) {
		getCurrentSession().update(entity);
	}

	public void delete(User entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteAll() {
		List<User> entityList = findAll();
		for (User entity : entityList) {
			delete(entity);
		}
	}
	
}
