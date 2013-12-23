<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vex.videoexam.model.*" %>
<%@ page import="com.vex.videoexam.service.*" %>
<%@ page import="com.vex.videoexam.service.impl.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Manager manager = (Manager) session.getAttribute("manager");
	/*
	SpecifyService specifyService = new SpecifyServiceImpl();
	List<Specify> specifies = new ArrayList<Specify> ();
	specifies = specifyService.child(1);
	*/
	if(manager == null)
		response.sendRedirect("fail.jsp");
	int id = manager.getId();
 %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<style>
<!--
html, body{ height:100%;}
a{ text-decoration:none; color:#FFFFFF;}
a:hover{ text-decoration:underline; color:#000000;}
.specify_select{ top:0; right:0; width:400px; height:100%; z-index:100; position:fixed; background:#666666; color:#ffffff;}
.tr{ width:100%; height:25px;margin-top:2px;}
.td_name{ width:40%; }
.td_id{ width:30px;}
.td_mount{ width:70px;}
.td_mgr{ width:100px; }
-->
</style>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function(){
 	var specify = $(".specify_select");
 	$.ajax({
			type : "POST",
			url : "<%=basePath %>specify/specify_ajaxlist",
			dateType: "json", 
			data : "father_id=1",
			success:function(data){
				//specify.after("<div id=\"div" + obj + "\"></div>");
				$.each(data, function(i) {
					var lev = data[i].lev;
					var pic = "<img id=\"img" + data[i].id + "\" src=\"<%=basePath %>admin/images/unfold.png \" onclick=\"show_sub(" + data[i].id + ")\" style=\"margin-left:"+data[i].lev * 15+"px;\"/>";
					if(data[i].leaf=="Y")
						pic = "<img id=\"img" + data[i].id + "\"  src=\"<%=basePath %>admin/images/fold.png \" style=\"margin-left:"+data[i].lev * 15+"px;\" />";
					
					specify.
							append("<div class=\"tr\" id=\"tr" + data[i].id + "\">"
							+pic+"<a href=\"#\" name=\""+data[i].name+"\" num=\""+data[i].id+"\" title=\""+data[i].desc+"\" onclick=\"select_specify(this)\">"+data[i].name+"</a>"
							+"</div>");
    
             	});
             	
			}
			
		});
});

function show_sub(obj){

	var h = $("<div></div>").append($("#img" + obj).clone()).html();
	
	//替换图片绑定的事件函数，替换图片地址
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
				$.each(data, function(i) {
					var lev = data[i].lev;
					var pic = "<img id=\"img" + data[i].id + "\" src=\"<%=basePath %>admin/images/unfold.png \" onclick=\"show_sub(" + data[i].id + ")\" style=\"margin-left:"+data[i].lev * 15+"px;\"/>";
					if(data[i].leaf=="Y")
						pic = "<img id=\"img" + data[i].id + "\"  src=\"<%=basePath %>admin/images/fold.png \" style=\"margin-left:"+data[i].lev * 15+"px;\" />";
					
					$("#div" + obj).
							append("<div class=\"tr\" id=\"tr" + data[i].id + "\">"
							+pic+"<a href=\"#\" name=\""+data[i].name+"\" num=\""+data[i].id+"\" title=\""+data[i].desc+"\" onclick=\"select_specify(this)\">"+data[i].name+"</a>"
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
function validate(){
	//alert("ddfdf");
	var mgr_id = $("#mgr_id").val();
	var title = $("#title").val();
	var specify_id = $("#specify_id").val();
	var analys = $("#analys").val();
	var degree = $("#degree").val();
	var category = $("#category").val();
	var option = $("#option").val();
	var answer = "";
    $("input[name=answer]").each(function() {  
         if ($(this).attr("checked")) {  
             answer += $(this).val();  
         }  
    });  
	if(		mgr_id == 0 
			|| mgr_id == "" 
			|| title == "" 
			|| specify_id == ""
			|| specify_id == 0
			|| analys == ""
			|| degree == ""
			|| answer == ""
			|| option == "")
	{
		alert("请不要留有空白！！");	
		return ;
	}
	/*
	alert(
		"--mgr_id" +
		mgr_id + "-- title" +
		title + "-- specify_id" + 
		specify_id + "-- answer" + 
		answer + "-- analys" + 
		analys + "-- degree" + 
		degree + "-- ctegory" + 
		category
		);
	*/
	if(confirm("您确定要修改？\n管理员:"+mgr_id+"\n标题："+title+"\n知识点："+specify_id+"\n答案："+answer))
	$("#form1").submit();
}
function select_specify(obj){
	var name = $(obj).attr("name");
	var id = $(obj).attr("num");
	alert(name + " -- " + id);
	$("#specify_name").html(name);
	$("#s_id").html(id);
	$("#specify_id").val(id);
	
}
//-->
</script>
  </head>
  
  <body>
<font color="red"><b>选择题修改页面</b></font>

  <div class="specify_select">
  
  
  
  
  
	<%--<%
		for(Specify specify : specifies){
			%>
			<div class="tr" id="tr<%=specify.getId() %>" style="padding-left: <%=specify.getLev() %>px;" >
				<%
					if(specify.getLeaf() == 'Y'){
						%>
							<img src="images/unfold.png"/>
						<%}%>
							<img src="images/fold.png" id="img<%=specify.getId() %>" onclick="show_sub(<%=specify.getId() %>)"/>
						<%
						
				
				%>
			</div>
			<% 
		}
	%>
--%>
</div>


  <form action="<%=basePath %>question/choice_update" method="post" id="form1">
  <input type="hidden" value="<%=id %>" name="mgr_id" id="mgr_id"/>
  <input type="hidden" value="<s:property value="choice.getId()" />" name="id" id="id" />
  <input type="hidden" value="<s:property value="choice.getCategory()" />" name="category" id="category"/>
  <input type="hidden" value="<s:property value="choice.getSpecify().getId()" />" name="specify_id" id="specify_id"/>
  
  <table>
  	<tr><td>试题类型：</td><td><span>选择题</span></td></tr>
  	<tr><td>知识点：</td><td><span id="specify_name"><s:property value="choice.getSpecify().getName()" /></span><span id="s_id"></span></td></tr>
  	<tr><td>标题：</td><td><textarea name="title" id="title"><s:property value="choice.getTitle()" /></textarea></td></tr>
  	<tr><td>选项：</td><td><textarea name="option" id="option"><s:property value="choice.getOption()" /></textarea></td></tr>
  	<tr>
  		<td>答案：</td>
  		<td>
  			A<input type="checkbox" value="A" name="answer" <s:if test="choice.getAnswer().contains(\"A\")">checked</s:if> />
  			B<input type="checkbox" value="B" name="answer" <s:if test="choice.getAnswer().contains(\"B\")">checked</s:if> />
  			C<input type="checkbox" value="C" name="answer" <s:if test="choice.getAnswer().contains(\"C\")">checked</s:if> />
  			D<input type="checkbox" value="D" name="answer" <s:if test="choice.getAnswer().contains(\"C\")">checked</s:if> />
  			E<input type="checkbox" value="E" name="answer" <s:if test="choice.getAnswer().contains(\"D\")">checked</s:if> />
  			F<input type="checkbox" value="F" name="answer" <s:if test="choice.getAnswer().contains(\"E\")">checked</s:if> />
  			G<input type="checkbox" value="G" name="answer" <s:if test="choice.getAnswer().contains(\"F\")">checked</s:if> />
  		</td>
  	</tr>
  	<tr>
  		<td>难度：</td>
	  	<td>
	  		<select name="degree" id="degree">
	  			<option value="1" <s:if test="choice.Degree()=='1'">selected</s:if>>1</option>
	  			<option value="2" <s:if test="choice.Degree()=='2'">selected</s:if>>2</option>
	  			<option value="3" <s:if test="choice.Degree()=='3'">selected</s:if>>3</option>
	  			<option value="4" <s:if test="choice.Degree()=='4'">selected</s:if>>4</option>
	  		</select>
	  	</td>
  	</tr>
  	<tr><td>分析或备注：</td><td><textarea name="analys" id="analys"><s:property value="choice.getAnalys()" /></textarea></td></tr>
  </table>
  <button onclick="validate()">提交</button>
	</form>
	

    <s:debug></s:debug>
  </body>
</html>
