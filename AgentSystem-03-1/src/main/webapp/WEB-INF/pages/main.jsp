<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/main.action">当前账户信息</a>
</div>
<div class="container">

<div class="userInfo">
	<ul>
		<li><b>您好，${user.userName }!</b> 您上次登录时间 ${user.lastLoginTime }</li>
		<li>
		您当前账户余额：
		${asAccount.money}
		<c:if test="account == null">对不起，您还没有开启账户，或者您的账户的资金出现了问题，请联系系统管理员进行处理。</c:if>
		<a href="/accountdetail.action">查看账户明细</a>
	</li>
	</ul>
	
</div>

</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>