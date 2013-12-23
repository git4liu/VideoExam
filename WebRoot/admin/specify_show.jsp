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
function validate(){
	var id = $("#id").val();
	var name = $("#name").val();
	var desc = $("#desc").html();
	var mgr_id = $("#mgr_id").val();
	var child_size = $("#child_size").val();
	var father_id = $("#father_id").val();
	var lev = $("#lev").val();
	var leaf = $("#leaf").val();
	alert(id + "--" + name + "--" + desc + "--" + child_size + "--" + father_id + "--" + lev + " --" + leaf);
	if( id == "" || name == "" || mgr_id == "" ){
		alert("请不要空着该填的地方！！");
		return;
	}
	$("#form1").submit();
		

	
}
//-->
</script>
  </head>
  
  <body>
  
	<form action="<%=basePath %>specify/specify_update" method="post"  id="form1">\
	<table >
		<tr><td>ID:</td><td><span><s:property value="specify.id" /></span></td></tr>
		<tr><td>名称：</td><td><input type="text" name="name" id="name" value="<s:property value="specify.name" />" /></td></tr>
		<tr><td>描述：</td><td><textarea  name="desc" id="desc"><s:property value="specify.desc" /></textarea></td></tr>
		<tr><td></td><td></td></tr>
	</table>
		<input type="hidden" value="<%=manager.getId() %>"  name="mgr_id" id="mgr_id" />
		<input type="hidden" value="<s:property value="specify.id" />" name="id"  id="id" />
		<input type="hidden" value="<s:property value="specify.child_size" />" name="child_id"  id="child_size" />
		<input type="hidden" value="<s:property value="specify.father.getId()" />" name="father_id"  id="father_id" />
		<input type="hidden" value="<s:property value="specify.leaf" />" name="leaf"  id="leaf" />
		<input type="hidden" value="<s:property value="specify.lev" />" name="lev"  id="lev" />
		<input type="button" value="提交" onclick="validate()"/>
	</form>
	
    <s:debug></s:debug>
  </body>
</html>
