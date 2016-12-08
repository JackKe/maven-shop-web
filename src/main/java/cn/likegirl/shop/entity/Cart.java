package cn.likegirl.shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "cart" , catalog = "ssh_shop")
@Repository
@Scope("prototype")
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "cartid")
	private int cartid;
	
	@Column(name = "count")
	private int count;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cdate")
	private Date cdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pid")
	private Product product;
	
	

	// 构造方法
	public Cart(){
		
	}
		
	public Cart(int cartid, User user, Product product, int count, Date cdate) {
		super();
		this.cartid = cartid;
		this.user = user;
		this.product = product;
		this.count = count;
		this.cdate = cdate;
	}

	// set get
	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	
	//toString()
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", user=" + user + ", product="
				+ product + ", count=" + count + ", cdate=" + cdate + "]";
	}
	


}
