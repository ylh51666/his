package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.bean.InspectItemRecord;
import com.model.service.InspectItemRecordService;

@Controller
public class InspectItemRecordController {

	@Autowired
	private InspectItemRecordService inspectItemRecordService;
	
	@RequestMapping("saveInspectItemRecord")
	@ResponseBody
	public void saveInspectItemRecord(HttpServletRequest request) {
		String ds = request.getParameter("ds");
		System.out.println(ds);
		/*JSONArray myJsonArray = JSONArray.fromObject(ds);
		for (int i = 0; i < myJsonArray.size(); i++) {
			JSONObject job = JSONObject.fromObject(myJsonArray.getJSONObject(i));
			CheckItemRecord checkItemRecord = new CheckItemRecord();
			checkItemRecord.setPid((int) job.get("pid"));
			checkItemRecord.setCid((int) job.get("cid"));
			checkItemRecord.setAmount((int) job.get("amount"));
			checkItemRecord.setPaystatus((int) job.get("paystatus"));
			checkItemRecordService.saveCheckItemRecord(checkItemRecord);
		}*/
		
		ObjectMapper objectMapper = new ObjectMapper();
		List readValue = null;
        try {
            readValue = objectMapper.readValue(ds, List.class);
            for (Object object : readValue) {
                String objectToJson = objectMapper.writeValueAsString(object);
                InspectItemRecord inspectItemRecord = objectMapper.readValue(objectToJson, InspectItemRecord.class);
                inspectItemRecordService.saveInspectItemRecord(inspectItemRecord);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
