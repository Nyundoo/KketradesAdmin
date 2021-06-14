package com.adminportal.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String category;
	private double shippingWeight;
	private double listPrice;
	private double ourPrice;
	private boolean active=true;
	@Column(columnDefinition="text")
	private String description;
	private int inStockNumber;
	
	@Transient
	private MultipartFile itemImage;
	
	@Transient
	private MultipartFile itemImage2;
	
	@Transient
	private MultipartFile itemImage3;
	
	@Transient
	private MultipartFile itemImage4;
	
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<ItemToCartItem> itemToCartItemList;

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getShippingWeight() {
		return shippingWeight;
	}


	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}


	public double getListPrice() {
		return listPrice;
	}


	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}


	public double getOurPrice() {
		return ourPrice;
	}


	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getInStockNumber() {
		return inStockNumber;
	}


	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}


	public MultipartFile getItemImage() {
		return itemImage;
	}


	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}


	public List<ItemToCartItem> getItemToCartItemList() {
		return itemToCartItemList;
	}


	public void setItemToCartItemList(List<ItemToCartItem> itemToCartItemList) {
		this.itemToCartItemList = itemToCartItemList;
	}


	public MultipartFile getItemImage2() {
		return itemImage2;
	}


	public void setItemImage2(MultipartFile itemImage2) {
		this.itemImage2 = itemImage2;
	}


	public MultipartFile getItemImage3() {
		return itemImage3;
	}


	public void setItemImage3(MultipartFile itemImage3) {
		this.itemImage3 = itemImage3;
	}


	public MultipartFile getItemImage4() {
		return itemImage4;
	}


	public void setItemImage4(MultipartFile itemImage4) {
		this.itemImage4 = itemImage4;
	}

	@Transient
	public String getMainImagePath1() {
		if(id == null) return null;
		
		return "/resources/item-images/item1/" + id;
	}
	
}
