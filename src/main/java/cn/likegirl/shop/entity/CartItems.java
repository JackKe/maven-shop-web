package cn.likegirl.shop.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 
 * 购物车明细
 * 
 * @author CK_BOY
 *
 */
@Repository
@Scope("prototype")
public class CartItems {

	private List<Cart> result;
	
	private double totalPrices;

	public List<Cart> getResult() {
		return result;
	}

	public void setResult(List<Cart> result) {
		this.result = result;
	}

	public double getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}
}
