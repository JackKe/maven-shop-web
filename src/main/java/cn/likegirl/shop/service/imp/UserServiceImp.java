package cn.likegirl.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import cn.likegirl.shop.dao.UserDao;
import cn.likegirl.shop.entity.User;
import cn.likegirl.shop.service.UserService;
import cn.likegirl.shop.utils.EmailUtils;
import cn.likegirl.shop.utils.UUIDUtils;



@Service
public class UserServiceImp implements UserService {

	@Resource
	UserDao userDaoImp;

	@Override
	public boolean CheckUserName(String username) {
		if (userDaoImp.findById(username) == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean Add(User user) {
		try {
			user.setState(0);
			user.setCode(UUIDUtils.getUUID());
			userDaoImp.sava(user);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		EmailUtils.sendEmail(user.getEmail(), user.getCode());
		return true;
	}

	@Override
	public boolean UserActive(String code) {
		List<User> list = userDaoImp.findByCode(code);
		if (list.size() != 1)
			return false;
		else{
			try {
				User user = list.get(0);
				user.setState(1);
				userDaoImp.update(user);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public int UserLogin(String username, String password) {
		User user = userDaoImp.findById(username);
		if(user != null){
			if(user.getPassword().trim().equals(password.trim())){
				System.out.println("==");
				if(user.getState() == 1)
				{
					ServletActionContext.getRequest().getSession().setAttribute("user", user);
					return 0;
				}
				else
					return 2;
			}
		}
		return 1;
	}

}
