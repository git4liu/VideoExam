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
function del(obj){
	if(confirm("您确定要删除此管理员吗？"))
		$.ajax({
			type : "POST",
			url : "<%=basePath %>manager/manager_delete",
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
  	<td>用户名</td>
  	<td>id</td>
  	<td>密码</td>
  	<td>级别</td>
  	<td colspan="2">操作</td>
  </tr>
   <s:iterator value="managers" var="manager" status="status">
  	<tr  class="list">
  		<td><s:property value="#manager.getName()"/></td>
  		<td><s:property value="#manager.getId()"/></td>
  		<td><s:property value="#manager.getPswd()"/></td>
  		<td><s:property value="#manager.getCategory()"/></td>
  		<td><span onclick='del(<s:property value="#manager.getId()"/>)'>删除</span></td>
  		<td><span><a href='manager_show?id=<s:property value="#manager.getId()"/>'>修改</a></span></td>
  	</tr>
  	</s:iterator>

  </table>
  
			 <br />
	
    <s:debug></s:debug>
  </body>
</html>
