package com.model.service;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.bean.MedicalRecord;
import com.model.bean.Patient;
import com.model.mapper.MedicalRecordMapper;
import com.model.mapper.PatientMapper;

@Service
public class MedicalRecordService {
	
	@Autowired
	private MedicalRecordMapper medicalRecordMapper;
	
	@Autowired
	private PatientMapper patientMapper;
	
	public void saveMedicalRecord(MedicalRecord mr){
		medicalRecordMapper.saveMedicalRecord(mr);
		Map<String, Object> map = new HashMap<>();
		map.put("operator", mr.getOperator());
		map.put("operateDate", new Date(new java.util.Date().getTime()));
		map.put("pid", mr.getPid());
		map.put("status", 1);
		map.put("pstatus", "已看诊");
		patientMapper.updatePatientStatus(map);
	}
	
	public Patient getMedicalRecord(int pid){
		return medicalRecordMapper.getMedicalRecord(pid);
	}
	
	public void updateFinalResult(int pid,String result,String finalResult){
		Map<String, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("result", result);
		map.put("finalResult", finalResult);
		medicalRecordMapper.updateFinalResult(map);
	}
}
