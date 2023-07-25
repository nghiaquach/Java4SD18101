package com.fpoly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.entity.User;
import com.utils.JPAUtils;

public class UserDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	
	public User findById(String id) {
		return em.find(User.class, id);
	}
	
	public User create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
		return user;
	}
	
	public User update(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
		return user;
	}
	

	public User remove(String id) {
		
		User user = findById(id);
		
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
		return user;
	}
	
	public List<User> findAll(){
		String jpql = "Select o from User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}
}
