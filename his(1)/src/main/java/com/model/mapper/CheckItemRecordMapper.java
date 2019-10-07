package com.model.mapper;

import com.model.bean.CheckItemRecord;

public interface CheckItemRecordMapper {
	
	public void saveCheckItemRecord(CheckItemRecord checkItemRecord);
	
	public CheckItemRecord getCheckItemRecords(int pid);
}
