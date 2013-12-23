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
function validate(){
	var name = $("#name").val();
	var desc = $("#desc").val();
	var mgr_id = $("#mgr_id").val();
	var degree = $("#degree").val();
	if(name == "" || desc == "" || mgr_id == "" || degree == ""){
		alert("请把该填的都填上！！");
		return;
	}

	$("#form1").submit();
}
//-->
</script>
  </head>
  
  <body>
  <font color="red"><b>试卷修改页面</b></font>
  <br/>
  <form action="<%=basePath %>paper/paper_update" method="post" id="form1">
  <input type="hidden" name="mgr_id" id="mgr_id" value="<%=id %>"/>
  <input type="hidden" name="qus_mount" id="qus_mount" value="<s:property value="paper.qus_mount"/>"/>
  <input type="hidden" name="id" id="mgr_id" value="<s:property value="paper.id"/>"/>
  <input type="hidden" name="score" id="mgr_id" value="<s:property value="paper.score"/>"/>
  	<table>
  		<tr><td>管理员ID</td><td><span><%=id %></span></td></tr>
  		<tr><td>标题</td><td><input type="text" name="name" id="name" value="<s:property value="paper.name"/>" /></td></tr>
  		<tr><td>描述</td><td><textarea name="desc" id="desc" ><s:property value="paper.desc"/></textarea></td></tr>
  		<tr><td>难度</td><td>
  			<select name="degree" id="degree">
  				<option value="1" <s:if test="paper.degree == '1'">selected</s:if>>1</option>
  				<option value="2" <s:if test="paper.degree == '2'">selected</s:if>>2</option>
  				<option value="3" <s:if test="paper.degree == '3'">selected</s:if>>3</option>
  			</select>
  		</td></tr>
  	</table>
  	<button onclick="validate()">提交</button>
  </form>
	
    <s:debug></s:debug>
  </body>
</html>
