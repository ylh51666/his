package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.MedicalRecord;
import com.model.bean.Patient;
import com.model.bean.User;
import com.model.service.MedicalRecordService;

@Controller
public class MedicalRecordController {
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@RequestMapping("saveMedicalRecord")
	@ResponseBody
	public void saveMedicalRecord(MedicalRecord mr,HttpSession session){
		int operator = ((User)session.getAttribute("loginUser")).getUserid();
		mr.setOperator(operator);
		medicalRecordService.saveMedicalRecord(mr);
	}
	
	@RequestMapping("getMedicalRecord/{pid}")
	@ResponseBody
	public Patient getMedicalRecord(@PathVariable int pid){
		return medicalRecordService.getMedicalRecord(pid);
	}
	@RequestMapping("updateFinalResult/{pid}/{result}/{finalResult}")
	@ResponseBody
	public void updateFinalResult(@PathVariable int pid,@PathVariable String result,@PathVariable String finalResult){
		System.out.println(pid);
		System.out.println(result);System.out.println(finalResult);
		medicalRecordService.updateFinalResult(pid,result,finalResult);
	}
}
