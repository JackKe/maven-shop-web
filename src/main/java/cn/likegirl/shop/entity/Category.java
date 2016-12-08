package cn.likegirl.shop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Entity
@Table(name="category",catalog="ssh_shop")
@Repository
public class Category implements Serializable{
	@Id
	@GeneratedValue()
	@Column(name = "cid")
	private int cid;
	
	@Column(name = "cname" , length = 32)
	private String cname;
	
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	@OrderBy("cid asc")
	private Set<Categorysecond> categoryseconds = new HashSet<Categorysecond>(0);

	//构造方法
	public Category(){
		
	}
		
	public Category(int cid, String cname, Set<Categorysecond> categoryseconds) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.categoryseconds = categoryseconds;
	}

	// get set
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Categorysecond> getCategoryseconds() {
		return categoryseconds;
	}

	public void setCategoryseconds(Set<Categorysecond> categoryseconds) {
		this.categoryseconds = categoryseconds;
	}
	
}
