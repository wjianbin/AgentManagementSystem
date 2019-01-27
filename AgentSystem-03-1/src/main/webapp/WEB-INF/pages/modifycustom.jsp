custom<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/inc/head.jsp"%>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/customlist.action">代理商客户管理</a>
	\ <a
		href="/modifycustom.action?custom.id={custom.id}">修改客户信息</a>
</div>
<div class="container">
	<form id="cform" action="modifysavecustom" method="post">
		<input type="hidden" id="id" name="id" value="${custom.id}" /> <input
			type="hidden" name="cname" value="${cname}"/>
		<div class="subtitle">基本信息</div>
		<div class="info1">
			<ul>
				<li>企业名称： <input type="text" id="custom_name" name="customName"
					value="${custom.customName}" /> <span style="color: red;">*</span></li>
				<li>企业类型：<input id="customtypename" type="hidden"
					name="customTypeName" value="${custom.customTypeName}"/> <select
					id="selectcustomtype" name="customType">
						<option value="0" selected="selected">--请选择--</option>
						<c:if test="${customTypeList != null}">
							<c:forEach items="${customTypeList}" var="c">
								<option
									<c:if test="${custom.customType ==c.configTypeValue}">
							                 selected = "selected"
							          </c:if>
									value="${c.configTypeValue}">${ c.configTypeName}</option>
							</c:forEach>
						</c:if>
				</select> <span style="color: red;">*</span></li>
				<li>企业主页：<input type="text" name="custom.siteUrl"
					value="${custom.siteUrl}" /></li>
				<li>状态：<select name="customStatus">
						<c:choose>
							<c:when test="${custom.customStatus == 1}">
								<option value="1" selected="selected">启用</option>
								<option value="0">停用</option>
							</c:when>
							<c:otherwise>
								<option value="0" selected="selected">停用</option>
								<option value="0">启用</option>
							</c:otherwise>
						</c:choose>
				</select> <span style="color: red;">*</span></li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="subtitle">门户信息</div>
		<div class="info2">
			<ul>
				<li>法人代表：<input type="text" name="bossName"
					value="${custom.bossName}" /></li>
				<li>注册日期：<input class="Wdate" id="regdate" size="15"
					name="regDatetime" value="${custom.regDatetime}"
					readonly="readonly" type="text" onClick="WdatePicker()"/></li>
				<li>证件类型：<input id="cardtypename" type="hidden"
					name="cardTypeName" value="${custom.cardTypeName}" /> <select
					id="selectcardtype" name="cardType">
						<option value="0" selected="selected">--请选择--</option>
						<c:if test="${cardTypeList != null}">
							<c:forEach items="${cardTypeList}" var="s">
								<option
									<c:if test="${custom.cardType == s.configTypeValue}">
							         selected = "selected"
							          </c:if>
									value="${s.configTypeValue}">${s.configTypeName}</option>
							</c:forEach>
						</c:if>
				</select></li>
				<li>证件号码：<input type="text" name="cardNum"
					value="${custom.cardNum}" /></li>
				<li>国家：<input type="text" name="country"
					value="${custom.country}" /></li>
				<li>省/地区：<select id="selectprovince" name="province">
						
							<option value="0" selected="selected">--请选择--</option>
						
						<c:if test="${provinceList != null}">
							<c:forEach items="${provinceList}" var="s">
							<c:choose>
								<c:when test="${custom.provinceID == s.provinceID}">
									<option value="${s.provinceID}" selected="selected">${s.province}</option>
								</c:when>
								<c:otherwise>
									<option value="${s.provinceID}">${ s.province}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
				</select>
				</li>
				<li>公司传真：<input type="text" name="companyFax"
					value="${custom.companyFax}" /></li>
					
					<li>城市： <select id="selectcity" name="city">
						<option value="0" selected="selected">--请选择--</option>
						<c:if test="${CityList != null}">
							<c:forEach items="${ CityList}" var="c">
						<option value="${c.cityID}">${c.city}</option>
							</c:forEach>
						</c:if>
				</select>
				</li>
				
				<li>公司电话：<input type="text" name="companyTel"
					value="${custom.companyTel}" /></li>
				<li>区： <select id="selectarea" name="area">
						<option value="0" selected="selected">--请选择--</option>
						<c:if test="${AreaList != null}">
							<c:forEach items="${ AreaList}" var="a">
						<option value="${a.areaID}">${a.area}</option>
							</c:forEach>
						</c:if>
				</select>
				</li>
				<li>公司地址：<input type="text" name="companyAddress"
					value="${custom.companyAddress}" /></li>
			</ul>
			<div class="clear"></div>
			<div>
				备注：
				<textarea rows="2" cols="50" name="memo">${custom.memo}</textarea>
			</div>
		</div>
		<div class="subtitle">
			<a href="javascript:void(0);" id="addcontact">添加一个联系人</a>
			<c:choose>
				<c:when test="${contactList == null}">
					<input type="hidden" id="c_count" value="0" />
				</c:when>
				<c:otherwise>
					<input type="hidden" id="c_count"
						value="${contactList.size()}" />
				</c:otherwise>
			</c:choose>
		</div>
		<div class="info3">
			<table>
				<thead>
					<tr>
						<th>姓名</th>
						<th>电话</th>
						<th>传真</th>
						<th>邮箱</th>
						<th>职务</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="addtr">
					<c:if test="${custom.contactName != null}">
						<c:forEach items="${contactList}" var="s" varStatus="sta">
							<tr>
							          <input type="hidden" 
							                 name="contactList[${sta.index}].id"
						                             value="${s.acid}" />
								<td><input type="text"
									name="contactList[${sta.index}].contactName"
									value="${ s.contactName}" /><span
									style="color: red;">*</span></td>
								<td><input type="text"
									name="contactList[${sta.index}].contactTel"
									value="${ s.contactTel}" /><span
									style="color: red;">*</span></td>
								<td><input type="text"
									name="contactList[${sta.index}].contactFax"
									value="${ s.contactFax}" /></td>
								<td><input type="text"
									name="contactList[${sta.index}].contactEmail"
									value="${ s.contactEmail}" /></td>
								<td><input type="text"
									name="contactList[${sta.index}].contactRole"
									value="${ s.contactRole}" /></td>
								<td onclick="getDel(this)"><a href='javascript:void(0);'>删除</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="goback">
			<input type="button" value="保存" onclick="checksave();" /> <input
				type="button" onclick="window.history.back(-1);" value="返回" />
		</div>


	</form>


</div>
<link id='theme' rel='stylesheet' href='/css/modifycustom.css' />
<script type="text/javascript" src="/js/modifycustom.js" charset="UTF-8"></script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
id