package cn.likegirl.shop.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.likegirl.shop.dao.CategoryDao;
import cn.likegirl.shop.entity.Category;

@Repository
@Transactional
public class CategoryDaoImp implements CategoryDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void sava(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String cid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public List<Category> findAll() {
		return em.createQuery("select c from Category c").getResultList();
	}

}
