<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a><!--  \ <a href="/main.action">当前账户信息</a> \ <a href="accountdetail.action">查看账户明细</a> -->
</div>
<div class="container">

 <table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>账务类型</th>
		  <th>账务资金</th>
		  <th>账户余额</th>
		  <th>备注信息</th>
		  <th>明细时间</th>                                          
	  </tr>
  </thead>   
  <tbody>
	
		 <c:forEach items="${page.records}" var="recods">
		<tr>
		<td>
			${recods.id}
			</td>
			<td>${recods.detailTypeName}</td>
			<td>￥${recods.money}</td>
			<td>￥${recods.accountMoney}</td>
			<td>${recods.memo}</td>
			<td class="center">${recods.detailDateTime}</td>
		</tr>
		</c:forEach>
	
</tbody>
</table>

<div class="pagination pagination-centered">
						   <ul>
							<li><a href="accountdetail.action?current=1" title="首页">首页</a></li>
							<c:if test="${page.current>1}">
								<c:forEach begin="1" end="${page.current-1}" var="num" step="1">
									<li><a
										href="accountdetail.action?current=${num}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				
							<li class="active">
							  <a href="accountdetail.action?current=${page.current}" title="${page.current}">${page.current} </a>
							</li>
							<c:if test="${page.current<pages}">
								<c:forEach begin="${page.current+1}" end="${pages}" var="num" step="1">
									<li><a
										href="accountdetail.action?current=${num}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="accountdetail.action?current=${pages}" title="尾页">尾页</a></li>
						  </ul>
						</div>
</div>
<link id='theme' rel='stylesheet' href='/css/accountdetail.css'/>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>