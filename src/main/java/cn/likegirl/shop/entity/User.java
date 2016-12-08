package cn.likegirl.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;


@Entity
@Table(name="user",catalog="ssh_shop")
@Repository
public class User implements Serializable{

	@Id

	@Column(name = "username",length = 16)
	private String username;
	
	@Column(name = "password",length = 16)
	private String password;
	
	@Column(name = "email",length = 32)
	private String email;
	
	@Column(name = "name",length = 32)
	private String name;
	
	@Column(name = "sex",length = 2)
	private String sex;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "addres",length = 32)
	private String addres;
	
	@Column(name = "state",length = 1)
	private int state;
	
	@Column(name = "code",length = 32)
	private String code;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
	@OrderBy("cdate desc")
	private Set<Cart> carts = new HashSet<Cart>(0);
	
	//构造方法
	
	
	
	public User(){
		
	}

	public User(String username, String password, String email, String name,
			String sex, Date birthday, String addres, int state, String code,
			Set<Cart> carts) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.addres = addres;
		this.state = state;
		this.code = code;
		this.carts = carts;
	}

	//get set
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	
	//toString()
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", addres=" + addres + ", state="
				+ state + ", code=" + code + ", carts=" + carts + "]";
	}

	
	
	
	
	
	
	
	
	
}
