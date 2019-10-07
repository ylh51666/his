$(function(){
	
	$("#submit").attr("disabled",true);
	var username = GetQueryString("username");
	$("#username").html(username);
	
	function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return decodeURI(r[2]); return null;
	}
	
	function judgeStatus(){
		console.log($("#result").val());
		console.log($("#finalresult").val());
		console.log($("#initialresult").val());
		if($("#initialresult").val()!= ""&& $("#result").val()!=""&& $("#finalresult").val()!=""){
			if($("#pid").val()!=""&&!isNaN($("#pid").val())){
				if($("#status").html() == "正常"&&$("#getpid").val != ""){
					$("#submit").attr("disabled",false);
				}else{
					$("#submit").attr("disabled",true);
				}
			}else{
				$("#submit").attr("disabled",true);
			}
		}else{
			$("#submit").attr("disabled",true);
		}
	}
	
	$("#pid").change(function(){
		var pid = $("#pid").val();
		if(pid == ""){
			
		}else if(isNaN(pid)){
			
		}else{
			$.ajax({
				type:"post",
				url:"getMedicalRecord/"+pid,
				data:{},
				dataType:"json",
				success:function(data){
					if(data.pid == 0&&data.status != 1){
						$("#getpid").val("");
						$("#pname").val("");
						$("#gender").val("");
						$("#idcard").val("");
						$("#level").val("");
						$("#flag").html("");
						$("#status").html("");
						$("#dept").val("");
						$("#doctor").val("");
						$("#createDate").val("");
						$("#description").val("");
						$("#medicalhistory").val("");
						$("#familyhistory").val("");
						$("#initialresult").val("");
						$("#result").val("");
						$("#finalresult").val("");
					}else if(data.doctor.dname == $("#username").html()){
						$("#getpid").val(data.pid);
						$("#pname").val(data.pname);
						$("#gender").val(data.gender);
						$("#idcard").val(data.idcard);
						$("#level").val(data.level.levelname);
						$("#flag").html(data.pstatus);
						if(data.status == 1){
							$("#status").html("正常");
						}else{
							$("#status").html("已退号");
						}
						$("#dept").val(data.dept.deptname);
						$("#doctor").val(data.doctor.dname);
						$("#createDate").val(data.createDate);
						$("#description").val(data.medicalRecord.description);
						$("#medicalhistory").val(data.medicalRecord.medicalhistory);
						$("#familyhistory").val(data.medicalRecord.familyhistory);
						$("#initialresult").val(data.medicalRecord.initialresult);
						$("#result").val(data.medicalRecord.result);
						$("#finalresult").val(data.medicalRecord.finalresult);
					}
					judgeStatus();
				}
			})
		}
	})
	
	$("#result").change(function(){
		judgeStatus();
	})
	$("#finalresult").change(function(){
		judgeStatus();
	})
	$("#submit").click(function(){
		$.ajax({
			type:"post",
			url:"updateFinalResult/"+$("#getpid").val()+"/"+$("#result").val()+"/"+$("#finalresult").val(),
			data:{},
			success:function(){
				alert("提交成功");
				location.reload();
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
		location.href="doctor_result.html?username="+username;
	})
	$("#div1_5").click(function(){
		location.href="login.html";
	})
	
})