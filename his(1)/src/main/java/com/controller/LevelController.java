package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Level;
import com.model.service.LevelService;

@Controller
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	@RequestMapping("getLevelData")
	@ResponseBody
	public List<Level> getLevelData(){
		return levelService.getLevelData();
	}
}
