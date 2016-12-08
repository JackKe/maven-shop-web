package cn.likegirl.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.likegirl.shop.dao.CategoryDao;
import cn.likegirl.shop.entity.Category;
import cn.likegirl.shop.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Resource
	CategoryDao categoryDaoImp;

	@Override
	public List<Category> getCategoryAll(){
		List<Category> list = null;
		list = categoryDaoImp.findAll();
		return list;	
	}
}
