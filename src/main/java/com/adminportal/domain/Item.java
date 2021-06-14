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
	private String mainImage;
	private String extraImage1;
	private String extraImage2;
	private String extraImage3;
	
	
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
	
	

	public String getMainImage() {
		return mainImage;
	}


	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}


	public String getExtraImage1() {
		return extraImage1;
	}


	public void setExtraImage1(String extraImage1) {
		this.extraImage1 = extraImage1;
	}


	public String getExtraImage2() {
		return extraImage2;
	}


	public void setExtraImage2(String extraImage2) {
		this.extraImage2 = extraImage2;
	}


	public String getExtraImage3() {
		return extraImage3;
	}


	public void setExtraImage3(String extraImage3) {
		this.extraImage3 = extraImage3;
	}


	@Transient
	public String getMainImagePath() {
		if(id == null || mainImage == null) return null;
		
		return "/item-images/" + id + "/" + mainImage;
	}
	
}
