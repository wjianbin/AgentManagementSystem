<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/yfk.action">代理商预付款</a>
</div>
<div class="container">


<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="/yfk.action" method="post" onsubmit="return searchyfklistFunc();">
		操作类型：
		<select name="detailType">
		<option value="" >---请选择---</option>
		<option <c:if test="${detailType == 9999}">
					selected = "selected"
				</c:if> value="9999">系统自动-关键词申请扣款</option>
		<option <c:if test="${detailType == 9998}">
					selected = "selected"
				</c:if> value="9998">系统自动-返回预注册冻结资金</option>
		<option <c:if test="${detailType == 9997}">
					selected = "selected"
				</c:if> value="9997">系统自动-扣除申请关键词的所有资金</option>
		<option <c:if test="${detailType == 9996}">
					selected = "selected"
				</c:if> value="9996">系统自动-扣除关键词续费资金</option>
			<c:forEach items="${accountConfigList}" var="s">
				<option
				<c:if test="${detailType == s.configTypeValue}">
					               selected = "selected"
				</c:if>
				 value="${s.configTypeValue}">${s.configTypeName}</option>
			</c:forEach>
		</select>
		操作时间：
		<input class="Wdate" size="15" name="startTime" id="starttime" value="${startTime}" readonly="readonly"  type="text" onClick="WdatePicker()" />
		至
		<input class="Wdate" size="15" name="endTime" id="endtime" value="${endTime}" readonly="readonly"  type="text" onClick="WdatePicker()" />
		
		<input type="submit" value="查询"/>
		</form>
		</li>
	</ul>
</div>


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
	
		<c:forEach items="${page.records}" var="recods" varStatus="s">
		<tr>
		<td>
			<c:choose>
            		<c:when test="${1 >= page.current}">${s.index+1}</c:when>
					<c:otherwise>
					   ${(page.current-1) * page.size+s.index+1}
					</c:otherwise>
					</c:choose>
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
							<li><a href="/yfk.action?current=1&startTime=${startTime}&endTime=${endTime}&detailType=${detailType}" title="首页">首页</a></li>
							<c:if test="${page.current>1}">
								<c:forEach begin="1" end="${page.current-1}" var="num" step="1">
									<li><a
										href="/yfk.action?current=${num}&startTime=${startTime}&endTime=${endTime}&detailType=${detailType}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				
							<li class="active">
							  <a href="/yfk.action?current=${page.current}&startTime=${startTime}&endTime=${endTime}&detailType=${detailType}" title="${page.current}">${page.current} </a>
							</li>
							<c:if test="${page.current<pages}">
								<c:forEach begin="${page.current+1}" end="${pages}" var="num" step="1">
									<li><a
										href="/yfk.action?current=${num}&startTime=${startTime}&endTime=${endTime}&detailType=${detailType}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="/yfk.action?current=${pages}&startTime=${startTime}&endTime=${endTime}&detailType=${detailType}" title="尾页">尾页</a></li>
						  </ul>
						</div>
</div>
<link id='theme' rel='stylesheet' href='/css/yfk.css'/>
<script type="text/javascript" src="/medire/WdatePicker.js"></script>
<script type="text/javascript" src="/js/yfk.js"></script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>