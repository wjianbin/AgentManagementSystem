<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/myportalmanage.action">门户管理</a> \ <a href="/myportalmanage.action">门户管理</a>
</div>
<div class="container">

<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="myportalmanage.action" method="post">
		关键词：<input type="text" name="keywords" value="" />
		客户名称:<input type="text" name="customName" value=""/>
		<input type="submit" value="查询"/>
		</form>
		</li>
	</ul>
</div>


 <table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>门户名称</th>
		  <th>客户名称</th>
		  <th>法人代表</th>
		  <th>代理商</th>
		  <th>注册日期</th>
		  <th>类型</th>
		  <th>状态</th>
		  <th>操作</th>
	  </tr>
  </thead>   
  <tbody>
  
	 <c:forEach items="${Customspage.records}" var="keyword" varStatus="adIndex">
		
		<tr class="tabletr">
			<td>
			${adIndex.index+1}
			</td>
			<td>${keyword.keywords }</td>
			<td>${keyword.customName }</td>
			<td>${keyword.bossName }</td>
			<td>${keyword.agentName }</td>
			<td>${keyword.regDatetime }</td>
			<td>${keyword.customTypeName }</td>
			<td>
			<c:if test="${ keyword.isUse==1}">
				已使用
			</c:if>
			<c:if test="${ keyword.isUse!=1}">
				未使用
			</c:if>
		</td>
	<td colspan="2">
			 <a href="viewportal.action?customId=${keyword.customId }">查看</a>
         
            <a href="modifyPortal.action?customId=${keyword.customId}">修改</a>
              </td>
		</tr>
		</c:forEach>
	
</tbody>
</table>

<div class="pagination pagination-centered">
										   <ul>
		<li><a href="myportalmanage.action?current=1" title="首页">首页</a></li>
							<c:if test="${Customspage.current>1}">
								<c:forEach begin="1" end="${Customspage.current-1}" var="num" step="1">
									<li><a
										href="myportalmanage.action?current=${num}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				            <li class="active">
							  <a href="myportalmanage.action?current=${Customspage.current}" title="${Customspage.current}">${Customspage.current} </a>
							</li>
							<c:if test="${Customspage.current<pageCount}">
							<c:forEach begin="${Customspage.current+1}" end="${pageCount}" var="num" step="1">
									<li><a
										href="myportalmanage.action?current=${num}"
										class="number" title="${num}"> ${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="myportalmanage.action?current=${pageCount}" title="尾页">尾页</a></li>
						  </ul>
						</div>
</div>
<link id='theme' rel='stylesheet' href='/css/myportallist.css'/>
<script type="text/javascript" src="/js/myportallist.js" charset="UTF-8"></script> 

<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>