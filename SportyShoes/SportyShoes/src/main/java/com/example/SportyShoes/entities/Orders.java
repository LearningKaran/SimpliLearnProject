package com.example.SportyShoes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Orders {
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(mappedBy = "orders")
	private List<Product> product=new ArrayList<>();

	
	public List<Product> getProduct() {
		return product;
	}

	public void addProduct(Product product) {
		this.product.add(product);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="order_id")
	private int order_id;
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
