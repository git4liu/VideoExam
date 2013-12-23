<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<!--  Website template by freewebsitetemplates.com  -->
<html>

<head>
	<title>注册账号</title>
	<meta  charset="utf-8" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<!--[if IE 6]>
		<link href="css/ie6.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<!--[if IE 7]>
        <link href="css/ie7.css" rel="stylesheet" type="text/css" />  
	<![endif]-->
<style type="text/css">
<!--
.registe_form{ width:100%; height:500px;}
.registe_form table {background:#ffcc00; border:1px; margin:0 auto;}
-->
</style>
<script type="text/javascript" src="admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
function exist(){
	var name = $("#name").val();
	$.ajax({
			type : "POST",
			url : "<%=basePath %>" + "student/student_exists",
			data : "name="+ name,
			success:function(msg){
			//alert(msg);
				if(msg == "no")
					$("#show_exist").html("<font color='#009933'>该用户名未被注册，可以使用</font>");
				else
					$("#show_exist").html("<font color='#FF0000'>该用户名已经被注册，不可以使用！！</font>");
			}
		});
}
function validate(){
	var name = $("#name").val();
	var pswd = $("#pswd").val();
	var pswd_range = $("#pswd_range").val();
	var mail = $("#mail").val();
	var picAddr = $("#picAddr").val();
	if(name == "" || pswd == "" || pswd_range == "" || picAddr == ""){
		alert("请填写必要的信息");
		return;
	}
	if(!( pswd == pswd_range )){
		alert("两次输入密码不一致");
		return;
	}
	$("#form1").submit();
	//alert("name:" + name + "\npswd:" + pswd + "\npswd_range:" + pswd_range + "\nmail:" + mail) ;	
}

//function browseFolder() {
//    try {
//        var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息
//        var Shell = new ActiveXObject("Shell.Application");
//        //var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
//        var Folder = Shell.BrowseForFolder(0, Message, 0); //起始目录为：桌面
//        if (Folder != null) {
//            Folder = Folder.items(); // 返回 FolderItems 对象
//            Folder = Folder.item(); // 返回 Folderitem 对象
//            Folder = Folder.Path; // 返回路径
//            if (Folder.charAt(Folder.length - 1) != "\\") {
//                Folder = Folder + "\\";
//            }
//            $("#path").value = Folder;
//            return Folder;
//        }
//    }
//    catch (e) {
//        alert(e.message);
//    }
//}


//-->
</script>
</head>

<body>

	  <div id="background">
			  <div id="page">
			  
					 <div class="header">
						<div class="footer">
							<div class="body">
									<div id="sidebar">
									    <a href="index.html"><img id="logo" src="images/logo.gif" width="154" height="74" alt="" title=""/></a>
										
										<ul class="navigation">
										    <li><a  href="index.html">首页</a></li>
											<li ><a href="about.html" >系统介绍</a></li>
											<li><a href="blog.html">通知信息</a></li>
                                            <li><a href="blog.html">相关服务</a></li>
											<li class="active last"><a href="contact.html">注册账号</a></li>
										</ul>
										
										 <form action="private.html" class="searchform">
    
                                          <input name="search_query" class="textbox" type="text" />
                                          <input name="search" class="button" value="Search" type="submit" />
       
      									</form>
										
                                        <div class="connect">
										  <form class="searchform" method="post" action="student/student_logIn">
                                           <p>
                                           	<span>用户名：</span><input type="text" name="name" class="textbox"/><br />
                                            </p>
                                            <p>
                                            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password"  name="pswd" class="textbox"/><br /></p>
                                            <input type="submit" value="登陆"  style="margin-left:110px;" class="button"/>
										   </form>
										</div>
										
										<div class="footenote">
										  <span>&copy; Copyright &copy; 2011.</span>
										  <span><a href="index.html">Company name</a> all rights reserved</span>
										</div>
										
									</div>
									<div id="content">
									          <div class="content">
											     <div class="registe_form" style="overflow:scrool;">
<form action="student/student_add" method="POST" id="form1">

	<table>
		<tr>
			
			<td>用户名：</td>
			<td><input type="text" name="name" id="name" onblur="exist()"><font color="red">*</font><span id="show_exist">用户名不可以重复，请好好想个名字。。</span></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="pswd" id="pswd"><font color="red">*</font></td>
		</tr>
		<tr>
			<td>密码确认：</td>
			<td><input type="password" name="pswd_range" id="pswd_range"><font color="red">*</font></td>
		</tr>
		<tr>
			<td>图片地址：</td>
			<td><input type="text" name="picAddr" id="picAddr"><font color="red">*</font></td>
		</tr>
		<tr>
			<td>邮箱：</td>
			<td><input type="text" name="mail" id="mail"></td>
		</tr>
	</table>
</form>	

<div style="text-align:center;">
		<ul>
			<li>带有红色*的为必填</li>
			<li>请尽量上传200*150分辨率的照片，以免考试过程中识别错误</li>
			<li>注册前请认真阅读<a href="#" onclick='alert("去你丫的！！")' >用户须知</a></li>
			<li>提供邮箱可以帮助我们更方便的练习您，希望您填上</li>
		</ul>
	<button style="position:; left:0px;" onclick="validate()">提交</button>
</div>											     </div>
<iframe src="pic_upload.html" width=100% height="200px"></iframe>
										     </div>
									</div>
							</div>
						</div>
					 </div>
					 <div class="shadow">
					 </div>
			  </div>    
	  </div>    
	
</body>
</html>