<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="/inc/head.jsp" %>

<%--  <c:if test="${roleList==null}">
<c:redirect url="/sys/as-role/roleList1"></c:redirect>
</c:if> --%> 
<div class="mbxnav">
	<a href="javascript:void();">系统管理</a> \ <a href="/premission.action">角色权限管理</a>
</div>
<div class="container">
		
		<ul>
			<li class="jslist">
						<ul>
		  	<c:forEach items="${roleList}" var="sta">
		 			
		       			<li>
		                <div id="sidebar"><a href="/funclist?roleId=${sta.id}" target="funclist"/>${sta.roleName}</a></div>
		                </li>
		         		
		 		</c:forEach> 
		 		</ul>
			</li>
			<li class="iframeli"><iframe id="funclist" name="funclist" width="100%" height="99%" src=""></iframe></li>
		</ul>
</div>
<link id='theme' rel='stylesheet' href='/css/premission.css'/>
<script type="text/javascript" src="/js/premission.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>

