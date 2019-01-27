<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/customlist.action">代理商客户管理</a>
</div>
<div class="container">
	
		<form action="/customlist.action" method="get" >
             <div>
	            <label>客户名称:</label>
	            <input type="text" id="cname" name="cname" value=""/>
	            <input type="submit" value="查询" /> 
              </div>
        </form>
        
        <div class="addCustomDiv">
        <input onclick="javascript:location.href='/addcustom.action';" type="button" value="添加客户" />
        </div>
		
		
            <table>
            <thead>
            <tr>
	     	<th>序号</th>
	     	<th>客户名称</th>
	     	<th>法人代表</th>
	     	<th>注册时间</th>
	     	<th>类型</th>
	     	<th>状态</th>
	     	<th>操作</th>
  			</tr>
            </thead>
            <c:forEach var="cus" items="${Cuspage.records}" varStatus="sta">
            <tr class="tabletr">
            		<td>
            		${sta.index+1}
					</td>
                    <td>${cus.customName}</td>
                    <td>${cus.bossName}</td>
                    <td>${cus.regDatetime}</td>
                    <td>${cus.customTypeName}</td>
                    <td>
                    <span id="m_status${sta.index+1}">
                    <c:if test="${cus.customStatus == 1}"><font color="green">启用</font></c:if>
                    <c:if test="${cus.customStatus != 1}"><font color="red">停用</font></c:if>
                   
                    </span>
                    </td>
                    <td class="funcli">
                    	<ul>
                     		<li><a class="viewCustom" id="${cus.id}">查看</a></li>
                     		<li><a class="modifyCustom" id="${cus.id}" cname="${cus.customName}">修改</a></li>
                     		<c:if test="${cus.customStatus == 1}">
                     		<li> <a class="modifyCustomStatus" id="${cus.id}" mStatus="${sta.index+1}"
                     		 customStatus="${cus.customStatus-1}" customName="${cus.customName}"><font color="red">停用</font></a> </li>
                     		 </c:if>
                     		<c:if test="${cus.customStatus != 1}">
                    		 <li>
							 <a class="modifyCustomStatus" id="${cus.id}" mStatus="${sta.index+1}" 
							 customStatus="${cus.customStatus+1}" customName="${cus.customName}"><font color="green">启用</font></a>
							 	</li>
							</c:if>
						
                     		</ul>
					</td>
                 </tr>  
                  </c:forEach> 
             
              </table>
              <div class="pagination pagination-centered">
						  <ul>

						<ul>
							<li><a href="customlist.action?current=1" title="首页">首页</a></li>
							<c:if test="${Cuspage.current>1}">
								<c:forEach begin="1" end="${Cuspage.current-1}" var="num" step="1">
									<li><a
										href="customlist.action?current=${num}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>>
							</c:if>
				
							<li class="active">
							  <a href="customlist.action?current=${Cuspage.current}" title="${Cuspage.current}">${Cuspage.current} </a>
							</li>
							
							<c:if test="${Cuspage.current<pages}">${Cuspage.current+1}
								<c:forEach begin="${Cuspage.current+1}" end="${pages}" var="num" step="1">
									<li><a
										href="customlist.action?current=${num}"
										class="number" title="${num}">${num} </a></li>
								</c:forEach>
							</c:if>
							<li><a href="customlist.action?current=${pages}" title="尾页">尾页</a></li>
						  </ul>
				</div>
     
	</div>
<link id='theme' rel='stylesheet' href='/css/customlist.css'/>
<script type="text/javascript" src="/js/customlist.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>

