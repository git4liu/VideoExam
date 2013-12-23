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
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
function validate(){
	var title = $("#title").val();
	alert("d");
	var content = $("#content").val();
	if(title == "" || content == ""){
		alert("请把该填的都填上！！");
		return;
	}
	$("#form1").submit();
}
//-->
</script>
  </head>
  
  <body>
  <font color="red"><b>公告修改页面</b></font>
  <br/>
  <form action="<%=basePath %>message/message_update" method="post" id="form1">
  <input type="hidden" name="mgr_id" id="mgr_id" value="<%=id %>"/>
  <input type="hidden" name="id" id="id" value="<s:property value="message.id"/>"/>
  	<table>
  		<tr><td>管理员ID</td><td><span><%=id %></span></td></tr>
  		<tr><td>标题</td><td><input type="text" name="title" id="title" value="<s:property value="message.title"/>" /></td></tr>
  		<tr><td>描述</td><td><textarea name="content" id="content" ><s:property value="message.content"/></textarea></td></tr>
  		
  	</table>
  	<button onclick="validate()">提交</button>
  </form>
	
    <s:debug></s:debug>
  </body>
</html>
