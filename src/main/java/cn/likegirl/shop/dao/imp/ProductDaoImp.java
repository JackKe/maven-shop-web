package cn.likegirl.shop.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.likegirl.shop.dao.ProductDao;
import cn.likegirl.shop.entity.Product;

@Repository
@Transactional
public class ProductDaoImp implements ProductDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void sava(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findById(int pid) {
		return em.find(Product.class, pid);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public List<Product> findHot() {
		Query result = em.createQuery("select p from Product p where p.is_hot = 1 order by p.pdate desc").setFirstResult(0).setMaxResults(10);
		List<Product> list = (List<Product>)result.getResultList();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public List<Product> findNew() {
		Query result = em.createQuery("select p from Product p order by p.pdate desc").setFirstResult(0).setMaxResults(10);
		List<Product> list = (List<Product>)result.getResultList();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public List<Product> findPageByCid(int cid, int begin, int pageProductCount) {
		String hql="select p from Product p join p.categorysecond cs join cs.category c where c.cid = :cid";	
		List<Product> list = em.createQuery(hql).setParameter("cid", cid).setFirstResult(begin).setMaxResults(pageProductCount).getResultList();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public int findByCidCount(int cid) {
		String hql = "select count(p) from Product p where p.categorysecond.category.cid = :cid";	
		return ((Long) em.createQuery(hql).setParameter("cid", cid).getResultList().get(0)).intValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public List<Product> findPageByCsid(int csid, int begin, int pageProductCount) {
		String hql = "select p from Product p join p.categorysecond cs where cs.csid = :csid";
		List<Product> list = em.createQuery(hql).setParameter("csid", csid).setFirstResult(begin).setMaxResults(pageProductCount).getResultList();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
	public int findByCsidCount(int csid) {
		String hql = "select count(p) from Product p where p.categorysecond.csid = :csid";	
		return ((Long) em.createQuery(hql).setParameter("csid", csid).getResultList().get(0)).intValue();
	}

}
