package com.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.CheckItemRecord;
import com.model.bean.InspectItemRecord;
import com.model.bean.Patient;
import com.model.bean.User;
import com.model.mapper.CheckItemRecordMapper;
import com.model.mapper.InspectItemRecordMapper;
import com.model.mapper.PatientMapper;

@Service
public class PatientService {
	
	@Autowired
	private PatientMapper patientMapper;
	
	@Autowired
	private CheckItemRecordMapper checkItemRecordMapper;
	
	@Autowired
	private InspectItemRecordMapper inspectItemRecordMapper;
	
	public int getPatientNo(){
		Patient p =  patientMapper.getPatientNo();
		return p.getPid();
	}
	
	public List<Patient> getPatientData(int pageSize,int pageNum) throws ParseException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("beginIndex", (pageNum-1)*pageSize);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, - 7);
		Date d = c.getTime();
		String day = format.format(d);
		Date selectDate = format.parse(day);
		java.sql.Date sDate = new java.sql.Date(selectDate.getTime());
		map.put("date", sDate);
		
		return patientMapper.getPatientData(map);
	}
	
	
	public void savePatient(Patient p,HttpSession session){
		p.setBirthday(p.getYear()+"-"+p.getMonth());
		p.setPstatus("未看诊");
		p.setStatus(1);
		p.setOperator(((User)session.getAttribute("loginUser")).getUserid());
		p.setOperateDate(new java.sql.Date(new Date().getTime()));
		patientMapper.savePatient(p);
	}
	
	public Patient getPatientByNo(int pid){
		return patientMapper.getPatientByNo(pid);
	}
	
	public void updatePatientStatus(int pid,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("operator", ((User)session.getAttribute("loginUser")).getUserid());
		map.put("operateDate", new java.sql.Date(new Date().getTime()));
		map.put("status", 0);
		map.put("pstatus", "未看诊");
		patientMapper.updatePatientStatus(map);
	}
	public List<Patient> getPatientDataByDoctor(int doctorid){
		return patientMapper.getPatientDataByDoctor(doctorid);
	}
	
	public Map<String, Object> getAllItemRecord(int pid){
		CheckItemRecord checkItemRecord = checkItemRecordMapper.getCheckItemRecords(pid);
		InspectItemRecord inspectItemRecord = inspectItemRecordMapper.getInspectItemRecords(pid);
		Map<String, Object> map = new HashMap<>();
		map.put("check", checkItemRecord);
		map.put("inspect", inspectItemRecord);
		return map;
	}
}
