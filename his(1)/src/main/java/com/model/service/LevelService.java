package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.Level;
import com.model.mapper.LevelMapper;

@Service
public class LevelService {
	
	@Autowired
	private LevelMapper levelMapper;
	
	public List<Level> getLevelData(){
		return levelMapper.getLevelData();
	}
}
