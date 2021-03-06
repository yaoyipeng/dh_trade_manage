<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
<li id="update"><a href="#" onclick="formSubmit('${ctx}/exportc/goUpdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx}/exportc/submit','_self');this.blur();">上报</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx}/exportc/cancel','_self');this.blur();">取消</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx}/packingListC/tocreate','_self');this.blur();">装箱</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    出口报运列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('exportId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">合同或确认书号</td>
		<td class="tableHeader">信用证号</td>
		<td class="tableHeader">货物数/附件数</td>
		<td class="tableHeader">收货人及地址</td>
		<td class="tableHeader">装运港</td>
		<td class="tableHeader">目的港</td>
		<td class="tableHeader">运输方式</td>
		<td class="tableHeader">价格条件</td>
		<td class="tableHeader">制单日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${pageInfo.list}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="exportId" value="${o.exportId}"/></td>
		<td>${status.index+1}</td>
		<td><a href="toview.action?id=${o.exportId}">${o.customerContract}</a></td>
		<td>${o.lcno}</td>
		<td align="center">${o.cpnum}/${o.extnum}</td>
		<td>${o.consignee}</td>
		<td>${o.shipmentPort}</td>
		<td>${o.destinationPort}</td>
		<td>${o.transportMode}</td>
		<td>${o.priceCondition}</td>
		<td><fmt:formatDate value="${o.inputDate}" pattern="yyyy-MM-dd"/></td>
		<td>
			<c:if test="${o.state==1}"><font color="green">已上报</font></c:if>
			<c:if test="${o.state==0}">草稿</c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
	<div class="box-footer">
		<div class="pull-left">
			<div class="form-group form-inline">
				总共${pageInfo.pages}页，共${pageInfo.total}条数据。 每页4
				<%--<select class="form-control" id="changePageSize" onchange="changePageSize()">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>--%> 条
			</div>
			<a href="${ctx}/exportc/list?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
			<a href="${ctx}/exportc/list?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
			<c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
				<a href="${ctx}/exportc/list?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
			</c:forEach>
			<a href="${ctx}/exportc/list?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
			<a href="${ctx}/exportc/list?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
		</div>

	</div>
</div>
 
</div>


</form>
<script>
    function changePageSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();

        //向服务器发送请求，改变没页显示条数
        window.location.href = "${ctx}exportc/list?page=1&size="
            + pageSize;

    }
</script>
</body>
</html>

