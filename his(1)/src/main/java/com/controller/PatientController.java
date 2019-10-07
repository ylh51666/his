package com.controller;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Patient;
import com.model.bean.User;
import com.model.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("getPatientNo")
	@ResponseBody
	public String getPatientNo(){
		int pno = patientService.getPatientNo();
		return "{\"pno\":\""+pno+"\"}";
	}
	
	@RequestMapping("getPatientData/{pageSize}/{pageNum}")
	@ResponseBody
	public List<Patient> getPatientData(@PathVariable int pageSize,@PathVariable int pageNum){
		List<Patient> list = null;
		try {
			list =  patientService.getPatientData(pageSize, pageNum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("savePatient")
	@ResponseBody
	public String savePatient(Patient p,HttpSession session){
		patientService.savePatient(p, session);
		return "{\"result\":\"挂号成功\"}";
	}
	
	@RequestMapping("getPatientByNo/{pid}")
	@ResponseBody
	public Patient getPatientByNo(@PathVariable int pid){
		Patient p = patientService.getPatientByNo(pid);
		if(p == null){
			return new Patient();
		}
		return p;
	}
	
	@RequestMapping("updatePatientStatus/{pid}")
	@ResponseBody
	public void updatePatientStatus(@PathVariable int pid,HttpSession session){
		patientService.updatePatientStatus(pid,session);
	}
	
	@RequestMapping("getPatientDataByDoctor")
	@ResponseBody
	public List<Patient> getPatientDataByDoctor(HttpSession session){
		int doctorid = ((User)session.getAttribute("loginUser")).getUserid();
		return patientService.getPatientDataByDoctor(doctorid);
	}
	
	@RequestMapping("getAllItemRecord/{pid}")
	@ResponseBody
	public Map<String, Object> getAllItemRecord(@PathVariable int pid){
		return patientService.getAllItemRecord(pid);
	}
}
