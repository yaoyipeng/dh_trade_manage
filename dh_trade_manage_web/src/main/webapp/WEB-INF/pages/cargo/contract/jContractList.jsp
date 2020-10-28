<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<li id="new"><a href="#" onclick="formSubmit('${ctx}/contractC/goinsertContractC','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('${ctx}/contractC/goupdateContractC','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('${ctx}/contractC/deleteContractCById','_self');this.blur();">删除</a></li>
<li id="new1"><a href="#" onclick="formSubmit('${ctx}/contractC/updateStateById','_self');this.blur();">上报</a></li>
<li id="new2"><a href="#" onclick="formSubmit('${ctx}/contractC/updateCancelStateById','_self');this.blur();">取消</a></li>
<li id="print"><a href="#" onclick="formSubmit('${ctx}/contractC/print','_self');this.blur();">打印</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx}/contractHisC/pigeinhole','_self');this.blur();">归档</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    购销合同列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<th class="tableHeader"><input type="checkbox" id="quanxuan"  name="selid" onclick="changeState(this.checked)"></th>
		<th class="tableHeader">序号</th>
		<th class="tableHeader">客户名称</th>
		<th class="tableHeader">合同号</th>
		<th class="tableHeader">货物数/附件数</th>
		<th class="tableHeader">制单人</th>
		<th class="tableHeader">审单人</th>
		<th class="tableHeader">验货员</th>
		<th class="tableHeader">签单日期</th>
		<th class="tableHeader">交货期限</th>
		<th class="tableHeader">船期</th>
		<th class="tableHeader">总金额</th>
		<th class="tableHeader">状态</th>
		<th class="tableHeader">操作</th>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="contractId" value="${o.contractId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.customName}</td>
		<td><a href="${ctx}/contractC/findContractCById?contractId=${o.contractId}">${o.contractNo}</a></td>
		<td>${o.cpnum}/${o.extnum}</td>
		<td>${o.inputBy}</td>
		<td>${o.checkBy}</td>
		<td>${o.inspector}</td>
		<td><fmt:formatDate value="${o.signingDate}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.deliveryPeriod}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.shipTime}" pattern="yyyy-MM-dd"/></td>
		<td>${o.totalAmount}</td>
		<td>
			<c:if test="${o.state==1}"><font color="green">已上报</font></c:if>
			<c:if test="${o.state==0}">草稿</c:if>
		</td>
		<td><a href="${ctx}/contractProductC/findAllByContractId?contractId=${o.contractId}" title="新增货物信息">[货物]</a></td>
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
				window.location.href = "${ctx}/contractC/findContractCAll";
			}
		}
	});

</script>
</html>

