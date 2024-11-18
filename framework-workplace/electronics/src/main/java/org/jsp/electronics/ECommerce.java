package org.jsp.electronics;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ECommerce {
	@Id
	private int itemId;

	@Override
	public String toString() {
		return "ECommerce [itemId=" + itemId + ", itemName=" + itemName + ", itemBrand=" + itemBrand + ", itemPrice="
				+ itemPrice + ", itemCount=" + itemCount + "]";
	}

	private String itemName;
	private String itemBrand;
	private double itemPrice;
	private int itemCount;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}
