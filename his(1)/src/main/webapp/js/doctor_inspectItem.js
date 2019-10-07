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
		if(typeof $("#data_table tr:not(:first)").html() != "undefined"){
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
				url:"getPatientByNo/"+pid,
				data:{},
				dataType:"json",
				success:function(data){
					if(data.pid == 0){
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
					}
					judgeStatus();
				}
			})
		}
	})
	
	$.ajax({
		type:"post",
		url:"getAllInspectItem",
		data:{},
		dataType:"json",
		success:function(data){
			for(var i = 0;i<data.length;i++){
				$("#inspectitem").append("<option data-price='"+data[i].price+"' data-id='"+data[i].id+"' value='"+data[i].id+"'>"+data[i].inspectItem+"</option>");
			}
		}
	})
	
	$("#add").click(function(){
		var option = $("#inspectitem option:selected");
		var tds = $("#data_table tr").find("td:eq(0)");
		var flag = false;
		for(var i = 0;i<tds.length;i++){
			if($(tds[i]).html() == option.html()){
				flag = true;
				break;
			}
		}
		if(option.val() == -1){
			
		}else if(flag == false){
			$("#data_table").append("<tr><td data-cid='"+option.attr("data-id")+"'>"+option.html()+"</td><td><input type='text' class='amount' value='1' /></td><td><label data-money='"+option.attr("data-price")+"'>"+option.attr("data-price")+"</label></td>" +
			"<td><img src='img/垃圾桶.png' class='delete' /></td></tr>")
		}
		judgeStatus();
	})
	
	
	$(document).on("click",".delete",function(){
		$(this).parent().parent().remove();
		judgeStatus();
	})
	
	$(document).on("blur",".amount",function(){
		var amount = $(this).val();
		if(!isNaN(amount)){
			var price = parseInt(amount)*parseInt($(this).parent().next().children().eq(0).attr("data-money"));
			$(this).parent().next().children().eq(0).html(price);
		}
	})
	
	$(document).on("click","#submit",function(){
		var pid = $("#getpid").val();
		var trs = $("#data_table tr:not(:first)");
		var jsonStrat = "[";
		trs.each(function(){ 
			var tds = $(this).children();
			jsonStrat = jsonStrat + "{\"pid\":\""+pid+"\",\"inspectid\":\""+tds.eq(0).attr("data-cid")+"\",\"amount\":\""+tds.eq(1).children().val()+"\",\"paystatus\":\"1\"},";
		})
		jsonStrat = jsonStrat.substring(0,jsonStrat.length-1)+"]";
		$.ajax({
			type:"post",
			url:"saveInspectItemRecord",
			data:{
				ds:jsonStrat
			},
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
