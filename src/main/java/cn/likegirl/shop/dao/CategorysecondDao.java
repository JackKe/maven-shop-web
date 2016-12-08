package cn.likegirl.shop.dao;

import java.util.List;

import cn.likegirl.shop.entity.Categorysecond;


public interface CategorysecondDao {
	
	/**
	 * 保存
	 * @param categorysecond
	 */
    public void sava(Categorysecond categorysecond);
	
    /**
     * 修改
     * @param categorysecond
     */
	public void update(Categorysecond categorysecond);
	
	/**
	 * 删除
	 * @param categorysecond
	 */
	public void delete(Categorysecond categorysecond);
	
	/**
	 * 删除
	 * @param csid
	 */
	public void delete(String csid);
	
	/**
	 * 查询
	 * @param id  用户ID(csid)
	 * @return   返回用户实体
	 */
	public Categorysecond findById(String id);
	
	/**
	 * 查询所有的二级分类
	 * @return
	 */
	public List<Categorysecond> findAll();
	
	
	

}
