package cn.likegirl.shop.dao;

import java.util.List;

import cn.likegirl.shop.entity.Product;



public interface ProductDao {
	
	/**
	 * 保存
	 * @param product
	 */
    public void sava(Product product);
	
    /**
     * 修改
     * @param product
     */
	public void update(Product product);
	
	/**
	 * 删除
	 * @param product
	 */
	public void delete(Product product);
	
	/**
	 * 删除
	 * @param pid
	 */
	public void delete(int pid);
	
	/**
	 * 查询
	 * @param pid  用户ID(pid)
	 * @return   返回商品实体
	 */
	public Product findById(int pid);
	
	/**
	 * 查询热门商品
	 * @return
	 */
	public List<Product> findHot();
	
	/**
	 * 查询最新商品
	 * @return
	 */
	public List<Product> findNew();
	
	/**
	 * 一级分类分页查询
	 * @param cid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> findPageByCid(int cid,int begin,int pageProductCount);
	
	/**
	 * 二级分类分页查询
	 * @param csid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> findPageByCsid(int csid,int begin,int pageProductCount);
	
	/**
	 * 查询一级商品的总数量
	 * @param cid
	 * @return
	 */
	public int findByCidCount(int cid);
	
	/**
	 * 查询二级商品的总数量
	 * @param csid
	 * @return
	 */
	public int findByCsidCount(int csid);

}
