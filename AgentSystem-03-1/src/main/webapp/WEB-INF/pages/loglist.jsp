<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
<div class="mbxnav">
	 账号：${user.userCode }LOG 操作日志
</div> 
<div class="container">
<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="/loglist.action" method="post">
	    <input type="hidden" id="usercode" name="userCode" value="">
	    <input type="hidden" id="userid" name="userId" value="">
		操作时间：
		<input class="Wdate" size="15" name="logs.operateDatetime" value="" />
		<input type="submit" value="查询"/>
		</form>
		</li>
	</ul>
</div>

 <table>
  <thead>
	  <tr>
		  <th>登陆账户</th>
		  <th>操作信息</th>
		  <th>操作时间</th>                                        
	  </tr>
  </thead>   
  <tbody>
	<c:if test="page.items!=null">
		<c:forEach var="logs" items="${page.items}" varStatus="adIndex">
	    <tr>
			<td>${logs.userName}</td>
			<td>${logs.operateInfo}</td>
			<td class="center">${logs.operateDatetime}</td>
			
		</tr>
	</c:forEach>
	</c:if>
</tbody>
</table>

<%-- <div class="pagination pagination-centered">
		  <ul>
			<li><a href="/loglist.action?page.page=1&user.id=<s:property value='user.id'/>&user.userCode=<s:property value='user.userCode'/>&logs.operateDatetime=<s:date name='logs.operateDatetime' format='yyyy-MM-dd'/>" title="首页">首页</a></li>
			<s:if test="page.prevPages!=null">
				<s:iterator value="page.prevPages" var="num">
					<li><a
						href="/loglist.action?page.page=${num}&user.id=<s:property value='user.id'/>&user.userCode=<s:property value='user.userCode'/>&logs.operateDatetime=<s:date name='logs.operateDatetime' format='yyyy-MM-dd'/>"
						class="number" title="<s:property value='#num'/>"><s:property
							value="#num" /> </a></li>
				</s:iterator>
			</s:if>
			<li class="active">
			  <a href="#"title="<s:property value='page.page'/>"><s:property value='page.page' /> </a>
			</li>
			<s:if test="page.nextPages!=null">
				<s:iterator value="page.nextPages" var="num">
					<li><a href="/loglist.action?page.page=${num }&user.id=<s:property value='user.id'/>&user.userCode=<s:property value='user.userCode'/>&logs.operateDatetime=<s:date name='logs.operateDatetime' format='yyyy-MM-dd'/>" title="<s:property value='#num'/>">
					<s:property value="#num" /> </a></li>
				</s:iterator>
			</s:if>
			<li><a href="/loglist.action?page.page=${page.pageCount}&user.id=<s:property value='user.id'/>&user.userCode=<s:property value='user.userCode'/>&logs.operateDatetime=<s:date name='logs.operateDatetime' format='yyyy-MM-dd'/>" title="尾页">尾页</a></li>
		  </ul>
</div> --%>
</div>
<link id='theme' rel='stylesheet' href='/css/loglist.css'/>
<script type="text/javascript" src="/medire/WdatePicker.js"></script>
</body>
</html>