package cn.likegirl.shop.service;

import cn.likegirl.shop.entity.User;

public interface UserService {
	
	/**
	 * 校验用户名
	 * @param username
	 * @return  true 表示可以，false 表示被使用
	 */
	public boolean CheckUserName(String username);
	
	/**
	 * 新增用户
	 * @param user
	 * @return true 表示注册成功， flase 表示注册失败
	 */
	public boolean Add(User user);
	
	/**
	 * 用户激活
	 * @param code
	 * @return true 表示激活成功 ，flase 表示激活失败
	 */
	public boolean UserActive(String code); 
	
	/**
	 *  用户登录
	 *  
	 * @param username
	 * @param password
	 * @return
	 *  返回： 0 ，代表正确
	 *      1，代表账号密码不匹配
	 *      2，代表账号未激活
	 */
	public int UserLogin(String username,String password);
}
