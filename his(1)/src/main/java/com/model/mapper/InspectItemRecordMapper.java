package com.model.mapper;
import com.model.bean.InspectItemRecord;

public interface InspectItemRecordMapper {
	
	public void saveInspectItemRecord(InspectItemRecord inspectItemRecord);
	
	public InspectItemRecord getInspectItemRecords(int pid);
}
