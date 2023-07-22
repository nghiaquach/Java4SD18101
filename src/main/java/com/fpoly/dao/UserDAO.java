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
	
	public List<User> findAll(){
		String jpql = "Select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}
}
