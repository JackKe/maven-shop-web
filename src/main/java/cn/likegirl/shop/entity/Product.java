package cn.likegirl.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

@Entity
@Table(name = "product",catalog = "ssh_shop")
@Repository
public class Product implements Serializable{
	
	@Id
	@GeneratedValue()
	@Column(name = "pid")
	private int pid;
	
	@Column(name = "pname", length = 32)
	private String pname;
	
	@Column(name = "market_price")
	private double market_price;
	
	@Column(name = "shop_price")
	private double shop_price;
	
	@Column(name = "image",length = 255)
	private String image;
	
	@Column(name = "pdesc",length = 255)
	private String pdesc;
	
	@Column(name = "is_hot")
	private int is_hot;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pdate")
	private Date pdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "csid")
	private Categorysecond categorysecond;
	
	@OneToMany(mappedBy = "product" , fetch = FetchType.LAZY)
    @OrderBy("cdate desc")
	private Set<Cart> carts = new HashSet<Cart>(0);

	//构造方法
	public Product(){
		
	}
	
	public Product(int pid, String pname, double market_price,
			double shop_price, String image, String pdesc, int is_hot,
			Date pdate, Categorysecond categorysecond, Set<Cart> carts) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.image = image;
		this.pdesc = pdesc;
		this.is_hot = is_hot;
		this.pdate = pdate;
		this.categorysecond = categorysecond;
		this.carts = carts;
	}






	//get set
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}

	public double getShop_price() {
		return shop_price;
	}

	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Categorysecond getCategorysecond() {
		return categorysecond;
	}

	public void setCategorysecond(Categorysecond categorysecond) {
		this.categorysecond = categorysecond;
	}
	
	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price="
				+ market_price + ", shop_price=" + shop_price + ", image="
				+ image + ", pdesc=" + pdesc + ", is_hot=" + is_hot
				+ ", pdate=" + pdate + ", categorysecond=" + categorysecond
				+ ", carts=" + carts + "]";
	}

}
