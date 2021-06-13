package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Item;
import com.adminportal.repository.ItemRepository;
import com.adminportal.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> findAll() {
		return (List<Item>) itemRepository.findAll();
	}
	
	public Item findOne(Long id) {
		return itemRepository.findById(id).get();
	}		
	
	public void removeOne(long id) {
		itemRepository.deleteById(id);
		
	}
}
