package cn.likegirl.shop.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table( name="categorysecond" , catalog="ssh_shop")
@Repository
public class Categorysecond implements Serializable{
	
	@Id
	@GeneratedValue()
	@Column(name="csid")
	private int csid;
	
	@Column(name = "csname" , length = 32)
	private String csname;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	private Category category;
	
	@OneToMany(mappedBy = "categorysecond" , fetch = FetchType.LAZY)
	private Set<Product> products = new HashSet<Product>(0);

	//构造方法
	public Categorysecond(){
		
	}
	
	public Categorysecond(int csid, String csname, Category category,
			Set<Product> products) {
		super();
		this.csid = csid;
		this.csname = csname;
		this.category = category;
		this.products = products;
	}

	//get set
	public int getCsid() {
		return csid;
	}

	public void setCsid(int csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//toString()
	@Override
	public String toString() {
		return "Categorysecond [csid=" + csid + ", csname=" + csname
				+ ", category=" + category + ", products=" + products + "]";
	}
	

	
}
