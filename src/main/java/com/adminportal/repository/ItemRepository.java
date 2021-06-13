package com.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
