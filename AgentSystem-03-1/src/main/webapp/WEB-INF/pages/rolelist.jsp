<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="javascript:void();">系统管理</a> \ <a href="/rolelist.action">角色管理</a>
</div>

<c:if test="${roleList==null}">
<c:redirect url="/sys/as-role/showRole"></c:redirect>
</c:if>
	<div class="container">
      <div id="addRoleDiv" class="addRoleDivClass addback">
      <form>
    		<ul>
    			<li  class="lititle">
      				<b>添加角色信息</b>
      			</li>
    			<li>角色名称：<input id="a_roleName" type="text" name="role.roleName" /> <span>*</span> </li>
    			<li>是否启用：
    			<select id="a_isStart" name="role.isStart"  >
    				<option value="1" selected="selected">启用</option>
    				<option value="0">不启用</option>
    			</select> <span>*</span>
    			<input id="addRoleSubmit" type="button" value="保存"/> <input id="addcancel" type="reset" value="取消"/>
    			</li>
    		</ul>
    		</form>
   	</div>
   	 <div id="modifyRoleDiv" class="addRoleDivClass modifyback">
      		<ul>
      			<li   class="lititle">
      				<input id="m_roleId" type="hidden" name="role.id"/>
      				<b>修改角色信息</b>
      			</li>
      			<li>
      			角色名称：<input id="m_roleName"  type="text" name="role.roleName" /> <span>*</span></li>
      			<li>是否启用：
      			<span id="m_Select"></span> <span>*</span>
      			<input id="modifyRoleSubmit" type="submit" value="保存"/> <input id="modifycancel" type="button" value="取消"/>
      			</li>
      		</ul>
      	 </div>




	<div class="addRoleDiv"><input id="addRole" type="button" value="新增" /></div>
		
		
       
         
	 
	 	<c:if test="${roleList != null}">
            <table>
            <thead>
            <tr>
	     	<th>角色名称</th>
	     	<th>创建时间</th>
	     	<th>是否启用</th>
	     	<th colspan="2">操作</th>
  			</tr>
            </thead>
            <tbody>
            <c:forEach items="${roleList }" var="role" varStatus="sta">
         
            	<tr>
                    <td><a>${role.roleName }</a></td>
                    <td><a>${role.creationTime }</a></td>
                    <td>
                    <c:choose>
                  <c:when test="${role.isStart == 1}">启用</c:when>
                   <c:otherwise>未启用</c:otherwise>
                    </c:choose>
                    </td>
                    <td colspan="2">
						<span class="modifyRole" roleid="${role.id }" rolename="${role.roleName }"  isstart="${role.isStart }"><a>修改</a></span> | <span class="deleteRole" rolename="${role.roleName }"  roleid="${role.id }"><a>删除</a></span>
					</td>
                    <!--  
                    <td>
                    	<ul>
                     		<li><a class="modifyRole" roleid="<s:property value="id"/>" rolename="<s:property value="roleName"/>"  isstart="<s:property value="isStart"/>">修改</a></li>
                     		<li><a class="deleteRole" rolename="<s:property value="roleName"/>"  roleid="<s:property value="id"/>">删除</a></li>
                     	</ul>
					</td>
					-->
                 </tr>   
              </c:forEach>
              </tbody>
              </table>
       </c:if>
	</div>
<link id='theme' rel='stylesheet' href='/css/rolelist.css'/>
<script type="text/javascript" src="/js/rolelist.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
</body>
</html>

