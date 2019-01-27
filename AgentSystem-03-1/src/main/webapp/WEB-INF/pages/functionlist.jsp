<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/iframehead.jsp" %>
	<div class="container">
	<h3>功能列表</h3>
	<div class="btndiv">
		<input type="hidden" id="roleid" value="${roleId}"/>
		<input id="saverolefunc" type="button" value="保存" />
		<input id="cancel" type="button" value="取消" />
	</div>
		
		<c:if test="${funcList != null}">
            <table>
            <thead>
            <tr>
	     	<th><input type="checkbox" id="cball"/>全选/全不选</th>
	     	<th>功能名称</th>
	     	<th>功能URL</th>
	     	<th>创建时间</th>
	     	<th>是否启用</th>
  			</tr>
            </thead>
            <tbody>
            <c:forEach items="${funcList}" var="st">
            	<tr>
                    <td>
                 <c:if test="${RolePremission.size()==0}">
                    <input class="cb" type="checkbox" value="${st.id}"/>
                    </c:if>
                    <c:set var="isDoing" value="0"/>
                    <c:forEach items="${RolePremission}" var="rp" varStatus="id">
                    <c:choose>
                    <c:when test="${rp.functionId == st.id}"> 
                    	<input class="cb" type="checkbox" checked="checked" value="${st.id}"/>
                    	 <c:set var="isDoing" value="1"/>
                    </c:when>
                    <c:otherwise>
                    <c:if test="${isDoing!=1 && id.last && rp.functionId!=st.id }">
                    	<input class="cb" type="checkbox" value="${st.id}"/>
                    	</c:if>
                    </c:otherwise>                            
                    </c:choose>
                    </c:forEach>
                    
                    </td> 
                    <td>${st.functionName }</td>
                    <td>${st.funcUrl}</td>
                    <td>${st.creationTime }</td>
                    <td>
                  <c:choose>
                    <c:when test="${isDoing == 1 }">启用</c:when>
                    <c:otherwise>未启用</c:otherwise>
                    </c:choose>
                    </td>
                 </tr>   
              </c:forEach>
              </tbody>
            </table>
       </c:if>
       
</div>
<link id='theme' rel='stylesheet' href='/css/functionlist.css'/>
<script type="text/javascript" src="/js/functionlist.js" charset="UTF-8"></script> 
</body>
</html>
