package cn.likegirl.shop.action;

import java.io.IOException;

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

import cn.likegirl.shop.entity.User;
import cn.likegirl.shop.service.UserService;

@Controller
@Scope("prototype")
@Namespace("/user")
@Results({
	@Result(name="home",location="/WEB-INF/pages/home.jsp"),
	@Result(name="index",location="/shop/index.action",type="redirect"),
	@Result(name="loginPage",location="/WEB-INF/pages/login.jsp"),
	@Result(name="registPage",location="/WEB-INF/pages/regist.jsp"),
	@Result(name="msg",location="/WEB-INF/pages/msg.jsp")
})
public class UserAction extends ActionSupport implements ModelDriven{
	

	@Resource
	User user;

	@Resource
	UserService userServiceImp;

	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	/**
	 * 注册跳转方法
	 * 
	 * @return
	 */
	@Action("registPage")
	public String registPage() {
		return "registPage";
	}

	/**
	 * 校验用户名是否可用
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action("checkUserName")
	public String checkUserName() throws IOException {
		boolean flag = userServiceImp.CheckUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (!flag)
			response.getWriter().print("<font color='red'>*该用户名已经被使用了</font>");
		else
			response.getWriter()
					.print("<font color='green'>*该用户名可以被使用了</font>");
		return NONE;
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Action("regist")
	public String regist() {
		boolean flag = userServiceImp.Add(user);
		if (flag) {
			this.addActionMessage("注册成功：请去邮箱激活！");
			return "msg";
		} else {
			this.addActionMessage("注册失败：请重新操作！");
			return "msg";
		}
	}

	/**
	 * 用户激活
	 * 
	 * @return
	 */
	@Action("active")
	public String active() {
		boolean flag = userServiceImp.UserActive(user.getCode());
		if (flag)
			this.addActionMessage("激活成功：请去登录！");
		else {
			this.addActionMessage("激活失败：请重新操作！");
		}
		return "msg";
	}

	/**
	 * 校验验证码
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action("checkcode")
	public String checkcode() throws IOException {
		String _captcha = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		boolean flag = false;
		if (captcha.length() > 0 && _captcha != null)
			if (captcha.equalsIgnoreCase(_captcha)) {
				flag = true;
			}
		/*System.out.println(captcha + "," + _captcha + "," + flag);
		System.out.println(ServletActionContext.getRequest().getParameter(
				"captcha")
				+ ".");*/
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("flag", flag);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		return NONE;
	}

	/**
	 * 登录页面跳转
	 * 
	 * @return
	 */
	@Action("loginPage")
	public String loginPage() {
		return "loginPage";
	}

	/**
	 * 登录验证
	 * @return
	 */
	@Action("login")
	public String login() {
		System.out.println(user.getUsername()+","+user.getPassword());
		int flag = userServiceImp.UserLogin(user.getUsername(),
				user.getPassword());
		System.out.println(flag);
		switch (flag) {
		case 0:
			//System.out.println(((User)ServletActionContext.getRequest().getAttribute("user")).getName());
			return "index";		
		case 1:
			this.addActionMessage("登录失败：账号密码不匹配！");
			return "loginPage";
		default:
			this.addActionMessage("登录失败：账号未激活！");
			return "loginPage";
		}
	}
	/**
	 * 用户退出
	 * @return
	 */
	@Action("quit")
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "index";
	}
	
	@Action("home")
	public String home(){
		return "home";
	}

	
}
