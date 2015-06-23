
var CalendarWebControl = new atCalendarControl();

function dele(){
	$(".deleteDetail").click(function(){
		var outNo = $(this).next(":input").val();//this代表a链接
		var flag = confirm("确定要删除"+ outNo +"的信息吗？");
		alert("111");
		if(flag){//真的要删除
			alert("222");
			var $tr = $(this).parent().parent();
			//执行删除，实行ajax的方法
			var url = this.href;
			var args = {"time":new Date()};
			$.post(url , args , function(data){//data如何返回
				//若data的返回值为1.则提示删除成功，且把当前行删除，
				if(data == 1){
					alert("删除成功！");
					$tr.remove();
					document.getElementById('div').innerHTML="删除成功";
				}else{
					//若data的返回值不是1，提示删除失败
					document.getElementById('div').innerHTML="删除失败！";
				}
				$("#div").show();
			});
		}
		//(先需要)取消超链接的默认行为
		return false;
	});
}

function save(){
	alert("执行save");
	$(".save").click(function(){
		var flag = true;
		if(flag){
				
			if (document.getElementById("rp").value=="") {
				var srp = document.getElementById('srp');
				srp.innerHTML = "<font color='red'>rp必须输入</font>";
				flag = false;
			}
			if (document.getElementById("rpp").value=="") {
				var srpp = document.getElementById('srpp');
				srpp.innerHTML = "<font color='red'>接收人电话必须输入</font>";
				flag = false;
			}
			if (document.getElementById("add").value=="") {
				var sadd = document.getElementById('sadd');
				sadd.innerHTML = "<font color='red'>接收人地址必须输入</font>";
				flag = false;
			}
		}
		if(flag){
			var id = $('#outId').val();
			var outNo = $('#outNo').val();
			var outDate = $('#frmWRPT_OPT_DATE2_PJT70302').val();
			var stores = $('#stores').val();
			var rp = $('#rp').val();
			var rpp = $('#rpp').val();
			var add = $('#add').val();
			alert("id="+id);
			alert("id==0====="+id==0);
			alert("id!=0====="+id!=0);
			alert("rp="+rp);
			var remark = document.getElementById('remark').value;
			
			if(id==0){
				alert(111);
				$.ajax({
					type: 'POST',
	            	url: '<%=basePath%>/outOrder/outOrderSave.action',
	            	data: { "outOrder.outNo" : outNo  , "outOrder.outDate": outDate , "outOrder.storePO.id" : stores , "outOrder.receivePerson":rp , "outOrder.receivePhone" :rpp , "outOrder.address":add , "outOrder.remark" : remark , "method":"add"},
	            	success:function(data){
		            	alert("data======"+data);
						var d = eval("("+data+")");
						for (var i=0;i<d.length;i++){ 
							var outOrderNo=  d[i];
							if(outOrderNo.outNo != null){
								$('#outOrderNo').val(outOrderNo.outNo);
								$("#div").text("添加成功！");
							}else{
								$("#div").text("添加失败！");
							}
							$("#div").show();
						}
	            	}
				});
			}else{
				$.ajax({
					type: 'POST',
	            	url: '<%=basePath%>/outOrder/outOrderSave.action',
	            	data: { "outOrder.outNo" : outNo , "outOrder.outDate": outDate , "outOrder.storePO.id" : stores , "outOrder.receivePerson":rp , "outOrder.receivePhone" :rpp , "outOrder.address":add , "outOrder.remark" : remark , "method":"update"},
	            	success:function(data){
		            	if(data == 1){
							alert("修改成功！");
							$("#div").text("修改成功！");
						}else{
							alert("修改失败！");
							$("#div").text("修改失败！");
						}
						$("#div").show();
	            	}
				});
			}
		}
	});
}

function goSearch(){
	document.forms[0].action="<%=basePath%>/stock/order3002.jsp";
	document.forms[0].submit();
}

function onblurRP(){
	if (document.getElementById("rp").value!="") {
		var srp = document.getElementById('srp');
		srp.innerHTML = "<font color='red'></font>";
	}
}

function onblurRPP(){
	if(document.getElementById("rpp").value != ""){
		var srpp = document.getElementById('srpp');
		srpp.innerHTML = "<font color='red'></font>";
	}
}

function onblurA(){
	if(document.getElementById("add").value != ""){
		var sadd = document.getElementById('sadd');
		sadd.innerHTML = "<font color='red'></font>";
	}
}
		
