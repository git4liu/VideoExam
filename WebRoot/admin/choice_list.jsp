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
	if(confirm("您确定要删除此试题吗？"))
		$.ajax({
			type : "POST",
			url : "<%=basePath %>question/choice_delete",
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
  	<td>id</td>
  	<td>试题类别</td>
  	<td>难度界别</td>
  	<td>答案</td>
  	<td>最后操作</td>
  	<td colspan="2">操作</td>
  </tr>
   <s:iterator value="choices" var="choice" status="status">
  	<tr  class="list">
  		<td><span><a href='choice_show?id=<s:property value="#choice.getId()"/>'><s:property value="#choice.getTitle()"/></a></span></td>
  		<td><s:property value="#choice.getId()"/></td>
  		<td><s:property value="#choice.getCategory()"/></td>
  		<td><s:property value="#choice.getDegree()"/></td>
  		<td><s:property value="#choice.getAnswer()"/></td>
  		<td><s:property value="#choice.getMgr_id()"/></td>
  		<td><span onclick='del(<s:property value="#choice.getId()"/>)'>删除</span></td>
  		<td><span><a href='choice_show?id=<s:property value="#choice.getId()"/>'>修改</a></span></td>
  	</tr>
  	</s:iterator>

  </table>
  
			 <br />
	
    <s:debug></s:debug>
  </body>
</html>
