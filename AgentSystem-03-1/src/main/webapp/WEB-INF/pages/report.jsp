<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/report.action">报表管理</a> \ <a href="/report.action">报表管理</a>
</div>
<div class="container">


<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="reportcheck.action" method="post" onsubmit="return searchReportFunc();">
		
		操作类型：
		<select name="reportType" id="reporttype">
		<option value="999" style="background: #333333;padding:3px;color:#fff;">财务报表</option>
		<option value="1" <c:if test="${reportType == 1}">selected="selected"</c:if> style="padding:3px;">	&nbsp;&nbsp;&nbsp;&nbsp;代理商账户余额报表</option>
		<option value="2" <c:if test="${reportType == 2}">selected="selected"</c:if> style="padding:3px;">	&nbsp;&nbsp;&nbsp;&nbsp;预付款流水报表</option>
		<option value="3" <c:if test="${reportType == 3}">selected="selected"</c:if> style="padding:3px;">	&nbsp;&nbsp;&nbsp;&nbsp;代理商流水报表</option>
		<option value="998" style="background: #333333;padding:3px;color:#fff;">产品报表</option>
		<option value="4" <c:if test="${reportType == 4}">selected="selected"</c:if> style="padding:3px;">	&nbsp;&nbsp;&nbsp;&nbsp;产品分类数量/金额汇总</option>
		<option value="997" style="background: #333333;padding:3px;color:#fff;">消费报表</option>
		<option value="6" <c:if test="reportType == 5">selected="selected"</c:if> style="padding:3px;">	&nbsp;&nbsp;&nbsp;&nbsp;客户消费汇总(暂无)</option>
		</select>
		<div id="opertime" style="margin-top:-20px; margin-left:280px;">
		操作时间：
		<input class="Wdate" size="15" name="startTime" id="starttime" value="" readonly="readonly" type="text" onClick="WdatePicker()" />
		至
		<input class="Wdate" size="15" name="endTime" id="endtime" value="" readonly="readonly" type="text" onClick="WdatePicker()" />
		</div>
		<div style="margin-top:-20px; margin-left:600px;">
		<input type="submit" value="查询"/>
		</div>
		</form>
		</li>
	</ul>
</div>
<c:if test="${reportType == 1}">
<div class="downloadfile">
<ul>
	<li><img src="/imgs/pdf.png" /><a href="reportYfke.action?reportType=${reportType }">PDF下载</a></li>
	<li><img src="/imgs/excel.png" /><a href="reportYfkpdf.action?reportType=${reportType }">Excel下载</a></li>
</ul>
</div>
<h1>代理商余额报表</h1>
<table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>代理商名称</th>
		  <th>账户余额</th>
	  </tr>
  </thead>   
  <tbody>

	<c:forEach var="account" items="${accountList}" varStatus="adIndex">
	  <tr>
			<td>
			${ adIndex.index+1}
			</td>
			<td>${account.userName}</td>
			<td>￥${account.money}</td>
		</tr>
		</c:forEach>
	
</tbody>
</table>
</c:if>
<c:if test="${reportType==2 }">

<div class="downloadfile">
<ul>
	<li><img src="/imgs/pdf.png" /><a href="reportYfke.action?reportType=${reportType }">PDF下载</a></li>
	<li><img src="/imgs/excel.png" /><a href="/reportYfkpdf.action?reportType=${reportType }">Excel下载</a></li>
</ul>
</div>
<h1>预付款流水报表</h1>
<table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>代理商名称</th>
		  <th>预付款</th>
		  <th>账户余额</th>
		  <th>备注信息</th>
		  <th>时间</th>
	  </tr>
  </thead>   
  <tbody>
	
	<c:forEach var="acc" items="${accountDetailList}" varStatus="adIndex">
		
		<tr>
			<td>
				${adIndex.index+1}
		
			</td>
			<td>${acc.userName}</td>
			<td>${acc.money}</td>
			<td>${acc.accountMoney}</td>
			<td>${acc.memo}</td>
			<td>${acc.detailDateTime}</td>
		</tr>
		</c:forEach>
	
</tbody>
</table>
</c:if>

<c:if test="${reportType==3 }">
<div class="downloadfile">
<ul>
	<li><img src="/imgs/pdf.png" /><a href="reportYfke.action?reportType=${reportType }">PDF下载</a></li>
	<li><img src="/imgs/excel.png" /><a href="reportYfkpdf.action?reportType=${reportType }">Excel下载</a></li>
</ul>
</div>
<h1>代理商流水报表</h1>
<table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>代理商名称</th>
		  <th>预付款</th>
		  <th>账户余额</th>
		  <th>备注信息</th>
		  <th>时间</th>
	  </tr>
  </thead>   
  <tbody>
	
	    <c:forEach var="acc" items="${accountDetailList}" varStatus="adIndex">
		<tr>
			<td>
			${ adIndex.index+1}
			</td>
			<td>${acc.userName}</td>
			<td>${acc.money}</td>
			<td>${acc.accountMoney}</td>
			<td>${acc.memo}</td>
			<td>${acc.detailDateTime}</td>
		</tr>
		</c:forEach>
	
</tbody>
</table>
</c:if>
<c:if test="${reportType==4 }">
<div class="downloadfile">
<ul>

</ul>
</div>
<h1>产品分类数量/金额汇总</h1>
<table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>产品分类名称</th>
		  <th>数量</th>
		  <th>价格</th>
	  </tr>
  </thead>   
  <tbody>
	<c:if test="${ reportProductList !=null }">
	 <c:forEach var="rep" items="${reportProductList}" varStatus="adIndex">
		<tr>
			<td>
			${adIndex.index+1}
		</td>
			<td>${rep.configTypeName}</td>
			<td>${rep.number}</td>
			<td>${rep.price}</td>
		</tr>
		</c:forEach>
	</c:if>
</tbody>
</table>
</c:if>

</div>
<link id='theme' rel='stylesheet' href='/css/report.css'/>
<script type="text/javascript" src="/js/report.js"></script>
<script type="text/javascript" src="/medire/WdatePicker.js"></script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>