<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript">
    	//设置冗余的生产厂家名称
    	function setFactoryName(val){
    		var ele = document.getElementById("factoryName");
    		ele.value = val;
    	}
    </script>
</head>
<body>
<form method="post">
<%--	<input type="hidden" name="contractProductId" value="${o.contractProductId}">--%>
	<input type="text" name="contractId" value="${contractId}"/>
	<input type="text" name="contractProductId" value="${pro.contractProductId}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<%--	<li id="save"><a href="#" onclick="formSubmit('${ctx}/con/updateCon','_self');this.blur();">确定</a></li>--%>
<li id="save"><a href="#" onclick="formSubmit('${ctx}/contractProductC/updateContractProductC','_self');">确定</a></li>
<li id="back"><a href="${ctx}/contractProductC/findAllByContractId?contractId=${contractId}">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增货物信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent">
	            	<select name="factoryId" onchange="setFactoryName(this.options[this.selectedIndex].text);">
	            		<c:forEach items="${factoryList}" var="f">
								<option
									<c:if test="${pro.factoryId==f.factoryId}"> selected</c:if> value="${f.factoryId}">
										${f.fullName}
								</option>
						</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="productNo" value="${pro.productNo}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">货物照片：</td>
	            <td class="tableContent"><input type="text" name="productImage" value="${pro.productImage}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${pro.cnumber}"/></td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packingUnit" value="${pro.packingUnit}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">装率：</td>
	            <td class="tableContent"><input type="text" name="loadingRate" value="${pro.loadingRate}"/></td>
	            <td class="columnTitle_mustbe">箱数：</td>
	            <td class="tableContent"><input type="text" name="boxNum" value="${pro.boxNum}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value="${pro.price}"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value="${pro.orderNo}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContent"><textarea name="productDesc" style="height:120px;">${pro.productDesc}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
</form>
</body>
</html>

