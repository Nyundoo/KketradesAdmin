package com.adminportal.service;

import java.util.List;

import com.adminportal.domain.Item;



public interface ItemService {
	
	Item save(Item item);
	
	List<Item> findAll();
	
	Item findOne(Long id);

	void removeOne(long id);

}
