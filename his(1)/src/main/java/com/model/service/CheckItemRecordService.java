package com.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.bean.CheckItemRecord;
import com.model.mapper.CheckItemRecordMapper;
@Service
public class CheckItemRecordService {
	
	
	@Autowired
	private CheckItemRecordMapper checkItemRecordMapper;
	
	public void saveCheckItemRecord(CheckItemRecord checkItemRecord) {
		checkItemRecordMapper.saveCheckItemRecord(checkItemRecord);
	}
}
