package cn.likegirl.shop.service;

import java.util.List;

import cn.likegirl.shop.entity.Category;


public interface CategoryService {

	/**
	 * 获得所有的二级分类
	 * @return
	 */
	public List<Category> getCategoryAll();

}