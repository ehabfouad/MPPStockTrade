package com.mum.mpp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mum.mpp.model.AbstractEntity;


public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> getAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//List<T> list = session.createCriteria(entityClass).list();
		Query<T> query = session.createQuery("FROM "+entityClass.getSimpleName());
		List<T> list = query.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			T t = (T) iterator.next();
			if ( ((AbstractEntity<Serializable>)t).getStatus().equals(INACTIVE) ) {
				iterator.remove();
			}
		}
		session.close();
		return list;
	}
	
	@Override
	public T get(ID id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		T t = session.get(entityClass, id);
		session.close();
		return t;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T create(T t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		((AbstractEntity<Serializable>)t).setStatus(ACTIVE);
		session.save(t);
		transaction.commit();
		session.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T update(T t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(t);
		((AbstractEntity<Serializable>)t).setStatus(ACTIVE);
		transaction.commit();
		session.close();
		return t;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(ID id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		T t = session.get(entityClass, id);
		((AbstractEntity<Serializable>)t).setStatus(INACTIVE);
		transaction.commit();
		session.close();
		return true;
	}

}
