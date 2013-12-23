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

-->
</style>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
function validate(obj){
	var id = $("#id").html();
	var name = $("#name").html();
	var pswd = $("#pswd").val();
	var pswd_range = $("#pswd_range").val();
	var category = $("#category").val();
	if( pswd == "" || pswd_range == "" || category == "" ){
		alert("请不要空着该填的地方！！");
		return;
	}
	if(pswd == pswd_range){
		$("#form1").submit();
		
	}
	else 
		alert("密码和密码确认不一致！！");
		return ;
	
}
//-->
</script>
  </head>
  
  <body>
  
	<form action="<%=basePath %>manager/manager_update" method="post"  id="form1">
		ID:<span id="id"><s:property value="manager.id" /></span><br/>
		用户名：<span id="name"><s:property value="manager.name" /></span><br />
		密码：<input type="text" name="pswd" id="pswd" value="<s:property value="manager.pswd" />"/><br/>
		确认密码：<input type="text" name="pswd_range" id="pswd_range" value="<s:property value="manager.pswd" />"/><br />
		选择权限：<select name="category" id="category">
			<option value="1">1(超级管理员)</option>
			<option value="2">2(通告管理员)</option>
			<option value="3">3(考务管理员)</option>
		</select><br />
		<input type="button" value="提交" onclick="validate()"/>
	</form>
	
    <s:debug></s:debug>
  </body>
</html>
