package com.restapiexam.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restapiexam.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
	private EntityManager entityManager;

	@Autowired
	public UserDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from user", User.class);
		List<User> info = query.getResultList();
		return info;
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete Teams where id=:teamId");
		query.setParameter("teamId", id);
		query.executeUpdate();

	}

	@Override
	public List<User> getUserByName(String name) {
		Session currentSession = entityManager.unwrap(Session.class);
		 List<User> info = (List<User>) currentSession.get(User.class, name);
		return info;
	}

	@Override
	public User authenticateUser(User user) {
		List<User> u = new ArrayList<User>();

		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("select * from user where username=? and password=?");
		q.setParameter("name", user.getUname());
		q.setParameter("pass", user.getPword());
		q.executeUpdate();
		return null;
	}

	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(user);

	}

}
