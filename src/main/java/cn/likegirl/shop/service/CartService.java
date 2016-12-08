package cn.likegirl.shop.service;

import java.util.List;

import cn.likegirl.shop.entity.Cart;


public interface CartService {

	/**
	 * 商品添加购物车
	 * @param username
	 * @param pid
	 * @param count
	 * @return
	 */
	public boolean AddCart(String username,int pid,int count);
	
	/**
	 * 删除购物车商品
	 * @param cid
	 * @return
	 */
	public boolean delCart(int cid);
	
	/**
	 * 根据用户名，查询购物车内所有商品
	 * @param username
	 * @return
	 */
	public List<Cart> findCartsByUsername(String username);
	
	/**
	 * 清空购物车
	 * 返回 true 表示清空成功， false 表示清空失败。
	 * @param username
	 * @return
	 */
	public boolean delCartAll(String username);
}
