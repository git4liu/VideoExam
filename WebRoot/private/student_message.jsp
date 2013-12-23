<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Cookie [] cookies = request.getCookies();
	String name = "";
	String message_id = request.getParameter("message_id");
	for(Cookie c : cookies){
		if(c.getName().equals("student_name"))
			name = c.getValue();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>EnvisionDIV+CSS模板,DIV+CSS教程,DIV+CSS实例―站长素材-站长素材</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="images/Envision.css" type="text/css" />
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function(){
	//var url = "<%=basePath%>message/message_list?page_start=1&&page_size=6";
	$.ajax({
			type : "POST",
			url : "<%=basePath%>message/message_load?id=<%=message_id%>",
			dateType: "json", 
			success:function(data){
				//alert(data);
				$.each(data, function(i) {
					var title = data[i].title;
					var time = data[i].time;
					var id = data[i].id;
					var content = data[i].content;
					//alert(title + "\n" + time);
					$("#main").append(content);
             	});
             	
			}
			
		});
});
//-->
</script>
</head>
<body>
<div id="wrap">
  <div id="header">
    <h1 id="logo-text">envision</h1>
    <h2 id="slogan">put your site slogan here...</h2>
    <div id="header-links">
      <p> <a href="http://sc.chinaz.com">站长素材</a> | <a href="http://sc.chinaz.com">CSS专题</a> | <a href="http://sc.chinaz.com">Site Map</a> </p>
    </div>
  </div>
  <div  id="menu">
  <span>欢迎你：<%=name %></span>
  <span>2012-12-21&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16:03</span>
    <ul>
      <li><a href="http://sc.chinaz.com">首页</a></li>
      <li id="current"><a href="http://sc.chinaz.com">个人主页</a></li>
      <li class="last"><a href="http://sc.chinaz.com">个人信息</a></li>
    </ul>
  </div>
  <div id="content-wrap">
    <div id="sidebar">
      <h1>Search Box</h1>
      <form action="http://sc.chinaz.com" class="searchform">
        <p>
          <input name="search_query" class="textbox" type="text" />
          <input name="search" class="button" value="Search" type="submit" />
        </p>
      </form>
      <h1>考试相关</h1>
      <ul class="sidemenu">
        <li><a href="http://sc.chinaz.com">近期考试</a></li>
        <li><a href="#TemplateInfo">系统公告</a></li>
        <li><a href="#SampleTags">考试结果查询</a></li>
        <li><a href="http://sc.chinaz.com">我参加过的考试</a></li>
        <li><a href="http://sc.chinaz.com">我的通知</a></li>
      </ul>
      <h1>学习相关</h1>
      <ul class="sidemenu">
        <li><a href="http://sc.chinaz.com">写日记</a></li>
        <li><a href="http://sc.chinaz.com">我的习题集</a></li>
        <li><a href="http://sc.chinaz.com">试题分章练习</a></li>
        <li><a href="http://sc.chinaz.com"></a></li>
        <li><a href="http://sc.chinaz.com">Dark Eye</a></li>
      </ul>
      <h1>主页相关</h1>
      <ul class="sidemenu">
        <li><a href="http://sc.chinaz.com">我的好友</a> <br /></li>
        <li><a href="http://sc.chinaz.com"></a> <br />
          Delivering the Best Templates on the Net!</li>
        <li><a href="http://sc.chinaz.com"><strong>Fotolia</strong></a> <br />
          Free stock images or from $1</li>
        <li><a href="http://sc.chinaz.com"><strong>Text Link Ads</strong></a> <br />
          Monetized your website</li>
        <li><a href="http://sc.chinaz.com"><strong>Dreamhost</strong></a> <br />
          Premium webhosting</li>
      </ul>
      <h1>&nbsp;</h1>
    </div>
    <div id="main">
    	
    </div>
  </div>
  <div id="footer">
    <p> &copy; 2046 <strong>Your Company</strong> | Design by: <a href="http://sc.chinaz.com">站长素材</a> | Valid <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://sc.chinaz.com">站长素材</a>&nbsp;|&nbsp; <a href="http://sc.chinaz.com">Sitemap</a>&nbsp;|&nbsp; <a href="http://sc.chinaz.com">RSS Feed</a> </p>
  </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div></body>
</html>