package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.bean.Dept;
import com.model.mapper.DeptMapper;

@Service
public class DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	public List<Dept> getDeptData(){
		return deptMapper.getDeptData();
	}
}
