<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script src="${ctx}/js/jquery-1.8.3.min.js"></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx}/factoryc/goInsertFactoryc','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('${ctx}/factoryc/goUpdateFactoryc','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('${ctx}/factoryc/deleteFactoryc','_self');this.blur();">删除</a></li>
<li id="delete1"><a href="#" onclick="formSubmit('${ctx}/factoryc/deleteFactorycs','_self');this.blur();">删除N</a></li>
<li id="new1"><a href="#" onclick="formSubmit('${ctx}/factoryc/startFactorycByIds','_self');this.blur();">启用</a></li>
<li id="new2"><a href="#" onclick="formSubmit('${ctx}/factoryc/stopFactorycByIds','_self');this.blur();">停用</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    生产厂家列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<th class="tableHeader"><input type="checkbox" id="quanxuan" name="selid" onclick="changeState(this.checked)"></th>
		<th class="tableHeader">序号</th>
		<th class="tableHeader">厂家全称</th>
		<th class="tableHeader">缩写</th>
		<th class="tableHeader">联系人</th>
		<th class="tableHeader">电话</th>
		<th class="tableHeader">手机</th>
		<th class="tableHeader">传真</th>
		<th class="tableHeader">验货员</th>
		<th class="tableHeader">状态</th>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="factoryId" value="${o.factoryId}"/></td>
		<td>${status.index+1}</td>
		<td><a href="${ctx}/factoryc/findFactorycById?factoryId=${o.factoryId}">${o.fullName}</a></td>
		<td>${o.factoryName}</td>
		<td>${o.contactor}</td>
		<td>${o.phone}</td>
		<td>${o.mobile}</td>
		<td>${o.fax}</td>
		<td>${o.inspector}</td>
		<td>
			<c:if test="${o.state==1}"><a href="${ctx}/factoryc/stopFactoryc?id=${o.factoryId}"><font color="green">启用</font></a></c:if>
			<c:if test="${o.state==2}"><a href="${ctx}/factoryc/startFactoryc?id=${o.factoryId}">停用</a></c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>

</form>
</body>
<script language="JavaScript" type="text/javascript">
	function changeState(isChecked)
	{
		var chk_list=document.getElementsByTagName("input");
		for(var i=0;i<chk_list.length;i++)
		{
			if(chk_list[i].type=="checkbox")
			{
				chk_list[i].checked=isChecked;
			}
		}
	}
	$(function () {
		$("#delete").click(function () {
			xuanze();
		});
		$("#delete1").click(function () {
			xuanze();
		});
		$("#update").click(function () {
			xuanze();
		});
		$("#new1").click(function () {
			xuanze();
		});
		$("#new2").click(function () {
			xuanze();
		});
		function xuanze() {
			var a = $("td>input:checked");
			if (a.length==0) {
				alert("至少选择一个");
				window.location.href = "${ctx}/factoryc/findFactorycAll";
			}
		}
	});

</script>
</html>

