<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="javascript:void();">系统管理</a> \ <a href="/userlist.action">用户管理</a>
</div>

<div class="container">
<%-- <c:if test="${roleList==null}">
<c:redirect url="/sys/as-role/roleList"></c:redirect>
</c:if> --%>
<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="/sys/userr/findUser" method="post">
		用户名称:
		<input type="text" id="uname" name="userName" value="${oldUser.userName}"/>
		角色：
		<select name="roleId">
 			<option value="" selected="selected">--请选择--</option>
 				
 				<c:if test="${roleList!=null}">
 				<c:forEach items="${roleList}" var="role">
 				<c:if test="${role.id==oldUser.roleId}">
 						<option value="${role.id}" selected="selected">${role.roleName}</option>
 						</c:if>
 						<c:if test="${role.id!=oldUser.roleId}">
 						<option value="${role.id}" >${role.roleName}</option>
 						</c:if>	
 					</c:forEach>
 				</c:if>
 			
 		</select>
 		是否启用：
		<select name="isStart">
		<option value="" selected="selected">--请选择--</option>
		<c:choose>
 			<c:when test="${oldUser.isStart == 1}">
 				<option value="1" selected="selected">启用</option>
 				<option value="0">未启用</option>
 			</c:when>
 			<c:when test="${oldUser.isStart == 0}">
 				<option value="0" selected="selected">未启用</option>
 				<option value="1">启用</option>
 			</c:when>
 			<c:otherwise>
	 			<option value="0">未启用</option>
	 			<option value="1">启用</option>
 			</c:otherwise>
 			</c:choose>
 		</select>
		<input type="submit" value="查询"/>
		</form>
		</li>
	</ul>
</div>
	<div id="addUserDiv" class="addUserDivClass addback">
 		<ul>
 			<li class="lititle">
      				<b>添加代理商用户信息</b>
      			</li>
 			<li>登录账号：<input id="a_userCode" type="text" name="user.userCode" /> <span>*</span></li>
 			<li>用户名称：<input id="a_userName" type="text" name="user.userName"/> <span>*</span></li>
 			<li>登录密码：<input id="a_userPassword" type="password" name="user.userPassword" value="123456"/> <span>*默认初始密码123456</span></li>
 			<li>角&nbsp;&nbsp;&nbsp;&nbsp;色：
 			<select id="a_roleId" name="user.roleId">
 				<option value="0" selected="selected">--请选择--</option>
 				
 				<c:if test="${roleList!=null}">
 				<c:forEach items="${roleList}" var="role">
 						<option value="${role.id}">${role.roleName}</option>
 					</c:forEach>
 				</c:if>
 			</select> <span>*</span>
 			</li>
 			<li>是否启用：
 			<select id="a_isStart" name="user.isStart">
 				<option value="1" selected="selected">启用</option>
 				<option value="0">不启用</option>
 			</select> <span>*</span>
 			<input id="addUserSubmit" type="button" value="保存"/> <input id="addcancel" type="reset" value="取消"/></li>
 		</ul>
	</div>
	  <div id="modifyUserDiv" class="addUserDivClass modifyback">
      		<ul>
      			<li class="lititle">
      				<input id="m_userId" type="hidden" name="user.id"/>
      				<b>修改代理商用户信息</b>
      			</li>
      			<li>登录账号：<input id="m_userCode"  type="text" name="user.userCode" /> <span>*</span></li>
      			<li>用户名称：<input id="m_userName"  type="text" name="user.userName" /> <span>*</span></li>
      			<li>登录密码：<input id="m_userPassword"  type="password" name="user.userPassword" /> <span>*</span></li>
      			<li>角&nbsp;&nbsp;&nbsp;&nbsp;色：
      			<span id=m_SelectRole></span> <span>*</span>
      			</li>
      			<li>是否启用：
      			<span id="m_Select"></span> <span>*</span>
      			<input id="modifyUserSubmit" type="submit" value="保存"/> <input id="modifycancel" type="button" value="取消"/></li>
      		</ul>
      	</div>
      	
      	<div class="addUserDiv"><input id="addUser" type="button" value="新增" /></div>
      	
        <table>
          <thead>
            <tr>
		     	<th>登录账号</th>
		     	<th>用户名称</th>
		     	<th>角色</th>
		     	<th>创建时间</th>
		     	<th>是否启用</th>
		     	<th colspan="3">操作</th>
  			</tr>
          </thead>
           <tbody>
   
            <c:forEach items="${userPage.records}" var="p">
            
            	<tr>
                    <td><a>${p.userCode}</a></td>
                    <td><a>${p.userName}</a></td>
                    <td><a>${p.roleName}</a></td>
                    <td><a>${p.creationTime}</a></td>
                     <td>
                    <c:choose>
                    <c:when test="${p.isStart == 1}">启用</c:when>
                    <c:otherwise><a>未启用</a></c:otherwise>
                    </c:choose>
                    </td>
                    <td colspan="3">
						<span class="modifyUser" userid="${p.id}" usercode="${p.userCode}" username="${p.userName}"  userpassword="${p.userPassword}" isstart="${p.isStart}" roleid="${p.roleId}" rolename="${p.roleName}"><a>修改</a></span> | 
						<span class="deleteUser" usercode="${p.userCode}"  userid="${p.id}" currentUserRoleId="${currentUser.roleId}" roleid="${p.roleId}"><a>删除</a></span>  
						
					</td>
                 </tr>   
              </c:forEach>
             
           </tbody> 
         </table>
         
         
<div class="pagination pagination-centered">
						  <ul>
							<li><a href="/sys/userr/findUser?current=1&userName=${oldUser.userName}&roleId=${oldUser.roleId}&isStart=${oldUser.isStart}" title="首页">首页</a></li>
							<c:if test="${userPage.current>1}">
								<c:forEach begin="1" end="${userPage.current-1}" var="num" step="1">
									<li><a href="/sys/userr/findUser?current=${num}&userName=${oldUser.userName}&roleId=${oldUser.roleId}&isStart=${oldUser.isStart}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				
							<li class="active">
							  <a href="/sys/userr/findUser?current=${userPage.current}&userName=${oldUser.userName}&roleId=${oldUser.roleId}&isStart=${oldUser.isStart}" title="${userPage.current}">${userPage.current}</a>
							</li>
							
							<c:if test="${userPage.current<pageCount}">
								<c:forEach begin="${userPage.current+1}" end="${pageCount}" var="num" step="1">
									<li><a href="/sys/userr/findUser?current=${num}&userName=${oldUser.userName}&roleId=${oldUser.roleId}&isStart=${oldUser.isStart}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="/sys/userr/findUser?current=${pageCount}&userName=${oldUser.userName}&roleId=${oldUser.roleId}&isStart=${oldUser.isStart}" title="尾页">尾页</a></li>
						  </ul>
						</div>
						
<script type="text/javascript">
	var roleListJson = [
		<c:forEach items="${roleList}" var="role">
			{"id":"${role.id}","roleName":"<a>${roleName}</a>"},
			</c:forEach>{"id":"over","roleName":"over"}];
</script>
<link id='theme' rel='stylesheet' href='/css/userlist.css'/>
<script type="text/javascript" src="/js/userlist.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
