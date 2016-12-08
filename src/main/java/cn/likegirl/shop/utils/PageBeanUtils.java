package cn.likegirl.shop.utils;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.likegirl.shop.entity.Product;


@Service
@Scope("prototype")
public class PageBeanUtils {
	//当前页数
	private int pageIndex;
	
	//每页显示的数量
	private int pageProductCount;
	
	//总页数
	private int productCount;
	
	//显示商品的集合
	private List<Product> products;
	

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageProductCount() {
		return pageProductCount;
	}

	public void setPageProductCount(int pageProductCount) {
		this.pageProductCount = pageProductCount;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
