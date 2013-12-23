<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vex.videoexam.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	Manager manager = (Manager)session.getAttribute("manager");
	if(manager == null){
		response.sendRedirect(basePath + "admin/fail.jsp");
		return;
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
function validate(){
	var title = $("#title").val();
	var content = $("#content").val();
	if(title == "" || content == ""){
		alert("请将信息填写完整");
		return;
	}
	$("#form1").submit();
	
}
//-->
</script>
  </head>
  
  <body>

  <form action="message/message_add" method="post" id="form1">
  	<input type="hidden" name="mgr_id" value="<%=manager.getId() %>"/>
   <table width="100%">
   	<tr><td>管理员：</td><td><%=manager.getName() %></td></tr>
   	<tr><td>标题：</td><td><input type="text" name="title" id="title" /></td></tr>
   	<tr><td>内容</td><td><textarea name="content" id="content"></textarea></td></tr>
   </table>
   <button  onclick="validate()">提交</button>
  </form>
  </body>
</html>
