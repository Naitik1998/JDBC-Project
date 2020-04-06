package com.mindtree.shopproject.entity;

public class Shop {

	private int shopId;
	private String shopName;
	private int totalProduct;

	public Shop() {
	}

	public Shop(int shopId, String shopName, int totalProduct) {
		this.shopId = shopId;
		this.shopName = shopName;
		this.totalProduct = totalProduct;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shopId;
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + totalProduct;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (shopId != other.shopId)
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (totalProduct != other.totalProduct)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", totalProduct=" + totalProduct + "]";
	}

}
