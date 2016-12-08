package cn.likegirl.shop.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.likegirl.shop.dao.CartDao;
import cn.likegirl.shop.dao.ProductDao;
import cn.likegirl.shop.dao.UserDao;
import cn.likegirl.shop.entity.Cart;
import cn.likegirl.shop.service.CartService;

@Service
@Scope("prototype")
public class CartServiceImp implements CartService {

	@Resource
	CartDao cartDaoImp;

	@Resource
	UserDao userDaoImp;

	@Resource
	ProductDao productDaoImp;

	@Resource
	Cart cart;

	
	@Override
	public boolean AddCart(String username, int pid, int count) {

		try {
			cart.setUser(userDaoImp.findById(username));
			cart.setProduct(productDaoImp.findById(pid));
			cart.setCount(count);
			cart.setCdate(new Date());
			System.out.println(cart.getCdate());
			System.out.println(cart.getUser().getName());
			System.out.println(cart.getProduct().getPname());
			cartDaoImp.sava(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delCart(int cartid) {
		try {
			cartDaoImp.delete(cartid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Cart> findCartsByUsername(String username) {
		List<Cart> result = null;
		try {
			result = cartDaoImp.findALL(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delCartAll(String username) {
		int result = cartDaoImp.deleteAll(username);
		if (result == 0)
			return false;
		return true;
	}

}
