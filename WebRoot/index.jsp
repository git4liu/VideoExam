<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<!--  Website template by freewebsitetemplates.com  -->
<html>

<head>
	<title>sc.chinaz.com</title>
	<base href="<%=basePath%>">
	<meta  charset="utf-8" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<!--[if IE 6]>
		<link href="css/ie6.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<!--[if IE 7]>
        <link href="css/ie7.css" rel="stylesheet" type="text/css" />  
	<![endif]-->
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
										    <li class="active" ><a href="index.html">首页</a></li>
											<li><a href="about.html">系统介绍</a></li>
											<li><a href="blog.html">通知信息</a></li>
                                            <li><a href="blog.html">相关服务</a></li>
											<li class="last" ><a href="regist.jsp">注册账号</a></li>
										</ul>
                                        
                                        
                                        <form action="private.html" class="searchform">
    
                                          <input name="search_query" class="textbox" type="text" />
                                          <input name="search" class="button" value="Search" type="submit" />
       
      									</form>
										
                                        <div class="connect">
										   <form class="searchform" action="student">
                                           <p>
                                           	<span>用户名：</span><input type="text" name="stu_name" class="textbox"/><br />
                                            </p>
                                            <p>
                                            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password"  name="stu_pswd" class="textbox"/><br /></p>
                                            <input type="submit" value="登陆"  style="margin-left:110px;" class="button"/>
										   </form>
										</div>
										
										<div class="footenote">
										  <span>&copy; Copyright &copy; 2011.</span>
										  <span><a href="index.html">Company name</a> all rights reserved</span>
										</div>
										
									</div>
									<div id="content" >
									
									    <img src="images/cotton-flower.jpg" width="726" height="546" alt="" title="">
										<div class="featured">
										      <div class="header">
											     <ul>
														<li class="first">
															<!--<p>hi.</p> -->
															<img src="images/hi.jpg" width="50" height="62" alt="" title="" >
														</li>
														<li class="last">
															<p>
																Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis diam urna, malesuada in porttitor eget, suscipit sit amet 
															</p>
														</li>
												 </ul>
											  </div>
											  <div class="body">
											    <p>
														This website template has been designed by <a href="http://sc.chinaz.com/">Free Website Templates</a> for you, for free. You can replace all this text with your own text.
												</p>
												
												<p>
														You can remove any link to our website from this <a href="http://sc.chinaz.com/">website template</a>, you're free to use this website 
												</p>
											  </div>
									    </div>
									</div>
						</div>
					 </div>
					 <div class="shadow">&nbsp;</div>
			  </div>    
	  </div>    
	</div>
<div style="display:none"></div></body>
</html>