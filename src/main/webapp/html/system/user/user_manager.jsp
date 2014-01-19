<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="/admin/common/include.inc.jsp"></c:import>
<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<form id="pagerForm" onsubmit="return navTabSearch(this)"
		action="user/list" method="post">
		<input type="hidden" name="pageNum" value="1" /> 
		<input type="hidden" name="rel" value="${param.rel}" /> 
		<input type="hidden" name="numPerPage" value="${page.numPerPage}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /> 
		<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
		<div class="searchBar">

			<ul class="searchContent subBar">
				<li><label>用户名：</label> <input name="username" type="text"
					size="25" value="" /></li>
				<li><label>部门: </label> <select name="departmentId"
					class="required">
						<option value="">请选择</option>
						<c:forEach var="item" items="${departmentList }" varStatus="s">
							<option value="${item.id }"
								<c:if test="${user.departmentId==item.id}">selected</c:if>>${item.name
								}</option>
						</c:forEach>
				</select></li>
				<li><label>职务:</label> <select name="postId" class="required">
						<option value="">请选择</option>
						<c:forEach var="item" items="${postList }" varStatus="s">
							<option value="${item.id }"
								<c:if test="${user.postId==item.id}">selected</c:if>>${item.name
								}</option>
						</c:forEach>
				</select></li>

				<li style="width: auto;">
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">检索</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			
               <li><a class="add" target="navTab" rel="userNavAdd" href="admin/user/opt" title="新增用户"><span>新增</span></a></li>
			<shiro:hasPermission name="admin:user:new"></shiro:hasPermission>
			<shiro:hasPermission name="admin:user:update">
                  <li><a class="edit" target="navTab" rel="userNavUpdate" href="admin/user/opt?id={sid}" title="编辑部门"><span>编辑</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="admin:user:delete">
                    <li><a class="delete" onclick="deleteUser(this);"  rel="userNav" href="javascript:void(0);"  title="你确定要删除吗?"><span>删除</span></a></li>
			</shiro:hasPermission>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr>
				<th width="50">标识</th>
				<th width="100">用户名</th>
				<th width="100">姓名</th>
				<th width="200">电话</th>
				<th width="200">手机</th>
				<th width="100">部门</th>
				<th width="100">职务</th>
				<th width="200">权限</th>
				<th width="200">是否已经操作过团队</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${userList}" varStatus="s">
				<tr target="sid" rel="${item.id }" opt="${item.opt}">
					<td>${s.index + 1}</td>
					<td>${item.username}</td>
					<td>${item.realName}</td>
					<td>${item.tel}</td>
					<td>${item.mobilePhone}</td>
					<td><c:forEach var="department" items="${departmentList }">
							<c:if test="${item.departmentId==department.id}">
							      ${department.name }
							</c:if>
						</c:forEach></td>
					<td><c:forEach var="post" items="${postList }">
							<c:if test="${item.postId==post.id}">
							   ${post.name }
							</c:if>
						</c:forEach></td>
					<td>
					  <c:forEach var="role" items="${item.roleList }">
							${role.name},
						</c:forEach>
					</td>
					<td>
					   <c:if test="${item.opt==1}">
				                            是
					  </c:if> 
					   <c:if test="${item.opt==0}">
					                    否
					  </c:if>
				  </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/admin/common/pagePanelBar.jsp"></c:import>
	
</div>
