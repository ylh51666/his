$(function(){
	var username = GetQueryString("username");
	function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return decodeURI(r[2]); return null;
	}
	
	
	$.ajax({
		type:"post",
		url:"getPatientDataByDoctor",
		data:{},
		dataType:"json",
		success:function(data){
			for(var i = 0;i < data.length;i++){
				var sta="";
				if(data[i].status == 0){
					sta = "已退号";
				}else{
					sta = "正常";
				}
				if(data[i].pstatus == "未看诊"&&data[i].status == 1){
					$("#no").append("<tr class='table' data-pid='"+data[i].pid+"'><td>"+data[i].pid+"</td><td>"+data[i].pname+"</td><td>"+data[i].gender+"</td>" +
					"<td>"+data[i].idcard+"</td><td>"+data[i].createDate+"</td><td>"+data[i].level.levelname+"</td>" +
					"<td>"+data[i].pstatus+"</td><td>"+sta+"</td><td>"+data[i].dept.deptname+"</td><td>"+data[i].doctor.dname+"</td></tr>");
				
				}else if(data[i].pstatus == "已看诊"&&data[i].status == 1){
					$("#yes").append("<tr><td>"+data[i].pid+"</td><td>"+data[i].pname+"</td><td>"+data[i].gender+"</td>" +
					"<td>"+data[i].idcard+"</td><td>"+data[i].createDate+"</td><td>"+data[i].level.levelname+"</td>" +
					"<td>"+data[i].pstatus+"</td><td>"+sta+"</td><td>"+data[i].dept.deptname+"</td><td>"+data[i].doctor.dname+"</td></tr>");
				}
			}
		}
	})
	
	$(document).on("click",".table",function(){
		var pid = $(this).attr("data-pid");
		location.href = "doctorRegmedicalRecord.html?pid="+pid+"&username="+username;
	})
	
	$("#div1_1").click(function(){
		location.href="doctor_medicalRecord.html?username="+username;
	})
	
	$("#div1_2").click(function(){
		location.href="doctor_checkItem.html?username="+username;
	})
	
	$("#div1_3").click(function(){
		location.href="doctor_inspectItem.html?username="+username;
	})
	
	$("#div1_4").click(function(){
		location.href="doctor_result.html?username="+username;
	})
	$("#div1_5").click(function(){
		location.href="login.html";
	})
})