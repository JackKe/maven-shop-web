package cn.likegirl.shop.service;

import java.util.List;

import cn.likegirl.shop.entity.Product;
import cn.likegirl.shop.utils.PageBeanUtils;

public interface ProductService {

	/**
	 * 获得热门商品，取前10
	 * @return
	 */
	public List<Product> getProductHot();
	
	/**
	 * 获得最新商品，取前10
	 * @return
	 */
	public List<Product> getProductNew();
	
	/**
	 * 获得商品的详细信息
	 * @param pid
	 * @return
	 */
	public Product getProductByPid(int pid);
	
	/**
	 * 一级分类分页查询商品
	 * @param pageIndex
	 * @return
	 */
	public PageBeanUtils ShowCPageProduct(int pageIndex,int cid,int pageProductCount);
	
	/**
	 * 二级分类分页查询商品
	 * @param pageIndex
	 * @return
	 */
	public PageBeanUtils ShowCsPageProduct(int pageIndex,int cid,int pageProductCount);

}