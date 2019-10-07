package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.InspectItem;
import com.model.mapper.InspectItemMapper;

@Service
public class InspectItemService {
	
	
	@Autowired
	private InspectItemMapper inspectItemMapper;
	
	public List<InspectItem> getAllInspectItem(){
		 return inspectItemMapper.getAllInspectItem();
	}
}
