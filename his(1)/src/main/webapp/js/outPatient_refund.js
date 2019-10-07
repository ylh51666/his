$(function(){
	$("#refund").attr("disabled",true);
	$("#rearch").click(function(){
		var pid = $("#pid").val();
		if(pid == ""){
			
		}else if(isNaN(pid)){
			
		}else{
			$.ajax({
				type:"post",
				url:"getPatientByNo/"+pid,
				data:{},
				dataType:"json",
				success:function(data){
					if(data.pid == 0){
						
					}else{
						$("#getpid").val(data.pid);
						$("#pname").val(data.pname);
						$("#gender").val(data.gender);
						$("#idcard").val(data.idcard);
						$("#level").val(data.level.levelname);
						$("#flag").html(data.pstatus);
						if(data.pstatus == "未看诊" && data.status == 1){
							$("#refund").attr("disabled",false);
						}else{
							$("#refund").attr("disabled",true);
						}
						if(data.status == 1){
							$("#status").html("正常");
						}else{
							$("#status").html("已退号");
						}
						$("#dept").val(data.dept.deptname);
						$("#doctor").val(data.doctor.dname);
						$("#createDate").val(data.createDate);
					}
				}
			})
		}
	})
	
	$("#refund").click(function(){
		var pid = $("#pid").val();
		var flag = $("#flag").val();
		$.ajax({
			type:"post",
			url:"updatePatientStatus/"+pid,
			data:{},
			success:function(data){
				alert("退号成功");
				location.href="outPatient_register.html";
			}
		})
	})
	$("#div1_1").click(function(){
		location.href="outPatient_register.html";
	})
	$("#div1_2").click(function(){
		location.href="outPatient_pay.html";
	})
	$("#div1_4").click(function(){
		location.href="login.html";
	})
})