<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vex.videoexam.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Manager manager = (Manager) session.getAttribute("manager");
	if(manager == null)
		response.sendRedirect("fail.jsp");
	int id = manager.getId();
 %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<style>
<!--

-->
</style>
<script type="text/javascript" src="js/jquery182.js"></script>
<script type="text/javascript">
<!--
function validate(obj){
	var name = $("#name").val();
	var desc = $("#desc").val();
	if(name == "" || desc == "" ){
		alert("请把该填的都填上！！");
		return;
	}

	$("#form1").submit();
}
//-->
</script>
  </head>
  
  <body>
  
	<form action="<%=basePath + "specify/" %>specify_add" method="post"  id="form1">
		<input type="hidden"name="father_id" value="1" />
		<input type="hidden"name="mgr_id" value="<%=id %>" />
		
		知识点名称：<input type="text" name="name" id="name"/><br />
		描述：<input type="text" name="desc" id="desc"/><br/>
		<input type="button" value="提交" onclick="validate()"/>
	</form>
	
    <s:debug></s:debug>
  </body>
</html>
