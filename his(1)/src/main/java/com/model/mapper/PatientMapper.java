package com.model.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import com.model.bean.Patient;

public interface PatientMapper {
	
	public Patient getPatientNo();
	
	public List<Patient> getPatientData(Map<String, Object> map);
	
	public void savePatient(Patient p);
	
	public Patient getPatientByNo(int pid);
	
	public void updatePatientStatus(Map<String, Object> map);
	
	public List<Patient> getPatientDataByDoctor(int doctorid);
	
	public Patient getAllItemRecord(@PathVariable int pid);
}
