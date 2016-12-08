package cn.likegirl.shop.dao;

import java.util.List;

import cn.likegirl.shop.entity.User;


public interface UserDao {
	
	/**
	 * 保存
	 * @param user
	 */
    public void sava(User user);
	
    /**
     * 修改
     * @param user
     */
	public void update(User user);
	
	/**
	 * 删除
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * 删除
	 * @param username
	 */
	public void delete(String username);
	
	/**
	 * 查询
	 * @param id  用户ID(username)
	 * @return   返回用户实体
	 */
	public User findById(String id);
	
	
	public List<User> findByCode(String code);
	

}
