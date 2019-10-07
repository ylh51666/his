package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Dept;
import com.model.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("getDeptData")
	@ResponseBody
	public List<Dept> getDeptData(){
		return deptService.getDeptData();
	}
}
