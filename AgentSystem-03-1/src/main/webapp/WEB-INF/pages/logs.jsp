<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/mylogs.action">查看操作日志</a>
</div>
<div class="container">

 <table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>用户名称</th>
		  <th>操作信息</th>
		  <th>操作时间</th>
	  </tr>
  </thead>   
  <tbody>
	<c:if test="${page.items}!=null">
	<c:forEach var="logs" items="${page.items}" varStatus="adIndex">
		
		<tr>
		<td>
			<c:if test="1 >= page.page">${adIndex.index+1 }
			</c:if>
			<c:if test="1 < page.page">${adIndex.index+1 }
			<%-- <s:property value='(page.page-1) * page.pageSize+#adIndex.index+1' /> --%>
			</c:if>
			</td>
			<td>${logs.userName }</td>
			<td>${logs.operateInfo }</td>
			<td class="center">${logs.operateDatetime }
			</td>
		</tr>
		</c:forEach>
	</c:if>
</tbody>
</table>

<div class="pagination pagination-centered">
						  <ul>
							<li><a href="/mylogs.action?page.page=1" title="首页">首页</a></li>
							<c:if test="page.prevPages!=null">
								<%-- <s:iterator value="page.prevPages" var="num">
									<li><a
										href="/mylogs.action?page.page=${num}"
										class="number" title="<s:property value='#num'/>"><s:property
											value="#num" /> </a></li>
								</s:iterator> --%>
							</c:if>
							<li class="active">
							  <a href="#"title="<s:property value='page.page'/>"><s:property value='page.page' /> </a>
							</li>
							<c:if test="page.nextPages!=null">
								<%-- <s:iterator value="page.nextPages" var="num">
									<li><a href="/mylogs.action?page.page=${num }" title="<s:property value='#num'/>">
									<s:property value="#num" /> </a></li>
								</s:iterator> --%>
							</c:if>
							<li><a href="/mylogs.action?page.page=${page.pageCount}" title="尾页">尾页</a></li>
						  </ul>
						</div>
</div>
<link id='theme' rel='stylesheet' href='/css/logs.css'/>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>