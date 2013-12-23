<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String paper_id = request.getParameter("paper_id");
	String stu_id = request.getParameter("stu_id");
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath + "private/" %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>stu_paper</title>
<style type="text/css">
div{ margin:0; padding:0; overflow:hidden;}
body{ background:url(stu_paper_bg.jpg) center no-repeat ; margin:0; padding:0; background-attachment:fixed;}
html{ background:none; margin:0; padding:0;}
.head{ width:100%; height:auto; z-index:100; position:fixed; top:0;}
.head div{ margin:0 auto;}
.head .title{height:30px; background:#003366;  width:900px;}
.head .info{ height:180px; background:#993300; margin-top:4px;  width:900px;}
.overview{float:left; width:400px; height:166px; left:5px; padding:15px;}
.overview a:link{ text-decoration:none;}
.overview a:active{ text-decoration:none;}
.overview a:hover{ background:#00FF00;}
.overview a:visited{ text-decoration:none;}


.main{ width:900px; height:auto; margin:0px; margin:0 auto; padding:10px;}
.main div{ border-bottom:dashed #000000 thin; margin-top:5px;}
.tail{ width:100%; height:30px; background:#0000CC; z-index:100; position:fixed; bottom:0;}
#hiddenOverview{ visibility:hidden;}
</style>
<script type="text/javascript" src="swfobject.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js" ></script>
<script type="text/javascript">
<!--
     // For version detection, set to min. required Flash Player version, or 0 (or 0.0.0), for no version detection. 
     var swfVersionStr = "11.1.0";
     // To use express install, set to playerProductInstall.swf, otherwise the empty string. 
     var xiSwfUrlStr = "playerProductInstall.swf";
     var flashvars = {};
     var params = {};
     params.quality = "high";
     params.bgcolor = "#ffffff";
     params.allowscriptaccess = "sameDomain";
     params.allowfullscreen = "true";
     var attributes = {};
     attributes.id = "getCamera";
     attributes.name = "getCamera";
     attributes.align = "middle";
     swfobject.embedSWF(
         "getCamera.swf", "flashContent", 
         "400", "180", 
         swfVersionStr, xiSwfUrlStr, 
         flashvars, params, attributes);
     // JavaScript enabled so display the flashContent div in case it is not replaced with a swf object.
     
function getPic(){
			return "<%=basePath %>" + "<s:property value="student.picAddr"/>";
}

function getBasePath(){
	var basePath = "<%=basePath %>";
	return basePath;
}

function getExamId(){
	return "ExamId from js";
}

function getStuId(){
	return "stuId from js";
}
function exam_start(){
	if(confirm("确定要开始考试？？")){
		var examId;
		var flashContent = document.getElementById("getCamera");
		$.ajax({
			type : "POST",
			url : "<%=basePath%>exam/exam_start?paper_id=<%=paper_id %>&stu_id=<%=stu_id%>",
			success:function(data){
				alert("考试已经开始,已生成考试ID：" + data);
            	examId = data;	
				flashContent.invokeFlexExamId(examId);
				$("#hiddenOverview").css("visibility","visible");
				$("#exam_show_desc").hide();
			}
		});
	}
}
function show_detail(obj){
	var id = obj;
	$.ajax({
			type : "POST",
			url : "<%=basePath %>question/choice_load",
			dateType: "json", 
			data : "id="+ id ,
			success:function(data){
				$.each(data, function(i) {
					var title = "<div>" + data[i].title + "</div>";
					var option = "<div>" + data[i].option + "</div>";
					$(".main").append(title+ option);
             	});
             	
			}
			
		});
	alert("dd");
	//alert(id);
}
//-->       
</script>
</head>

<body>
<div class="head" >
	<div class="title"></div>
    <div class="info">
    <div style="width:450px; height:auto; float:left;">
      <div id="flashContent"></div>
    </div>
      <div class="overview">
      	<div id="hiddenOverview">
      		<s:iterator value="paper.paper_questions" var="q">
            	 <span  qus="<s:property value="#q.qus.id" />" 
            	 	paper="<s:property value="#q.paper.id"/>"
            	 	score="<s:property value="#q.qus_score" />" 
            	 	class="selected_qus_id"  
            	 	id="paper_selected<s:property value="#q.qus.id" />" >
            	 
	            	 <a  onclick="show_detail(<s:property value="#q.qus.id" />)"  >
	            	 <s:property value="#q.qus.id" />
	            	 (<s:property value="#q.qus_score" />)
	            	 </a>|
            	 </span>
            </s:iterator>
      	</div>
      </div>
    </div>
</div>
<div style="height:200px;"></div>
<div class="main">
<table id="exam_show_desc">
	<tr>
		<td>当前考生为：</td>
		<td><s:property value="student.name" /></td>
	</tr>
	<tr>
		<td>考试名称：</td>
		<td><s:property value="paper.name" /></td>
	</tr>
	<tr>
		<td>题量</td>
		<td><s:property value="paper.qus_mount" /></td>
	</tr>
	<tr>
		<td>总分</td>
		<td><s:property value="paper.score" /></td>
	</tr>
	<tr>
		<td>难度</td>
		<td><s:property value="paper.degree" /></td>
	</tr>
	<tr>
		<td>时间</td>
		<td><s:property value="paper.time" /></td>
	</tr>
	<tr>
		<td>描述</td>
		<td><s:property value="paper.desc" /></td>
	</tr>
	<tr>
		<td><button onclick="exam_start()">开始考试</button></td>
	</tr>
</table>

</div>
<div class="tail">
	<button onclick="window.open('private_msssage2.html')">提交</button>
</div>
</body>
</html>
