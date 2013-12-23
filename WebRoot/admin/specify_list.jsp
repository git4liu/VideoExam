<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vex.videoexam.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Manager manager = (Manager)session.getAttribute("manager");
	if(manager == null)
		response.sendRedirect(basePath + "admin/fail.jsp");
 %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
   
<style>
<!--
html,body{margin:0; padding:0;}
img a{border:none;}
a{text-decoration:none;}
a:link{color:#ffffff;}
a:visited{color:#ffffff;}
a:active{color:#ffffff;}
a:hover{color:#ffffff; text-decoration:underline;}
.tr:hover{ background:#aa33ff;}
.tr{color:#ffffff;}
.tr .td:hover{ background:#336699;}
.tr .td span:hover{text-decoration:underline; cursor:pointer;}
#opt{ width:100%; background:#666633; position:fixed; bottom:0;}
#opt table tr td{ text-align:left;}


.table{ width:100%; height:auto; text-align:center; padding-top:30px; color:#FFFFFF;}
.tr{ width:100%; height:25px;margin-top:2px;}
.th{ width:100%; height:25px; z-index:100; position:fixed; top:0px; color:#FFFFFF; text-align:center;}
.tr div{ height:25px; margin-right:2px; background:#666666; float:left; line-height:25px;}
.th div{ height:25px; background:#000000; margin-right:2px; float:left; line-height:25px;}
.td_name{ width:40%; }
.td_id{ width:30px;}
.td_mount{ width:70px;}
.td_mgr{ width:100px; }
.td_del{ width:70px;}
.td_del span:hover{ text-decoration:underline;cursor:pointer; }
.td_updt{ width:70px;}
.td_adsb{ width:140px;}
-->
</style>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
function del(obj){
	if(confirm("删除知识点，会将子知识点全部删除，您确定要这么做吗？"))
		$.ajax({
			type : "POST",
			url : "<%=basePath %>specify/specify_delete",
			data : "id="+ obj,
			success:function(msg){
					alert(msg);
					location.reload();
			}
		});
}

function add_sub(obj){
	var id = $(obj).attr("id");
	var name = $(obj).attr("name");
	//alert(id + "--" + name);
	$("#spanfatherid").html(id);
	$("#inputfatherid").val(id);
	$("#sfn").html(name);
	//alert($("#sfn").attr("id"));
	
}

function submit_add(){
	var add_name = $("#add_name").val();
	var add_desc = $("#add_desc").val();
	if(add_name == "" || add_desc == ""){
		alert("类别名称或者类别描述不能为空！！");
		return false;
	}
	$("#form1").submit();
}

function show_sub(obj){

	var h = $("<div></div>").append($("#img" + obj).clone()).html();
	//alert(h);
	h = h.replace("onclick=\"show_sub("+obj+")\"","onclick=\"hide_sub("+obj+")\"");
	h = h.replace("onclick=show_sub("+obj+")","onclick=hide_sub("+obj+")");
	h = h.replace("onclick='show_sub("+obj+")'","onclick='hide_sub("+obj+")'");
	h = h.replace("unfold.png","fold.png");
	$("#img" + obj).replaceWith(h);
	
	$.ajax({
			type : "POST",
			url : "<%=basePath %>specify/specify_ajaxlist",
			dateType: "json", 
			data : "father_id="+ obj ,
			success:function(data){
				$("#tr" + obj).after("<div id=\"div" + obj + "\"></div>");
				//alert("ok");
				$.each(data, function(i) {
					//alert(data);
					//alert(data[i].mgr_id);
					//alert(data[i].id + "--" + data[i].name);
					var lev = data[i].lev;
					var pic = "<img id=\"img" + data[i].id + "\" src=\"<%=basePath %>admin/images/unfold.png \" onclick=\"show_sub(" + data[i].id + ")\" style=\"margin-left:"+data[i].lev * 15+"px;\"/>";
					if(data[i].leaf=="Y")
						pic = "<img id=\"img" + data[i].id + "\"  src=\"<%=basePath %>admin/images/fold.png \" style=\"margin-left:"+data[i].lev * 15+"px;\" />";
					
					$("#div" + obj).
							append("<div class=\"tr\" id=\"tr" + data[i].id + "\">"
							+"<div class=\"td_name\" style=\"text-align:left;\">"+pic+"<a href=\"#\" title=\""+data[i].desc+"\" >"+data[i].name+"</a></div>" 
							+"<div class=\"td_id\">"+data[i].id+"</div>" 
							+"<div class=\"td_mount\">"+data[i].child_size+"</div>" 
							+"<div class=\"td_mgr\">"+data[i].mgr_id+"</div>" 
							+"<div class=\"td_del\">"+"<span onclick='del("+data[i].id+")'>删除</span>"+"</div>" 
							+" <div class=\"td_updt\">"+"<span><a href='specify_show?id="+data[i].name+"'>修改</a></span>"+"</div>" 
							+"<div class=\"td_adsb\">"+"<a href=\"#\" onclick='add_sub(this)' id='" + data[i].id + "' name='"+ data[i].name + "'>添加子类别</a></span>"+"</div>" 
							+"</div>");
    
             	});
             	
			}
			
		});
		
}

function hide_sub(obj){
	var h = $("<div></div>").append($("#img" + obj).clone()).html();
	h = h.replace("onclick=\"hide_sub("+obj+")\"","onclick=\"show_sub("+obj+")\"");
	h = h.replace("onclick=hide_sub("+obj+")","onclick=show_sub("+obj+")");
	h = h.replace("onclick='hide_sub("+obj+")'","onclick='show_sub("+obj+")'");
	h = h.replace("fold.png","unfold.png");
	$("#img" + obj).replaceWith(h);
	$("#div" + obj).hide();
}
//-->
</script>
  </head>
  
  <body>
  
  
  
  <div class="th">
    	<div class="td_name">知识点名称</div>
        <div class="td_id">id</div>
        <div class="td_mount">子类数量</div>
        <div class="td_mgr">最后修改</div>
        <div class="td_del" style="width:284px;">操作 </div>
    </div>
<div class="table">
<s:iterator value="specifies" var="specify" status="status">
	<div class="tr" id='tr<s:property value="#specify.getId()"/>'>
    	<div class="td_name" style="text-align:left;">
<s:if test="#specify.getLeaf() == 'Y'">
    <img src="<%=basePath %>admin/images/fold.png"  id='img<s:property value="#specify.getId()"/>' />
</s:if>
<s:elseif test="#specify.getLeaf() == 'N'">
    <img src="<%=basePath %>admin/images/unfold.png" onclick='show_sub(<s:property value="#specify.getId()"/>)' id='img<s:property value="#specify.getId()"/>'  />
</s:elseif>  		
  		<a href="#" title="<s:property value="#specify.getDesc()"/>"><s:property value="#specify.getName()"/></a>
  		</div>
        <div class="td_id"><s:property value="#specify.getId()"/></div>
        <div class="td_mount"><s:property value="#specify.getChild_size()"/></div>
        <div class="td_mgr"><s:property value="#specify.getMgr_id()"/></div>
        <div class="td_del"><span onclick='del(<s:property value="#specify.getId()"/>)'>删除</span></div>
        <div class="td_updt"><span><a href='specify_show?id=<s:property value="#specify.getId()"/>'>修改</a></span></div>
        <div class="td_adsb"><span><a href="#" onclick='add_sub(this)' id='<s:property value="#specify.getId()"/>' name='<s:property value="#specify.getName()"/>'>添加子类别</a></span></div>
    </div>
</s:iterator>
</div>  
  
  <div id="opt">
<form action="<%=basePath %>specify/specify_add" method="post" id="form1">
	<input type="hidden" name="father_id" value="1" class="father_id" id="inputfatherid"/>
	<input type="hidden" name="mgr_id" value="<%=manager.getId() %>"/>
  	<table width="100%">
  		<tr>
  			<td width="100">父类：</td>
  			<td><span id="spanfatherid">1</span>（<span id="sfn">顶级类别</span>）</td>
  		</tr>
  		<tr>
  			<td>知识点名</td>
  			<td><input type="text" name="name" id="add_name"/></td>
  		</tr>
  		<tr>
  			<td>简要描述</td>
  			<td><textarea cols="100" rows="6" name="desc" id="add_desc"></textarea></td>
  		</tr>
  	</table>
  	<input type="button" value="提交"  onclick="submit_add()"/>
</form><button onclick='add_sub(this)' id="1" name="顶级类别" >添加顶级类别</button>
  </div>
 
  </body>
</html>
