package com.example.SportyShoes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	
	@ManyToMany(targetEntity = Orders.class)
	@JoinTable( 
			name="Product_Order", 
			joinColumns = @JoinColumn(name="Product_Id"), 
			inverseJoinColumns = @JoinColumn(name="Order_Id")
			)
	private List<Orders> orders=new ArrayList<>();
	
	
	public List<Orders> getOrder() {
		return orders;
	}
	public void addOrder(Orders order) {
		this.orders.add(order);
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="product_id")
	private int product_id;
	
	@Column(name="product_name")
	private String product_name;
	
	private String product_category;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	
	
}
