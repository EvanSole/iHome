<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:import url="/admin/common/include.inc.jsp"></c:import>
<script>
$(function(){
	
	$("input[name='username']").blur(function(){
		var username=$.trim($(this).val());
		if(username=="")
			{
			return false;
			}
		 $.post("admin/user/check",{"username":username},function(data){
		      data=jQuery.parseJSON(data);
		     var $username= $("input[name='username']");
		     var tempUsername='${user.username}';
		     if(tempUsername!=""){
		         if(username==tempUsername&&data.success){
		                $username.removeClass("error");
					    $username.next().remove();
					   $(".buttonActive div button").attr("disabled",false);
		              
		         }else if(!data.success){
		                $username.removeClass("error");
					    $username.next().remove();
					   $(".buttonActive div button").attr("disabled",false);
		         }else{
		               $username.addClass("error");
				       $username.parent().append('<span for="username" generated="true" class="error">用户重复，请重新选用！</span>');
			           $(".buttonActive div button").attr("disabled",true);
		         }
		     
		     }else{
		         if(data.success){
					  $username.addClass("error");
					  $username.parent().append('<span for="username" generated="true" class="error">用户重复，请重新选用！</span>');
				      $(".buttonActive div button").attr("disabled",true);
				  } else{
					  $username.removeClass("error");
					  $username.next().remove();
					  $(".buttonActive div button").attr("disabled",false);
				  } 
		     
		     }
		   
		    
	     }); 
	});
})
</script>
<div class="pageContent">
<c:if test="${user.id==null }">
		<form method="post" action="admin/user/add?navTabId=userNav" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">	    
 </c:if>
 <c:if test="${user.id!=null }">
		<form method="post" action="admin/user/update?navTabId=userNav" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">	    
 </c:if>
	<div class="pageFormContent  nowrap" layoutH="56">
		<dl>
			<dt>用户名: </dt>
			<dd><input type="text" name="userName" value="${user.username}" class="required" maxlength="20"/></dd>
		</dl>
		<c:if test="${user.id==null }">
		   <dl>
			<dt>密码: </dt>
			<dd><input type="text" id="password" name="password" value="${user.username}" class="textInput valid required" minlength="5"/></dd>
			</dl>
			<dl>
				<dt>确认密码: </dt>
				<dd><input type="text" name="password2" value="${user.username}" equalTo="#password" class="textInput valid required" minlength="5"/></dd>
			</dl>
		</c:if>
		<dl>
			<dt>姓名: </dt>
			<dd><input type="text" name="realName"  value="${user.realName}"/></dd>
		</dl><br/>
        
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit" >保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
