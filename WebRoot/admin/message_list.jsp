<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
<style>
<!--
html,body{margin:0; padding:0;}
a{text-decoration:none;}
a:link{color:#ffffff;}
a:visited{color:#ffffff;}
a:active{color:#ffffff;}
a:hover{color:#ffffff; text-decoration:underline;}
table{text-align:center;}
table #title{background:#000000; color:#ffffff;}
.list:hover{ background:#aa33ff;}
.list{background:#666666; color:#ffffff;}
.list td:hover{ background:#336699;}
.list td span:hover{text-decoration:underline; cursor:pointer;}
-->
</style>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function(){
	var page_start = <s:property value="messageDto.page_start" />;
	var page_size = <s:property value="messageDto.page_size" />;
	var total = <s:property value="messageDto.total" />;
	var totalPages=(total % page_size == 0)?(total / page_size):(total / page_size+1);
	 if (totalPages >= 0)
    {
        totalPages = Math.floor(totalPages); //返回值为小于等于其数值参数的最大整数值。
    }
    else
    {
        totalPages = Math.ceil(totalPages); //返回值为大于等于其数字参数的最小整数。
    }
	
	if(total < page_size ){
		totalPages = 1;
	}
	var index = 0;
	for(index = 1 ; index <= totalPages ; index ++) {
		var option = "<option value=" + index + ">" + index +"</option>";
		if(index == page_start)
			option = "<option value=" + index + " selected >" + index +"</option>";
		$("#page_start").append(option);
	//alert(option);
	} 
	//alert(totalPages);
	/*var a = 15;
	var b = 7;
	var c = 7 % 15;
	alert(c);*/
	//alert(total + "\n" + page_size + "\n" + totalPages);
	$("#page_size" + page_size).attr("selected" , true);
	
});
function refresh(){
	var page_start = $("#page_start").val();
	var page_size = $("#page_size").val();
	window.open("<%=basePath%>message/message_list?page_start=" + page_start + "&&page_size=" + page_size ,"_self");
	//alert("refresh");
	//alert(page_start + "\n" + page_size);
}
function del(obj){
	if(confirm("您确定要删除此公告？"))
		$.ajax({
			type : "POST",
			url : "<%=basePath %>message/message_delete",
			data : "id="+ obj,
			success:function(msg){
					alert(msg);
					location.reload();
			}
		});
}
//-->
</script>
  </head>
  
  <body>
  <table width="100%" >
  <tr id="title">
  	<td>标题</td>
  	<td>公告ID</td>
  	<td>公告时间</td>
  	<td>最后操作</td>
  	<td colspan="2">操作</td>
  </tr>
   <s:iterator value="messages" var="message" status="status">
  	<tr  class="list">
  		<td><span><a href='message_show?id=<s:property value="#message.getId()"/>'><s:property value="#message.getTitle()"/></a></span></td>
  		<td><s:property value="#message.getId()"/></td>
  		<td><s:property value="#message.getTime()"/></td>
  		<td><s:property value="#message.getMgr_id()"/></td>
  		<td><span onclick='del(<s:property value="#message.getId()"/>)'>删除</span></td>
  		<td><span><a href='message_show?id=<s:property value="#message.getId()"/>'>修改</a></span></td>
  	</tr>
  	</s:iterator>

  </table>
  <table>
  	<tr>
  		<td>一共<s:property value="messageDto.total" />条记录</td>
  		<td>当前第
  			<select name="page_start" id="page_start"  onchange="refresh()">
  			</select>
  			页
  		</td>
  		<td>
	  		每页显示
	  		<select name="page_size" id="page_size" onchange="refresh()">
	  			<option value="15" id="page_size15">15</option>
	  			<option value="50" id="page_size50">50</option>
	  			<option value="100" id="page_size100">100</option>
  			</select>
	  		条
  		</td>
  	</tr>
  </table>
			 <br />
	
    <s:debug></s:debug>
  </body>
</html>
