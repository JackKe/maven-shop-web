package cn.likegirl.shop.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.likegirl.shop.entity.Category;
import cn.likegirl.shop.entity.Categorysecond;
import cn.likegirl.shop.entity.Product;
import cn.likegirl.shop.service.CategoryService;
import cn.likegirl.shop.service.ProductService;

@Controller
@Scope("prototype")
@Namespace("/shop")
@Results({
	@Result(name="index",location="/WEB-INF/pages/index.jsp")
})
public class ShopAction {
	
	@Resource
	CategoryService categoryServiceImp;
	
	@Resource
	ProductService productServiceImp;
	
	@Action("index")
	public String homePage() throws Exception {
		//一级菜单
		List<Category> categorys = categoryServiceImp.getCategoryAll();
		ActionContext.getContext().getSession().put("categorys", categorys);
		for(Categorysecond cs : categorys.get(0).getCategoryseconds() ){
			System.out.println(cs.getCsname());
		}
		System.out.println(categorys.size());
		//热门商品
		List<Product> productHot = productServiceImp.getProductHot();
		ActionContext.getContext().getValueStack().set("productHot", productHot);
		//最新商品
		List<Product> productNew = productServiceImp.getProductNew();
		ActionContext.getContext().getValueStack().set("productNew", productNew);
	
		return "index";
	}

}
