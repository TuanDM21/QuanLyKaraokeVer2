package com.dmt.model;

public class WareHouse {
	private int id;
	private int productId;
	private int quantity;

	public WareHouse() {
	}

	public WareHouse(int id, int productId, int quantity) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
