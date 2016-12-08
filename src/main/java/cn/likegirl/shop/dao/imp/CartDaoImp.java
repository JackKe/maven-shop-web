package cn.likegirl.shop.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.likegirl.shop.dao.CartDao;
import cn.likegirl.shop.entity.Cart;


@Repository
@Transactional
public class CartDaoImp implements CartDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void sava(Cart cart) {
		em.persist(cart);
	}

	@Override
	public void update(Cart cart) {
		em.merge(cart);
	}

	@Override
	public void delete(Cart cart) {
		em.remove(cart);
	}

	@Override
	public void delete(int cid) {
		em.remove(em.getReference(Cart.class, cid));
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public Cart findById(int cid) {
		return em.find(Cart.class, cid);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public List<Cart> findALL(String username) {
		String hql = "select c from Cart c where c.user.username = :username";
		List<Cart> result = em.createQuery(hql).setParameter("username", username).getResultList();
		em.close();
		return result;
	}

	@Override
	public int deleteAll(String username) {
		int result = 0;
		String hql = "delete from Cart where username = :username";
		Query query = em.createQuery(hql).setParameter("username", username);
		result = query.executeUpdate();
		return result;
	}

}
