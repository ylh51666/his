package com.model.mapper;

import java.util.List;

import com.model.bean.Dept;

public interface DoctorMapper {
	
	public List<Dept> getDoctorByDept(int deptid);
}
