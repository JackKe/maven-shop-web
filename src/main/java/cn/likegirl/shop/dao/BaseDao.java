package cn.likegirl.shop.dao;

public interface BaseDao<T> {
	
	public void sava(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);	
	
}
