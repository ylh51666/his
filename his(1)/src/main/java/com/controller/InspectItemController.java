package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.InspectItem;
import com.model.service.InspectItemService;

@Controller
public class InspectItemController {
	
	@Autowired
	private InspectItemService inspectItemService;
	
	@RequestMapping("getAllInspectItem")
	@ResponseBody
	public List<InspectItem> getAllInspectItem(){
		return inspectItemService.getAllInspectItem();
	}
	
}
