package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.bean.InspectItemRecord;
import com.model.mapper.InspectItemRecordMapper;

@Service
public class InspectItemRecordService {

	@Autowired
	private InspectItemRecordMapper inspectItemRecordMapper;
	
	public void saveInspectItemRecord(InspectItemRecord inspectItemRecord) {
		inspectItemRecordMapper.saveInspectItemRecord(inspectItemRecord);
	}
	
}
