<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>填充试卷</title>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery182.js" ></script>
<style type="text/css">
<!--
html,body{ width:100%; height:100%; padding:0; margin:0;}
.qus_contain{ width:100%; height:75%; float:left; overflow:scroll; overflow-x:auto; color:#FFFFFF;}
.qus_contain table tr{ background:#993333;}
.s_i{ width:40px; height:13px;}
.i_s{ width:40px; height:13px; background:#993300;}
.i_s:hover{ cursor:pointer; text-decoration:underline;}
.qus_contain table tr:hover{ background:#0000FF;}
.qus_contain table tr td a{ color:#ffffff; text-decoration:none;}
.qus_contain table tr td a:visited{ color:#ffffff; text-decoration:none;}
.qus_contain table tr td a:hover{ color:#ffffff; text-decoration:underline;}
.specify_contain{ width:30%; height:100%; background:#666666; color:#ffffff; float:left; overflow:scroll; overflow-x:auto; line-height:130%;}
.specify_contain a{ text-decoration:none; color:#ffffff;}
.specify_contain a:hover{ text-decoration:underline; color:#000000;}

.paper_contain{ width:100%; height:20%; background:#999999; clear:both;}
.opt_contain{ width:100%; height:5%; background:#000000; color:#FFFFFF; text-align:left;}
.opt_contain a{ text-decoration:none; color:#FFFFFF;}
.opt_contain a:visited{ text-decoration:none; color:#FFFFFF;}
.opt_contain a:hover{ text-decoration:underline; color:#FFFFFF;}

.show_detail{ width:auto; visibility:hidden; height:auto; z-index:100; position:absolute;margin:0 auto;top:30%; left:30%;}
-->
</style>
<script type="text/javascript">
<!--
function arrayToJson(o) { 
var r = []; 
if (typeof o == "string") return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\""; 
if (typeof o == "object") { 
if (!o.sort) { 
for (var i in o) 
r.push(i + ":" + arrayToJson(o[i])); 
if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) { 
r.push("toString:" + o.toString.toString()); 
} 
r = "{" + r.join() + "}"; 
} else { 
for (var i = 0; i < o.length; i++) { 
r.push(arrayToJson(o[i])); 
} 
r = "[" + r.join() + "]"; 
} 
return r; 
} 
return o.toString(); 
}

$(document).ready(function(){
 	var specify = $(".specify_contain");
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

function select_specify(obj){
	var name = $(obj).attr("name");
	var id = $(obj).attr("num");
		$.ajax({
			type : "POST",
			url : "<%=basePath %>question/choice_ajaxlist",
			dateType: "json", 
			data : "specify_id="+ id ,
			success:function(data){
			//alert(data);
				$("#qus_table").html("");
				$.each(data, function(i) {
					//alert(data[i].title);
					$("#qus_table").
							append("<tr>"
							+"<td width=\"6%\" >" + data[i].id + "</td>"
							+"<td width=\"65%\" ><a href=\"#\" onclick=\"show_detail(" + data[i].id + ")\" >" + data[i].title + "</a></td>"
							+"<td width=\"6%\" >" + data[i].answer + "</td>"
							+"<td width=\"9%\" >" + data[i].mgr_id + "</td>"
							+"<td width=\"6%\" >" + "<span  class=\"i_s\" id=\"score"+data[i].id+"\" onclick=\"changeValue(this)\">"+data[i].degree+"</span>" + "</td>"
							+"<td width=\"8%\">" + "<input  type=\"checkbox\"  name=\"qus\" value=\"" + data[i].id + "\"/>" + "</td>"
							+"</tr>");
             	});
             	
			}
			
		});
	$("#specify").html(name);
	//alert(id);
}

function show_detail(obj){
	$(".show_detail").css({ color: "#ff0011",visibility: "visible" ,background:"#aaccff"});
	var id = obj;
	$.ajax({
			type : "POST",
			url : "<%=basePath %>question/choice_load",
			dateType: "json", 
			data : "id="+ id ,
			success:function(data){
				$.each(data, function(i) {
					$("#detail_id").html(data[i].id);
					$("#detail_title").html(data[i].title);
					$("#detail_option").html(data[i].option);
					$("#detail_answer").html(data[i].answer);
					$("#detail_degree").html(data[i].degree);
					$("#remove_qus").attr("qus",data[i].id);
             	});
             	
			}
			
		});
	//alert(id);
}

function remove_qus(obj){
	var id = $(obj).attr("qus");
	var qus = $("#paper_selected" + id).attr("qus");
	var paper = $("#paper_selected" + id).attr("paper");
	var score = $("#paper_selected" + id).attr("score");
	alert("qus:" + qus + "\npaper:" + paper + "\nscore:" + score );
	if(qus == "" || paper == "" || score == "" || qus == "undefine" || paper == "undefine" || score == "undefine"){
		alert(id);
	}
	else{
		var aa = new Array();
		var jsonObj = {"paper_qus_id":qus,"qus_score":score,"paper_id":paper};
		aa.push(jsonObj);
		if(confirm("qus:" + qus + "\n" + "paper:" + paper))
			$.ajax({
				type:	"POST",
				dateType: "json", 
				url :	"<%=basePath %>paper/paper_removeQus",	
				data : "json=" + "{myjson:" + arrayToJson(aa) + "}",
				success:function (data){
					alert(data);
					$("#paper_selected" + id).remove();
				} 
			});
	}
	$("#paper_select" + id).remove();
	hide_detail();
}
function hide_detail(){
	$(".show_detail").css({ color: "#ff0011",visibility: "hidden" });
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
function do_all(obj){
	var isChecked = $(obj).attr("checked");
	if(isChecked)
		$("[name = qus]:checkbox").attr("checked", true); 
	else
	 	$("[name = qus]:checkbox").attr("checked", false);  
	
	
}

function add(){
	var ret = "";
	$("[name = qus]:checkbox").each(function() {  
         if ($(this).attr("checked")) { 
         	 var id = $(this).val();
         	 var score = $("#score" + id).html();
             ret += "<span  qus=\"" + id + "\" score=\"" + score + "\" class=\"qus_id\" id=\"paper_select" + id + "\"><a href=\"#\" onclick=\"show_detail("+id+")\" >" + id + "(" + score + ")" +"</a>|</span>";  
         }  
    });  
    $(".added_contain").append(ret);
	//alert(ret);
}

function changeValue(obj){
	var v = $(obj).html();
	var id = $(obj).attr("id");
	var edit = "<input type=\"text\" id=\""+id+"\"  class=\"s_i\" value=\"" + v + "\" onblur=\"saveValue(this)\" />";
	$(obj).replaceWith(edit);
	//alert(v);
	
}

function saveValue(obj){
	var v = $(obj).val();
	var id = $(obj).attr("id");
	var show = "<span  class=\"i_s\" id=\""+id+"\"  onclick=\"changeValue(this)\">" + v + "</span>";
	$(obj).replaceWith(show);
	//alert($(obj).attr("id"));
}



function add_paper_qus(){
	//alert("dd");
	var addArray = $(".qus_id");
	var aa = new Array();
	var paper_id = $("#paper_id").html();
	$.each(addArray,function(){
		var paper_qus_id = $(this).attr("qus");
		var qus_score = $(this).attr("score");
		var jsonObj = {"paper_qus_id":paper_qus_id,"qus_score":qus_score,"paper_id":paper_id};
		aa.push(jsonObj);
	});
	$.ajax({
			type : "POST",
			url : "<%=basePath %>paper/paper_fill",
			dateType: "json", 
			data : "json=" + "{myjson:" + arrayToJson(aa) + "}",
			success:function(data){
				alert(data);
			}
	});
	
	alert(arrayToJson(aa));
	//alert($.getJSON(aa));

}
//-->
</script>
</head>

<body>

<div style="height:100%; float:left; width:70%;">

<div class="opt_contain">
<table width="100%" align="left" >
	<tr>
        <td width="6%" >ID</td>
        <td width="60%" >标题</td>
        <td width="6%" >答案</td>
        <td width="9%" >最后操作</td>
        <td width="6%" >分数</td>
        <td width="8%"><input type="checkbox" name="opt_all"  onclick="do_all(this)" /><b><a onclick="add()" href="#">ADD</a></b></td>
    </tr>
</table>
</div>
<div class="qus_contain">
<table width="100%" align="left" id="qus_table">   
</table>
</div>

<div class="paper_contain" paper="">
<table width="100%">
    	<tr>
        	<td colspan="2"><s:property value="paper.name" />(<span id="paper_id"><s:property value="paper.id" /></span>)</td>
            <td width="72%" rowspan="4" class="added_contain">
            <s:iterator value="paper.paper_questions" var="q">
            	 <span  qus="<s:property value="#q.qus.id" />" 
            	 	paper="<s:property value="#q.paper.id"/>"
            	 	score="<s:property value="#q.qus_score" />" 
            	 	class="selected_qus_id"  
            	 	id="paper_selected<s:property value="#q.qus.id" />" >
            	 
	            	 <a href="#"  onclick="show_detail(<s:property value="#q.qus.id" />)"  >
	            	 <s:property value="#q.qus.id" />
	            	 (<s:property value="#q.qus_score" />)
	            	 </a>|
            	 </span>
            </s:iterator>
            <button onclick="add_paper_qus()">提交</button>
            </td>
      </tr>
        <tr>
        	<td width="13%">题量</td>
          <td width="15%"><s:property value="paper.qus_mount"/><span id="qus_mount"></span></td>
      </tr> <tr>
        	<td>总分</td>
            <td><span id="score"><s:property value="paper.score"/></span></td>
        </tr> <tr>
        	<td>当前类别</td>
            <td><span id="specify"></span></td>
        </tr>
    </table>
	
</div>
</div>
<div class="specify_contain"></div>
<div class="show_detail">
	<table>
		<tr>
			<td>ID</td>
			<td id="detail_id"></td>
		</tr>
		<tr>
			<td>标题</td>
			<td id="detail_title"></td>
		</tr>
		<tr>
			<td>选项</td>
			<td id="detail_option"></td>
		</tr>
		<tr>
			<td>答案</td>
			<td id="detail_answer"></td>
		</tr>
		<tr>
			<td>难度</td>
			<td id="detail_degree"></td>
		</tr>
		<tr>
			<td><button onclick="hide_detail()">确定</button></td>
			<td><button  id="remove_qus"  qus="" onclick="remove_qus(this)">移除</button></td>
		</tr>
		
	</table>
	
</div>
</body>
</html>

