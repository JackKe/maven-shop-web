package cn.likegirl.shop.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.likegirl.shop.dao.UserDao;
import cn.likegirl.shop.entity.User;


@Repository
@Transactional
public class UserDaoImp implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void sava(User user) {
		em.persist(user);
		
	}

	@Override
	public void update(User user) {
		em.merge(user);
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		em.remove(user);
		
	}
	
	@Override
	public void delete(String username){
		em.remove(em.getReference(User.class, username));
	}

	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public User findById(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}


	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public List<User> findByCode(String code) {
		List<User> users = null;
		Query query = em.createQuery("select u from User u where u.code= ?");
		query.setParameter(1, code);
		users = (List<User>) query.getResultList();
		return users;
	}

}
