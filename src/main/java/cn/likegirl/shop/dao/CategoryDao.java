package cn.likegirl.shop.dao;

import java.util.List;

import cn.likegirl.shop.entity.Category;


public interface CategoryDao {

	/**
	 * 保存
	 * @param category
	 */
    public void sava(Category category);
	
    /**
     * 修改
     * @param category
     */
	public void update(Category category);
	
	/**
	 * 删除
	 * @param category
	 */
	public void delete(Category category);
	
	/**
	 * 删除
	 * @param category
	 */
	public void delete(String cid);
	
	/**
	 * 查询
	 * @param id  用户ID(cid)
	 * @return   返回用户实体
	 */
	public Category findById(int id);
	
	/**
	 * 查询所有的一级分类
	 * @return
	 */
	public List<Category> findAll();
}
