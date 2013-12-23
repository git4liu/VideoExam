<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Cookie [] cookies = request.getCookies();
	String name = "";
	String stu_id = "";
	String message_id = request.getParameter("paper_id");
	if(cookies == null)
		return;
	for(Cookie c : cookies){
		if(c.getName().equals("student_name"))
			name = c.getValue();
		if(c.getName().equals("student_id"))
			stu_id = c.getValue();
	}
	String page_start = request.getParameter("page_start");
	String page_size = request.getParameter("page_size");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="<%=basePath + "private/" %>images/Envision.css" type="text/css" />
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function(){
function setSelect(obj){
	var page_start = obj.page_start;
	var page_size = obj.page_size;
	var total = obj.total;
	$("#total").html(total);
	var totalPages=(total % page_size == 0)?(total / page_size):(total / page_size+1);
	if (totalPages >= 0){
        totalPages = Math.floor(totalPages); //返回值为小于等于其数值参数的最大整数值。
    }
    else{
        totalPages = Math.ceil(totalPages); //返回值为大于等于其数字参数的最小整数。
    }
	
	if(total < page_size ){
		totalPages = 1;
	}
	var index = 0;
	for(index = 1 ; index <= totalPages ; index ++) {
		var option = "<option value=" + index + ">" + index +"</option>";
		if(index == page_start)
			option = "<option value=" + index + " selected >" + index +"</option>";
		$("#page_start").append(option);
	//alert(option);
	} 
	//alert(totalPages);
	/*var a = 15;
	var b = 7;
	var c = 7 % 15;
	alert(c);*/
	//alert(total + "\n" + page_size + "\n" + totalPages);
	$("#page_size" + page_size).attr("selected" , true);
}
	$.ajax({
			type : "POST",
			url : "<%=basePath%>paper/paper_ajaxlist?page_start=<%=page_start %>&page_size=<%=page_size %>",
			dateType: "json", 
			success:function(data){
				setSelect(data[0]);
				//alert(data);
				//var page_start = data[0].page_start;
				//var page_size = data[0].page_size;
				//var total = data[0].total;
				//alert(page_start + "\n" + page_size + "\n" + total);
				$.each(data, function(i) {
					if(i == 0)
						return true;
					var title = data[i].name;
					var time = data[i].time;
					var id = data[i].id;
					//alert(title + "\n" + time);
					$("#paper").append("<li><a href=\"<%=basePath %>exam/exam_show?paper_id=" + id + "&stu_id=<%=stu_id %>\" title=\"" + time +  "\">" + title +"</a></li>");
             	});
             	
			}
			
		});
});
function refresh(){
	var page_start = $("#page_start").val();
	var page_size = $("#page_size").val();
	window.open("<%=basePath + "private"%>/paper_list.jsp?page_start=" + page_start + "&&page_size=" + page_size ,"_self");
	//alert("refresh");
	//alert(page_start + "\n" + page_size);
}
//-->
</script>
</head>
<body>
<div id="wrap">
  <div id="header">
    <h1 id="logo-text">VEX个人主页</h1>
    <h2 id="slogan">您好：<%=name %></h2>
    <div id="header-links">
      <p> <a href="http://sc.chinaz.com">站长素材</a> | <a href="http://sc.chinaz.com">CSS专题</a> | <a href="http://sc.chinaz.com">Site Map</a> </p>
    </div>
  </div>
  <div  id="menu">
    <ul>
      <li><a href="index.html">首页</a></li>
      <li id="current"><a href="private.html">个人主页</a></li>
      <li class="last"><a href="private_info.html">个人信息</a></li>
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
      <h1>近期考试</h1>
      <ul id="paper">
        
      </ul>
       <table>
  	<tr>
  		<td>一共<span id="total"></span>条记录</td>
  		<td>当前第
  			<select name="page_start" id="page_start"  onchange="refresh()">
  			</select>
  			页
  		</td>
  		<td>
	  		每页显示
	  		<select name="page_size" id="page_size" onchange="refresh()">
	  			<option value="15" id="page_size15">15</option>
	  			<option value="50" id="page_size50">50</option>
	  			<option value="100" id="page_size100">100</option>
  			</select>
	  		条
  		</td>
  	</tr>
  </table>
      
      <br />
    </div>
  </div>
  <div id="footer">
    <p> &copy; 2046 <strong>Your Company</strong> | Design by: <a href="http://sc.chinaz.com">站长素材</a> | Valid <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://sc.chinaz.com">站长素材</a>&nbsp;|&nbsp; <a href="http://sc.chinaz.com">Sitemap</a>&nbsp;|&nbsp; <a href="http://sc.chinaz.com">RSS Feed</a> </p>
  </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div></body>
</html>
