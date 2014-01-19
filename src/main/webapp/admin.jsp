<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<link href="js/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="js/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="js/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<style type="text/css">
	#header{height:85px}
	#leftside, #container, #splitBar, #splitBarProxy{top:90px}
</style>
<!--[if IE]>
<link href="js/dwz/themes/css/ieHack.css" rel="jsheet" type="text/css" />
<![endif]-->
<%@ include file="/admin/common/admin.script.jsp"%>
<script type="text/javascript">
$(function(){
	DWZ.init("js/dwz/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"js/dwz/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="/">Home</a></li>
					<li><a href="/management/user!editContext.do" target="dialog" mask="true">我的资料</a></li>
					<li><a href="/management/index!editPwd.do" target="dialog" mask="true">修改密码</a></li>
					<li><a href="admin/user/login">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
			<div id="navMenu">
				<ul>
					<li class="selected"><a href="sidebar_1.html"><span>资讯管理</span></a></li>
					<li><a href="sidebar_2.html"><span>订单管理</span></a></li>
					<li><a href="sidebar_1.html"><span>产品管理</span></a></li>
					<li><a href="sidebar_2.html"><span>会员管理</span></a></li>
					<li><a href="sidebar_1.html"><span>服务管理</span></a></li>
					<li><a href="sidebar_2.html"><span>系统设置</span></a></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
			
				<div class="accordion" fillSpace="sideBar">
				   <div class="accordionHeader">
						<h2><span>Folder</span>用户管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="admin/user/list" target="navTab" rel="userManagerNav">用户管理</a></li>
							<li><a href="admin/role/list" target="navTab" rel="roleNav">权限管理</a></li>
							<li><a href="admin/resources/list" target="navTab" rel="resourcesNav">资源管理</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>系统设置</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="admin/sysparam/tree" target="navTab" rel="sysparamNav">参数管理</a></li>
							<li><a href="admin/category/list" target="navTab" rel="categoryNav">类别管理</a></li>
                            <li><a href="admin/admin/content" target="navTab" rel="contentNav">内容管理</a></li>
						</ul>
					</div>
					
					
					
					
					
				</div>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">My Home</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<div class="right">
								<p>${model }</p>
							</div>
							<p><span>Welcome,</span></p>
							<p></p>
						</div>
						
						<div class="pageFormContent" layoutH="80">
							
							
						</div>

					</div>
				</div>
			</div>
		</div>



	</div>
	
	<div id="footer"><fmt:message key="ui.copyrights" /></div>


</body>
</html>