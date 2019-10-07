package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.CheckItem;
import com.model.mapper.CheckItemMapper;

@Service
public class CheckItemService {
	
	@Autowired
	private CheckItemMapper checkItemMapper;
	
	public List<CheckItem> getAllCheckItem(){
		return checkItemMapper.getAllCheckItem();
	}
}
