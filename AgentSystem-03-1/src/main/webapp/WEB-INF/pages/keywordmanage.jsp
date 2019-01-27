<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/keywordmanage">关键词申请管理</a>
</div>
<div class="container">


<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="/keywordmanage.action" method="post">
		关键词：<input type="text" value="${keywords}" name="keywords"/>
		<input type="submit" value="查询"/>
		</form>
		</li>
	</ul>
</div>
 <table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>关键词</th>
		  <th>客户名称</th>
		  <th>代理商</th>
		  <th>申请年限</th>
		  <th>申请日期</th>
		  <th>到期日期</th>
		  <th>申请到期状态</th>
		  <th>审核状态</th>
		  <th>使用状态</th>
		  <th>APP开通状态</th>
		  <th>操作</th>
	  </tr>
  </thead>   
  <tbody>
	
		<c:forEach items="${page.records}" varStatus="s" var="keyword">
		<tr class="tabletr">
			<td>
			          <c:choose>
            		<c:when test="${1 >= page.current}">${s.index+1}</c:when>
					<c:otherwise>
					   ${(page.current-1) * page.size+s.index+1}
					</c:otherwise>
					</c:choose>
			</td>
			<td> ${keyword.keywords}</td>
			<td> ${keyword.customName}</td>
			<td> ${keyword.agentName}</td>
			<td> ${keyword.serviceYears}</td>
			<td> ${keyword.regDatetime}</td>
			<td> ${keyword.regPassDatetime}</td>
			<td>
				<c:choose>
				    <c:when test="${keyword.isPass == 0}">
				    <font color="green">未过期</font>
				    </c:when>
				    <c:when test="${keyword.isPass == 1}">
				   <font color="red">预注册过期</font>
				    </c:when>
				    <c:otherwise>
				          <font color="red">过期</font>
				    </c:otherwise>
				</c:choose>
			</td>
			<td>
			<c:choose>
			     <c:when test="${keyword.checkStatus == 0}">
					<font color="green">已申请</font>
				</c:when><c:when test="${ keyword.checkStatus == 1}">
					<font color="green">审核中</font>
				</c:when><c:when test="${keyword.checkStatus == 2}">
					<font color="green">已通过</font>
				</c:when><c:otherwise>
					<font color="red">未通过</font>
				</c:otherwise>
				</c:choose>
			</td>
			<td>
			<c:choose>
				<c:when test="${keyword.isUse == 0 }">
					<font color="red">未使用</font>
				</c:when><c:otherwise >
					<font color="green">已使用</font>
				</c:otherwise>
		     </c:choose>
			</td>
			<td>
			<c:choose>
				<c:when test="${keyword.openApp != 1}">
					<font color="red">未开通</font>
				</c:when><c:otherwise>
					<font color="green">已开通</font>
				</c:otherwise>
		   </c:choose>
			</td>
			
			<td>
			<c:choose>
				   <c:when test="${keyword.isUse == 1 }">
				   <c:choose>
				        <c:when test="${keyword.checkStatus == 2}">
				            <c:if test="${keyword.openApp != 1}">
				                <a class="openapp" kid="${keyword.id}" keyword="${keyword.keywords}">开通APP</a>
				            </c:if>
		        			<a class="xufei" kid="${keyword.id}" keyword="${keyword.keywords}">续费</a>
				        </c:when>
				        <c:when test="${keyword.isPass== 2}">
					         <a class="xufei" kid="${keyword.id}" keyword="${keyword.keywords}">续费</a>
					        <a class="deletekeyword"  kid="${keyword.id}" keyword="${keyword.keywords}">删除</a>
				        </c:when>
				        <c:when  test="${keyword.checkStatus == 3}">
					           <a class="deletekeyword" kid="${keyword.id}" keyword="${keyword.keywords}">删除</a>
				        </c:when>
				        <c:otherwise>
					          <font color="#ccc">无操作</font>
				        </c:otherwise>
				</c:choose>
				</c:when>
				        <c:otherwise>
					           <font color="#ccc">无操作</font>
			            </c:otherwise>
				</c:choose>
			</td> 
		</tr>
</c:forEach>
</tbody>
</table>

 <div class="pagination pagination-centered">		  
						 <ul>
							<li><a href="/keywordmanage.action?current=1&keywords=${keywords }" title="首页">首页</a></li>
							<c:if test="${page.current>1}">
								<c:forEach begin="1" end="${page.current-1}" var="num" step="1">
									<li><a
										href="/keywordmanage.action?current=${num}&keywords=${keywords }"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				
							<li class="active">
							  <a href="/keywordmanage.action?current=${page.current}" title="${page.current}">${page.current} </a>
							</li>
							<c:if test="${page.current<pages}">
								<c:forEach begin="${page.current+1}" end="${pages}" var="num" step="1">
									<li><a
										href="/keywordmanage.action?current=${num}&keywords=${keywords }"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="/keywordmanage.action?current=${pages}&keywords=${keywords}" title="尾页">尾页</a></li>
						  </ul> 
						</div>
</div> 
<link id='theme' rel='stylesheet' href='/css/keywordmanage.css'/>
<script type="text/javascript" src="/js/keywordmanage.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>