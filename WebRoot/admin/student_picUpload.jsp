<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <title>pic_upload.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css" >
table {background:#ffcc00; border:1px; margin:0 auto; width:100%;}
</style>
<script type="text/javascript" src="admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
function upload(){
	var path = $("#path").val();
	if(path ==  ""){
		alert("您尚未选择文件！！");
		return;
	}
	$("#form1").submit();
	//alert(path);
}
//-->
</script>
  </head>
  
  <body>
<form action="student/student_picUpload" method="post" id="form1" enctype="multipart/form-data">  
	<table>
		<tr>
			<td rowspan="2"><img src="<s:property value="studentDto.picAddr"/>"  width="200px" height="150px"/></td>
			<td>图片：</td>
			<td><input type="file" id="path" /><button onclick="upload()">上传</button><font color="red">*</font></td>
		</tr>
		<tr>
			<td>网络地址：</td>
			<td><input type="text" id="web_path" /></td>
		</tr>
	</table>
</form>
  </body>
</html>
