package cn.likegirl.shop.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.likegirl.shop.entity.Product;
import cn.likegirl.shop.service.ProductService;
import cn.likegirl.shop.utils.PageBeanUtils;


@Controller
@Scope("prototype")
@Namespace("/products")
@Results({
	@Result(name="productlist",location="/WEB-INF/pages/product_list.jsp"),
	@Result(name="product",location="/WEB-INF/pages/product.jsp")
})
public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	@Resource
	Product product;
	
	@Resource
	ProductService productServiceImp;
	
	private int pageIndex;
	
	private int cid;
	
	private int csid;
	
	public int getCsid() {
		return csid;
	}

	public void setCsid(int csid) {
		this.csid = csid;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	@Action("productdetail")
	public String productdetail() {
		System.out.println(product.getPid());
		product = productServiceImp.getProductByPid(product.getPid());
		
		return "product";
	}
	@Action("categoryall")
	public String pageproduct(){
		System.out.println(csid);
		PageBeanUtils pageBeanUtils = productServiceImp.ShowCPageProduct(pageIndex, cid, 12);
		System.out.println(pageBeanUtils.getProducts().size());
		ActionContext.getContext().getValueStack().set("pageBeanUtils", pageBeanUtils);
		
		return "productlist";
	}
	@Action("categorysecondall")
	public String pageproductbycs(){
		System.out.println(cid);
		PageBeanUtils pageBeanUtils = productServiceImp.ShowCsPageProduct(pageIndex, csid, 12);
		System.out.println(pageBeanUtils.getProducts().size());
		ActionContext.getContext().getValueStack().set("pageBeanUtils", pageBeanUtils);	
		return "productlist";
	}

}
