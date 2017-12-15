package com.vamsi;

public class Item implements Comparable<Item> {
	private String itemName;
	private Integer quantity;
	private Double costPrice, sellingPrice;
	public Item() {}
	public Item(String itemName, Double costPrice, Double sellingPrice) {
		this(itemName, 1, costPrice, sellingPrice);
	}
	public Item(String itemName, Integer quantity, Double costPrice, Double sellingPrice) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
	}
	public String getItemName() {
		return this.itemName;
	}
	public Integer getQuantity() {
		return this.quantity;
	}
	public Double getCostPrice() {
		return this.costPrice;
	}
	public Double getSellingPrice() {
		return this.sellingPrice;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public void addQuantity(Integer count) {
		this.quantity += count;
	}
	public Double getValue() {
		return this.costPrice * this.quantity;
	}
	public Double getProfit() {
		return (this.sellingPrice - this.costPrice) * this.quantity;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Item)
			return this.itemName.equalsIgnoreCase(((Item) obj).getItemName());
		else
			return false;
	}
	@Override
	public int hashCode() {
		return this.itemName.hashCode();
	}
	@Override
	public int compareTo(Item i) {
		return this.itemName.compareToIgnoreCase(i.getItemName());
	}
}