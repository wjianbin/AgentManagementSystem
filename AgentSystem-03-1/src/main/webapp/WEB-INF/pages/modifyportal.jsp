<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>

<div class="mbxnav">
	<a href="/myportalmanage.action">门户管理</a> 
	 修改门户信息
</div>
<div class="container">
<form action="/modifysaveportal.action" method="post">
	<input type="hidden" name="id" value="${keywords.id }"/>
	<input type="hidden" name="cname" value="${cname}"/>
	<input type="hidden" name="kword" value="${kword}"/>
	
	<div class="subtitle">注册的移动云端信息</div>
	<div class="info1">
		<ul>
	<%-- 	<input type="hidden" name="id" value="${keywords.id }"/> --%>
		<%-- <li><input type="hidden" name="customId" value="${keywords.customId}"/></li> --%>
			<li>登录账号：<input type="text" id="appUserName" name="appUserName" value="${keywords.appUserName }"/> <span style="color:red;">*</span></li>
			<li>登陆密码：<input type="text" id="appPassword" name="appPassword" value="${keywords.appPassword }"/> <span style="color:red;">*</span></li>
			<li>关键词：${keywords.keywords }</li>
			<li>登录地址：${keywords.loginUrl }</li>
			<li>客户端下载地址(IOS)：<input type="text" id="iosDownloadUrl" name="iosDownloadUrl" value="${ keywords.iosDownloadUrl}"/></li>
			<li>二维码下载地址(IOS)：<input type="text" id="codeIosUrl" name="codeIosUrl" value="${ keywords.codeIosUrl}"/></li>
			<li>客户端下载地址(Android)：<input type="text" id="androidDownloadUrl" name="androidDownloadUrl" value="${keywords.androidDownloadUrl }<"/></li>
			<li>二维码下载地址(Android)：<input type="text" id="codeAndroidUrl" name="codeAndroidUrl" value="${keywords.codeAndroidUrl }"/></li>
			<li>关键词开始日期：${keywords.regDatetime }</li>
			<li>关键词结束日期：${keywords.regPassDatetime }</li>
			<li>关键词有效年限：${keywords.serviceYears } 年</li>
		</ul>
		<div class="clear"></div>
	</div>

	<div class="subtitle">基本信息</div>
	<div class="info1">
		<ul>
			<li>企业名称：${custom.customName }</li>
			<li>状态：<c:if test="${custom.customStatus == 1 }">
	        	 	  	<font color="green">启用</font>
	        	 	  </c:if>
	        	 	 <c:if test="${custom.customStatus != 1 }">
	        	 	  	<font color="red">停用</font>
					  </c:if></li>
			<li>企业类型：${custom.customTypeName }</li>
			<li>企业主页：${custom.siteUrl }</li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="subtitle">门户信息</div>
	<div class="info2">
		<ul>
			<li>法人代表：${custom.bossName}</li>
			<li>注册日期：${custom.regDatetime}</li>
			<li>证件类型：${custom.cardTypeName}</li>
			<li>证件号码：${custom.cardNum}</li>
			<li>省/地区：  ${custom.province}</li>
            <li>城市：	 ${custom.city}</li>
		    <li>区/县：      ${custom.area}</li>
			<li>公司电话：${custom.companyTel}</li>
			<li>公司传真：${custom.companyFax}</li>
			<li>公司地址：${custom.companyAddress}</li>
			<li>备注：${custom.memo}</li>
		</ul>
		<div class="clear"></div>
	</div>

	<div class="subtitle">联系人信息</div>
	<div class="info3">
		<ul>
			<c:if test="contactList != null">
			<c:forEach items="${contactList}" var="con">
            	<li>
            			<div>姓名：${con.contactName}</div>
            			<div>电话：${con.contactTel}</div>
            			<div>传真：${con.contactFax}</div>
            			<div>邮箱：${con.contactEmail}</div>
            			<div>职务：${con.contactRole}</div>
            		</li>
            </c:forEach>
            	</c:if>
            	<c:if test="contactList == null">
            	
            		<li>没有任何联系人</li>
            	</c:if>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="goback">
		<input type="submit" value="保存"/> 
		<input type="button" onclick="window.history.back(-1);" value="返回" /> 
	</div>
	</form>
</div>
<link id='theme' rel='stylesheet' href='/css/modifyportal.css'/>
<script type="text/javascript" src="/js/modifyportal.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
