$(function(){
	var pid  = GetQueryString("pid");
	var username = GetQueryString("username");
	$("#username").html(username);
	
	function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return decodeURI(r[2]); return null;
	}
	
	$.ajax({
		type:"post",
		url:"getPatientByNo/"+pid,
		data:{},
		dataType:"json",
		success:function(data){
			$("#pid").val(data.pid);
			$("#pname").val(data.pname);
			$("#gender").val(data.gender);
			$("#idcard").val(data.idcard);
			$("#level").val(data.level.levelname);
			$("#flag").html(data.pstatus);
			$("#status").html("正常");
			$("#dept").val(data.dept.deptname);
			$("#doctor").val(data.doctor.dname);
			$("#createDate").val(data.createDate);
		}
	})
	
	$("#createMr").click(function(){
		$.ajax({
			type:"post",
			url:"saveMedicalRecord",
			data:$("#form1").serialize(),
			success:function(data){
				alert("病历生成成功！");
				location.href ="doctor_medicalRecord.html";
			}
		})
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
		location.href="";
	})
	$("#div1_5").click(function(){
		location.href="login.html";
	})
})