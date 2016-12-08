package cn.likegirl.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.likegirl.shop.dao.ProductDao;
import cn.likegirl.shop.entity.Product;
import cn.likegirl.shop.service.ProductService;
import cn.likegirl.shop.utils.PageBeanUtils;

/**
 * 
 * @author CK_BOY
 * 
 * 
 */
@Service
@Transactional
@Scope("prototype")
public class ProductServiceImp implements ProductService {

	@Resource
	ProductDao productDaoImp;

	@Resource
	PageBeanUtils pageBeanUtils;

	@Override
	public List<Product> getProductHot() {
		return productDaoImp.findHot();
	}

	@Override
	public List<Product> getProductNew() {
		return productDaoImp.findNew();
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Product getProductByPid(int pid) {
		return productDaoImp.findById(pid);
	}

	@Override
	public PageBeanUtils ShowCPageProduct(int pageIndex, int cid,
			int pageProductCount) {
		int count = productDaoImp.findByCidCount(cid);
		pageBeanUtils.setPageIndex(pageIndex);
		pageBeanUtils.setPageProductCount(pageProductCount);
		pageBeanUtils.setProductCount(count % pageProductCount == 0 ? count
				/ pageProductCount : count / pageProductCount + 1);
		System.out.println(pageIndex * pageProductCount);
		System.out.println((pageIndex + 1)
				* pageProductCount);
		pageBeanUtils.setProducts(productDaoImp.findPageByCid(cid,
					pageIndex * pageProductCount, pageProductCount));		
		return pageBeanUtils;
	}
	
	@Override
	public PageBeanUtils ShowCsPageProduct(int pageIndex, int csid,
			int pageProductCount) {
		int count = productDaoImp.findByCsidCount(csid);
		pageBeanUtils.setPageIndex(pageIndex);
		pageBeanUtils.setPageProductCount(pageProductCount);
		pageBeanUtils.setProductCount(count % pageProductCount == 0 ? count
				/ pageProductCount : count / pageProductCount + 1);
		System.out.println(pageIndex * pageProductCount);
		System.out.println((pageIndex + 1)
				* pageProductCount);
		pageBeanUtils.setProducts(productDaoImp.findPageByCsid(csid,
					pageIndex * pageProductCount, pageProductCount));		
		return pageBeanUtils;
	}

}
