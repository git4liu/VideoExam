<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>stu_paper</title>
<style type="text/css">
div{ margin:0; padding:0; overflow:hidden;}
body{ background:url(stu_paper_bg.jpg) center no-repeat ; margin:0; padding:0; background-attachment:fixed;}
html{ background:none; margin:0; padding:0;}
.head{ width:100%; height:auto; z-index:100; position:fixed; top:0;}
.head div{ margin:0 auto;}
.head .title{height:30px; background:#003366;  width:900px;}
.head .info{ height:166px; background:#993300; margin-top:4px;  width:900px;}
.info div{ float:left;}
.info div table{ border:#CCCCCC;}
.overview{ width:450px; background:#000000; height:166px; left:5px; padding:15px;}
.overview a:link{ text-decoration:none;}
.overview a:active{ text-decoration:none;}
.overview a:hover{ background:#00FF00;}
.overview a:visited{ text-decoration:none;}



.main{ width:900px; height:auto; margin:0px; margin:0 auto; padding:10px;}
.main div{ border-bottom:dashed #000000 thin; margin-top:5px;}
.tail{ width:100%; height:30px; background:#0000CC; z-index:100; position:fixed; bottom:0;}

</style>
<script type="text/javascript" src="swfobject.js"></script>
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
			return "http://localhost:8080/vex/upload/upload_2989788_13c99f57803__8000_00000000.tmp";
}

function getBasePath(){
	return "basePath from js";
}

function getExamId(){
	return "ExamId from js";
}

function getStuId(){
	return "stuId from js";
}
//-->       
</script>
</head>

<body>
<div class="head" >
	<div class="title"></div>
    <div class="info">
    	<div id="flashContent"></div>
      <div class="overview">
      	<a href="#1">1</a>
        <a href="#2">2</a>
        <a href="#3">3</a>
        <a href="#4">4</a>
        <a href="#5">5</a>
        <a href="#6">6</a>
        <a href="#7">7</a>
        <a href="#8">8</a>
        <a href="#9">9</a>
        <a href="#10">10</a>
        <a href="#11">11</a>
      </div>
    </div>
</div>
<div style="height:200px;"></div>
<div class="main">

</div>
<div class="tail">
	<button onclick="window.open('private_msssage2.html')">提交</button>
</div>
</body>
</html>
