package com.model.mapper;

import java.util.Map;

import com.model.bean.MedicalRecord;
import com.model.bean.Patient;

public interface MedicalRecordMapper {

	public void saveMedicalRecord(MedicalRecord mr);
	
	public Patient getMedicalRecord(int pid);
	
	public void updateFinalResult(Map<String, Object> map);
}
