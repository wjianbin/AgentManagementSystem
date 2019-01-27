<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="javascript:void();">系统管理</a> \ <a href="/checkkeyword.action">关键词审核</a>
</div>
<%-- <c:if test="${page==null}">
<c:redirect url="/checkkeywords"></c:redirect>
</c:if> --%>
<div class="container">

<h2>关键词审核</h2>

<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="/checkkeywords" method="post">
		关键词：<input type="text" value="${oldkeywords}" name="keywords"/>
		<input type="submit" value="查询"/> 
		<span class="okflow">审核流程：已申请（代理商申请） 》 审核中 》 通过 》 续费 </span> | 
		<span class="noflow">审核流程：已申请（代理商申请） 》 审核中 》 不通过</span>
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
		  <th>操作</th>
	  </tr>
  </thead>   
  <tbody>
	<c:if test="${page!=null}">
		<c:forEach items="${page.getRecords()}" varStatus="adIndex" var="keyword">
		<tr class="tabletr">
			<td>
			<%-- <c:choose>
			<c:when test="${1 >= page.page }">${adIndex.index+1}</c:when>
			<c:otherwise>
			${(page.page-1) * page.pageSize+#adIndex.index+1 }
			</c:otherwise>
			</c:choose> --%>
			${keyword.id}
			</td>
			<td>${keyword.keywords}</td>
			<td>${keyword.customName }</td>
			<td>${keyword.agentName }</td>
			<td>${keyword.serviceYears }</td>
			<td>${keyword.regDatetime }</td>
			<td>${keyword.regPassDatetime }</td>
			<td>
			<c:choose>
				<c:when test="${keyword.isPass == 0 }">
					<font color="green">未过期</font>
				</c:when>
				<c:when test="${keyword.isPass == 1 }">
					<font color="red">预注册过期</font>
				</c:when>
				<c:when test="${keyword.isPass == 2 }">
					<font color="red">过期</font>
				</c:when>
				</c:choose>
			</td>
			<td>
			<c:choose>
			<c:when test="${keyword.checkStatus == 0 }">
					<font color="green">已申请</font>
			</c:when>
			<c:when test="${keyword.checkStatus == 1 }">
					<font color="green">审核中</font>
			</c:when>
			<c:when test="${keyword.checkStatus == 2 }">
					<font color="green">已通过</font>
			</c:when>
			<c:when test="${keyword.checkStatus == 3 }">
					<font color="red">未通过</font>
			</c:when>			
			</c:choose>
			</td>
			<td>
			<c:choose>
			<c:when test="${keyword.isUse == 0 }">
					<font color="red">未使用</font>
				</c:when><c:when test="${keyword.isUse == 1 }">
					<font color="green">已使用</font>
				</c:when>
				</c:choose>
			</td>
			<td>	
			<select class="checkselect" kid="${keyword.id}" keyword="${keyword.keywords}">
					<option value="0">--请选择--</option>
                  <c:if test="${keyword.checkStatus == 0 && keyword.isUse == 1 }"> 
						<option value="1">审核中</option>
					</c:if>
					<c:if test="${keyword.checkStatus == 1 && keyword.isUse == 1 }">
						<option value="2">审核通过</option>
						<option value="3">不通过</option>
					</c:if>
					<c:if test="${keyword.checkStatus == 2 && keyword.isUse == 1 }">
						<option value="4">续费</option>
					</c:if>
					<c:if test="${keyword.isUse == 1 }">
						<option value="5">不使用</option>
					</c:if>
					<c:if test="${keyword.isUse == 0 }">
						<option value="6">使用</option>
					</c:if>
				</select>
				</td>
		</tr>
		</c:forEach>
	</c:if>
</tbody>
</table>
         
<div class="pagination pagination-centered">
						  <ul>
							<li><a href="/checkkeywords?current=1&keywords=${oldkeywords}" title="首页">首页</a></li>
							<c:if test="${page.current>1}">
								<c:forEach begin="1" end="${page.current-1}" var="num" step="1">
									<li><a href="/checkkeywords?current=${num}&keywords=${oldkeywords}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				
							<li class="active">
							  <a href="/checkkeywords?current=${page.current}&keywords=${oldkeywords}" title="${page.current}">${page.current}</a>
							</li>
							
							<c:if test="${page.current<pageCount}">
								<c:forEach begin="${page.current+1}" end="${pageCount}" var="num" step="1">
									<li><a href="/checkkeywords?current=${num}&keywords=${oldkeywords}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="/checkkeywords?current=${pageCount}&keywords=${oldkeywords}" title="尾页">尾页</a></li>
						  </ul>
						</div>
</div>
<link id='theme' rel='stylesheet' href='/css/checkkeyword.css'/>
<script type="text/javascript" src="/js/checkkeyword.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>