$(function(){
		
		// 获取新病历号（最大值加一）
		$.ajax({
			type:"post",
			url:"getPatientNo",
			data:{},
			dataType:"json",
			success:function(data){
				$("#pid").val(data.pno);
			}
		});
		// 获取挂号级别
		$.ajax({
			type:"post",
			url:"getLevelData",
			data:{},
			dataType:"json",
			success:function(data){
				for(var i = 0;i<data.length;i++){
					$("#level").append("<option data-cost='"+data[i].cost+"' value='"+data[i].id+"'>"+data[i].levelname+"</option>");
				}
			}
		});
		// 获取科室
		$.ajax({
			type:"post",
			url:"getDeptData",
			data:{},
			dataType:"json",
			success:function(data){
				for(var i = 0;i<data.length;i++){
					$("#dept").append("<option value='"+data[i].id+"'>"+data[i].deptname+"</option>");
				}
			}
		});
		// 分页
		var pageSize = 10;
		var pageNum = 1;
		$("#prePage").attr("disabled", true);
		getPageData();
		$("#div4_1").click(function(){
			pageNum = 1;
			getPageData();
			$("#page").html(1);
		})
		$("#prePage").click(function(){
			$("#nextPage").attr("disabled", false);
			if(pageNum != 1){
				pageNum = pageNum - 1;
				getPageData();
				$("#page").html(pageNum);
				if(pageNum == 1){
					$("#prePage").attr("disabled", true);
				}
			}else{
				$("#prePage").attr("disabled", true);
			}
		})
		$("#nextPage").click(function(){
			$("#prePage").attr("disabled", false);
			pageNum = pageNum + 1;
			getPageData("nextPage");
		})
		function getPageData(page){
			$.ajax({
				type:"post",
				url:"getPatientData/"+pageSize+"/"+pageNum,
				data:{},
				dataType:"json",
				success:function(data){
					if(page == "nextPage"){
						if(data.length == 0){
							pageNum = pageNum - 1;
							$("#page").html(pageNum);
							alert("已到达尾页");
						}else{
							$("#data_table tr:not(:first)").empty();
							for(var i = 0;i<data.length;i++){
								var status="";
								if(data[i].status == 0){
									status = "已退号";
								}else{
									status = "正常";
								}
								$("#data_table").append("<tr><td>"+data[i].pid+"</td><td>"+data[i].pname+"</td><td>"+data[i].gender+"</td>" +
										"<td>"+data[i].idcard+"</td><td>"+data[i].createDate+"</td><td>"+data[i].level.levelname+"</td>" +
										"<td>"+data[i].pstatus+"</td><td>"+status+"</td><td>"+data[i].dept.deptname+"</td><td>"+data[i].doctor.dname+"</td></tr>")
							}
							$("#page").html(pageNum);
						}
					}else{
						$("#data_table tr:not(:first)").empty();
						for(var i = 0;i<data.length;i++){
							var status="";
							if(data[i].status == 0){
								status = "已退号";
							}else{
								status = "正常";
							}
							$("#data_table").append("<tr><td>"+data[i].pid+"</td><td>"+data[i].pname+"</td><td>"+data[i].gender+"</td>" +
									"<td>"+data[i].idcard+"</td><td>"+data[i].createDate+"</td><td>"+data[i].level.levelname+"</td>" +
									"<td>"+data[i].pstatus+"</td><td>"+status+"</td><td>"+data[i].dept.deptname+"</td><td>"+data[i].doctor.dname+"</td></tr>")
						}
					}
				}
			})
		}
		
		
		
		$("#age").blur(function(){
			var age = $("#age").val();
			var cur = new Date();
			var curYear = cur.getFullYear();
			$("#year").val(curYear - age); 
		})
		
		$("#year").blur(function(){
			var year = $("#year").val();
			var cur = new Date();
			var curYear = cur.getFullYear();
			$("#age").val(curYear - year);
		})
		
		// 获取医生
		$("#dept").change(function(){
			var selectedDept = $("#dept").val();
			$.ajax({
				type:"post",
				url:"getDoctorByDept/"+selectedDept,
				data:{},
				dataType:"json",
				success:function(data){
					$("#doctor").empty();
					$("#doctor").append("<option value='-1'>-----请先选择科室-----</option>");
					for(var i = 0;i<data.length;i++){
						$("#doctor").append("<option value='"+data[i].id+"'>"+data[i].dname+"</option>");
					}
				}
			})
		})
		
		$("#level").change(function(){
			var cost = $("#level option:selected").attr("data-cost");
			$("#cost").val("0");
			var flag = $("#yes");
			if(flag[0].checked){
				$("#cost").val(parseInt(cost)+1);
			}else{
				$("#cost").val(parseInt(cost));
			}
		})
		
		$("#yes").click(function(){
			var cost = $("#level option:selected").attr("data-cost");
			$("#cost").val("0");
			$("#cost").val(parseInt(cost)+1);
		})
		$("#no").click(function(){
			var cost = $("#level option:selected").attr("data-cost");
			$("#cost").val("0");
			$("#cost").val(parseInt(cost));
		})
		$("#register").click(function(){
			$.ajax({
				type:"post",
				url:"savePatient",
				data:$("#form1").serialize(),
				dataType:"json",
				success:function(data){
					alert("挂号成功");
					location.reload();
				}
			})
		})
		
		$("#div1_2").click(function(){
			location.href="outPatient_pay.html";
		})
		$("#div1_3").click(function(){
			location.href="outPatient_refund.html";
		})
		$("#div1_4").click(function(){
			location.href="login.html";
		})
		
		$("#refresh").click(function(){
			pageNum = 1;
			getPageData();
		})
		
})