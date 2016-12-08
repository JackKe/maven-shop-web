package cn.likegirl.shop.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.likegirl.shop.entity.Cart;
import cn.likegirl.shop.entity.CartItems;
import cn.likegirl.shop.entity.User;
import cn.likegirl.shop.service.CartService;




@Controller
@Scope("prototype")
@Namespace("/cart")
@Results({
	@Result(name="cart",location="/WEB-INF/pages/cart.jsp")
})
public class CartAction extends ActionSupport implements ModelDriven {

	@Resource
	CartService cartServiceImp;

	private int cartid; // 购物项ID

	private int pid; // 添加商品的ID

	private int count; // 添加购物项的数量

	// 用户名
	public String username = ((User) ServletActionContext.getRequest()
			.getSession().getAttribute("user")).getUsername();

	@Resource
	private CartItems cartitems;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	@Override
	public Object getModel() {
		return cartitems;
	}

	/**
	 * 购物车
	 * 
	 * @return
	 */
	@Action("showCart")
	public String showCart() {
		int totalPrices = 0;
		List<Cart> result = cartServiceImp.findCartsByUsername(username);
		for (Cart cart : result) {
			totalPrices += cart.getProduct().getShop_price() * cart.getCount();
		}
		cartitems.setResult(result);
		cartitems.setTotalPrices(totalPrices);

		return "cart";
	}

	/**
	 * 商品添加购物车
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action("saveCart")
	public String saveCart() throws IOException {
		System.out.println(username + "," + pid + "," + count);
		boolean flag = cartServiceImp.AddCart(username, pid, count);
		System.out.println(flag);
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("flag", flag);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		return NONE;
	}

	/**
	 * 删除购物项
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action("removeCart")
	public String removeCart() throws IOException {
		boolean flag = cartServiceImp.delCart(cartid);

		if (flag) {
			int totalPrices = 0;
			List<Cart> result = cartServiceImp.findCartsByUsername(username);
			for (Cart cart : result) {
				totalPrices += cart.getProduct().getShop_price()
						* cart.getCount();
			}
			cartitems.setResult(result);
			cartitems.setTotalPrices(totalPrices);
			System.out.println(cartitems.getResult().size()+","+cartitems.getTotalPrices());
			System.out.println(result.size());
			System.out.println(flag);
		}

		/*
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * JSONObject jsonObject = new JSONObject(); jsonObject.put("flag",
		 * flag); response.setContentType("text/javascript");
		 * response.setCharacterEncoding("UTF-8");
		 * response.getWriter().print(jsonObject.toString());
		 */
		return "cart";
	}
	
	@Action("deleteAll")
	public String deleteAll(){
		boolean flag = cartServiceImp.delCartAll(username);
		if(flag){
			cartitems.setResult(null);
			cartitems.setTotalPrices(0);
		}
		return "cart";
	}

}
