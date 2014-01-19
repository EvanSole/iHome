<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="panelBar">
	<div class="pages">
			<span>显示</span>
			<select  name="numPerPage"  onchange="navTabPageBreak({numPerPage:this.value}, '${param.rel}')">
				<c:forEach begin="10" end="40" step="10" varStatus="s">
				   <option value="${s.index}" ${page.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			    </c:forEach>
			</select>
			<span>条，共${page.rowCount}条</span>
		</div>
	<div class="pagination" rel="${param.rel}" targetType="navTab" totalCount="${page.rowCount}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${param.pageNum}"></div>
</div>