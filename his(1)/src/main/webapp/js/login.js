$(function(){
	
	$("#loginBtn").click(function(){
		$.ajax({
			type:"post",
			url:"userlogin",
			data:$("#form1").serialize(),
			dataType:"json",
			success:function(data){
				if(data.result == "登录失败"){
					alert("登录失败");
				}else{
					var role = $("#div_select").val();
					if(role == "门诊管理员"){
						location.href="outPatient_register.html?username="+data.result;
					}else{
						location.href="doctor_medicalRecord.html?username="+data.result;
					}
				}
				
			}
		})
		
		
	})
})