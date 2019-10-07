$(function(){
	
	$("#pid").change(function(){
		var pid = $("#pid").val();
		if(pid == ""){
			
		}else if(isNaN(pid)){
			
		}else{
			$.ajax({
				type:"post",
				url:"getAllItemRecord/"+pid,
				data:{},
				dataType:"json",
				success:function(data){
					
					console.log(data);
					
					
					
					/*if(data.pid == 0){
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
					}else{
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
					}*/
				}
			})
			
			
		}
	})
	
	
	$("#div1_1").click(function(){
		location.href="outPatient_register.html";
	})
	$("#div1_3").click(function(){
		location.href="outPatient_refund.html";
	})
	$("#div1_4").click(function(){
		location.href="login.html";
	})
})
