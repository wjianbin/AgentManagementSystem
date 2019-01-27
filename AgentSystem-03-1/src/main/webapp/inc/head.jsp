<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="cn">
<head>
	<meta charset="utf-8">
	<title>代理商管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/css/public.css" rel="stylesheet"/>
	<link href="/css/main.css" rel="stylesheet"/>
	<link rel="stylesheet" id='skin' type="text/css" href="/alertframe/skin/simple_gray/ymPrompt.css" />
	<link id='theme' rel='stylesheet' href='/humane/themes/original.css'/>
	<!-- jQuery -->
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script> 
	<script type="text/javascript" src="/alertframe/ymPrompt.js"></script>
    <script type="text/javascript" src="/humane/humane.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/main.js" charset="UTF-8"></script> 
</head>
<body>
<div class="head">
<ul>
	<li><h2><!--  <img src="/imgs/logo.png" width="130px"/> --></h2></li>
	<li class="headfunc">
		<ul>
			<li>欢迎您：${user.userName}
			<a class="modifypwd" id="modifypwdbtna">
			修改密码
			</a> <a href="/outlogin">退出</a>
			</li>
		</ul>
	</li>
</ul>
</div>
<!-- <li class="m_line"><img src="/imgs/line1.gif" /></li>
			<li id="m_1" class='m_li_a' onmouseover='mover(1);'>
			<a href="/main.action">代理商管理</a></li>
 -->
        <div id="menu">
		<ul>
		<c:forEach var="fun" items="${functionName}" varStatus="st">
		
		<li class="m_line"><img src="/imgs/line1.gif" /></li>
		<li id="m_${st.index+1}" class='m_li_a' onmouseover='mover(${st.index+1});'>
		  <a href=""> ${fun.functionName}</a></li>
	   </c:forEach>
	 </ul>
	</div>
	
	<!--menu end-->
	
	<div class="subbox">
		<ul class="smenu">
		<c:forEach var="fun" items="${functionName}" varStatus="st">
			       
		          <c:if test="${st.index==0}">
					<li style="padding-left:10px;" id="s_${st.index+1 }" class='s_li_a'>
					<c:forEach var="sub" items="${subFunctions1}">
					<a href="${sub.funcUrl}">${sub.functionName }</a>
					</c:forEach></li>
					</c:if>
				 
					 <c:if test="${st.index==1}">
			       <li style="padding-left:131px;" id="s_${st.index+1 }" class='s_li' onmouseover='mover(${st.index+1 });'>
					<c:forEach var="sub" items="${subFunctions2}">
					<a href="${ sub.funcUrl}">${sub.functionName  }</a>
					 </c:forEach></li>
					</c:if>
					
					 <c:if test="${st.index==2}">
					
					<li style="padding-left:242px;" id="s_${st.index+1 }" class='s_li' onmouseover='mover(${st.index+1 });'>
					<c:forEach var="sub" items="${subFunctions3}">
					<a href="${ sub.funcUrl}">${sub.functionName  }</a>
				 </c:forEach></li>
					</c:if>
					
				   <c:if test="${st.index==3}">
				  
					<li style="padding-left:140px;" id="s_${st.index+1 }" class='s_li' onmouseover='mover(${st.index+1 });'>
					<c:forEach var="sub" items="${subFunctions4}">
					<a href="${ sub.funcUrl}">${sub.functionName  }</a>
				   </c:forEach></li>
					</c:if>
					
					 <c:if test="${st.index==4}">
					
                   <li style="padding-left:220px;" id="s_${st.index+1 }" class='s_li' onmouseover='mover(${st.index+1 });'>
					<c:forEach var="sub" items="${subFunctions5}">
				   <a href="${ sub.funcUrl}">${sub.functionName  }</a>
					</c:forEach></li>
					</c:if>
					
				
				   
				</c:forEach>
				</ul>
	</div>
	<!--subbox end-->
	
	<div id="modifydiv" class="modifydiv">
			<div class='modifTop'></div>
			<div class="modifyPasswordContent">
			<ul>
			<li>请输入原密码：<input type="password" id="oldpwdtext"/> <span id="oldpwdtip">您本次登录时的密码</span></li>
			<li>请输入新密码：<input type="password" id="newpwd"/> <span id="newpwdtip">新密码不少于6个字符</span></li>
			<li>请确认新密码：<input type="password" id="newpwd2"/> <span id="newpwdtip1">新密码不少于6个字符</span></li>
			<li class="btnli">
			<input id="modifypwdbtn" type="button" value="确认修改密码"/> 
			<input id="modifypwconcledbtn" type="button" value="取消"/> 
			</li>
			</ul>
			</div>
	</div>