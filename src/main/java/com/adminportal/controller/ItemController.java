package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal.domain.Item;
import com.adminportal.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addItem(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "addItem";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addItemPost(@ModelAttribute("item") Item item, HttpServletRequest request) {
		itemService.save(item);

		MultipartFile itemImage = item.getItemImage();

		try {
			byte[] bytes = itemImage.getBytes();
			String name = item.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("item-images/item1/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MultipartFile itemImage2 = item.getItemImage2();

		try {
			byte[] bytes = itemImage2.getBytes();
			String name = item.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("item-images/item2/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MultipartFile itemImage3 = item.getItemImage3();

		try {
			byte[] bytes = itemImage3.getBytes();
			String name = item.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("item-images/item3/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MultipartFile itemImage4 = item.getItemImage4();

		try {
			byte[] bytes = itemImage4.getBytes();
			String name = item.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("item-images/item4/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:itemList";
	}
	
	@RequestMapping("/itemList")
	public String itemList(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);	
		return "itemList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		itemService.removeOne(Long.parseLong(id.substring(8)));
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);
		
		return "redirect:/item/itemList";
	}
	
	@RequestMapping("/itemInfo")
	public String itemInfo(@RequestParam("id") Long id, Model model) {
		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		
		return "itemInfo";
	}

	@RequestMapping("/updateItem")
	public String updateItem(@RequestParam("id") Long id, Model model) {
		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		
		return "updateItem";
	}
	
	@RequestMapping(value="/updateItem", method=RequestMethod.POST)
	public String updateItemPost(@ModelAttribute("item") Item item, HttpServletRequest request) {
		itemService.save(item);
		
		MultipartFile itemImage = item.getItemImage();
		
		if(!itemImage.isEmpty()) {
			try {
				byte[] bytes = itemImage.getBytes();
				String name = item.getId() + ".jpg";
				
				Files.delete(Paths.get("src/main/resources/static/image/item/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/item/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
MultipartFile itemImage2 = item.getItemImage2();
		
		if(!itemImage2.isEmpty()) {
			try {
				byte[] bytes = itemImage2.getBytes();
				String name = item.getId() + ".jpg";
				
				Files.delete(Paths.get("src/main/resources/static/image/item2/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/item2/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
MultipartFile itemImage3 = item.getItemImage3();
		
		if(!itemImage3.isEmpty()) {
			try {
				byte[] bytes = itemImage3.getBytes();
				String name = item.getId() + ".jpg";
				
				Files.delete(Paths.get("src/main/resources/static/image/item3/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/item3/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
MultipartFile itemImage4 = item.getItemImage4();
		
		if(!itemImage4.isEmpty()) {
			try {
				byte[] bytes = itemImage4.getBytes();
				String name = item.getId() + ".jpg";
				
				Files.delete(Paths.get("src/main/resources/static/image/item4/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/item4/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return "redirect:/item/itemInfo?id="+item.getId();
	}
}
