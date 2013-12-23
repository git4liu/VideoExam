<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>管理平台</title>
<style>
<!--

-->
</style>
<script type="text/javascript" src="js/jquery182.js"></script>
<script type="text/javascript">
<!--
function exist(obj){
	var name = $("#name").val();
	$.ajax({
			type : "POST",
			url : "<%=basePath %>" + "manager/manager_load",
			data : "name="+ name,
			success:function(msg){
				if(msg == "yes")
					$("#show_exist").html("<font color='#009933'>该用户名未被注册，可以使用</font>");
				else
					$("#show_exist").html("<font color='#FF0000'>该用户名已经被注册，不可以使用！！</font>");
			}
		});
}
function validate(obj){
	var name = $("#name").val();
	var pswd = $("#pswd").val();
	var pswd_range = $("#pswd_range").val();
	var category = $("#category").val();
	if(name == "" || pswd == "" || pswd_range == "" || category == "" ){
		alert("请确保用户名和密码不为空！！");
		return;
	}
	if(pswd == pswd_range){
		$.ajax({
			type : "POST",
			url : "<%=basePath %>" + "manager/manager_load",
			data : "name="+ name,
			success:function(msg){
				if(msg == "yes")
					$("#form1").submit();
				else
					alert("换一个用户名吧");
					return;
			}
		});
		
	}
	else 
		alert("密码和密码确认不一致！！");
		return ;
	
}
//-->
</script>
  </head>
  
  <body>
  
	<form action="<%=basePath + "manager/" %>manager_add" method="post"  id="form1">
	<table>
		<tr><td>用户名：</td><td><input type="text" name="name" id="name" onblur="exist(this)"/><span id="show_exist"></span></td></tr>
		<tr><td>密码：</td><td><input type="text" name="pswd" id="pswd"/></td></tr>
		<tr><td>确认密码：</td><td><input type="text" name="pswd_range" id="pswd_range"/></td></tr>
		<tr><td>选择权限：</td><td><select name="category" id="category">
			<option value="1">1(超级管理员)</option>
			<option value="2">2(通告管理员)</option>
			<option value="3">3(考务管理员)</option>
		</select></td></tr>
	</table>
		<input type="button" value="提交" onclick="validate()"/>
	</form>
	
    <s:debug></s:debug>
  </body>
</html>
