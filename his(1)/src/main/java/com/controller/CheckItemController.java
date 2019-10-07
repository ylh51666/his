package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.CheckItem;
import com.model.service.CheckItemService;

@Controller
public class CheckItemController {
	
	@Autowired
	private CheckItemService checkItemService;
	
	@RequestMapping("getAllCheckItem")
	@ResponseBody
	public List<CheckItem> getAllCheckItem(){
		return checkItemService.getAllCheckItem();
	}
}
