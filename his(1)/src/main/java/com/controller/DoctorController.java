package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.bean.Dept;
import com.model.service.DoctorService;

@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("getDoctorByDept/{deptid}")
	@ResponseBody
	public List<Dept> getDoctorByDept(@PathVariable int deptid){
		return doctorService.getDoctorByDept(deptid);
	}
}
