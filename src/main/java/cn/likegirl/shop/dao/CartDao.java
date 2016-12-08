package cn.likegirl.shop.dao;

import java.util.List;

import cn.likegirl.shop.entity.Cart;


public interface CartDao {
	
	/**
	 * 保存
	 * @param cart
	 */
    public void sava(Cart cart);
	
    /**
     * 修改
     * @param cart
     */
	public void update(Cart cart);
	
	/**
	 * 删除
	 * @param cart
	 */
	public void delete(Cart cart);
	
	/**
	 * 删除
	 * @param cid
	 */
	public void delete(int cid);
	
	/**
	 * 清空购物车
	 * @param username
	 * @return
	 */
	public int deleteAll(String username);
	
	
	/**
	 * 查询
	 * @param cid  购物车ID(cid)
	 * @return   返回购物车实体
	 */
	public Cart findById(int cid);
	
	/**
	 * 根据用户名，查询所有的购物车商品 
	 * @param username
	 * @return
	 */
	public List<Cart> findALL(String username);
	
	

}
