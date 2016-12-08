package cn.likegirl.shop.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.likegirl.shop.entity.CartItems;


@Controller
@Scope("prototype")
@Namespace("/orders")
@Results({
	@Result(name="submitOrder",location="/WEB-INF/pages/Orders.jsp")
})
public class OrdersAction extends ActionSupport implements ModelDriven<CartItems>{

	@Resource
	private CartItems cartItems;
	
	public CartItems getCartItems() {
		return cartItems;
	}
	
	@Override
	public CartItems getModel() {
		// TODO Auto-generated method stub
		return cartItems;
	}
	@Action("submitOrder")
	public String submitOrder(){
		if(cartItems != null && cartItems.getResult() != null)
		System.out.println(cartItems.getResult().size());
		
		return "submitOrder";
	}

	
	
}
