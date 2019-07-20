<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>我的需求</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/orderFormList.css"/>
</head>
<body>

<div class="car-top">
  <span> 我的需求</span>
</div>

<div class="or-su-body">
  <div class="container">

    <form class="">
      <table class="table table-striped order-table">
        <thead>
        <tr>
          <th class="th0"></th>
          <th class="th1">佛事名称</th>
          <th class="th2">价格</th>
          <th class="th3">是否已指定</th>
          <th class="th4">操作</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${inventoryList}" var="inventory" varStatus="status">
          <tr>
            <td class="td0">
                  ${status.index + 1}
            </td>
            <td>
              <a href="${pageContext.request.contextPath}/demand/jumpEditDemandDetails/${inventory.iid}">
                  ${inventory.designation.name}
              </a>
            </td>
            <td>${inventory.designation.price}</td>
              <%--标记为Y则显示被指定，标记为N则显示没被指定--%>
            <c:if test="${inventory.receive == 'Y'}">
              <td class="td3 td-green">是</td>
            </c:if>
            <c:if test="${inventory.receive == 'N'}">
              <td class="td3 td-red">否</td>
            </c:if>
            <td>
              <a href="${pageContext.request.contextPath}/demand/deleteMyDemandDetails/${inventory.iid}">
                删除
              </a>
            </td>
          </tr>
        </c:forEach>

        </tbody>

        <tfoot>

        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        </tfoot>
      </table>
    </form>
    <br/>

    <div class="ann">

      <span>第${pageInfo.pageNum}/${pageInfo.lastPage}页</span>&nbsp;&nbsp;
      <span>总记录数：${pageInfo.total}&nbsp;&nbsp;每页显示:
        ${pageInfo.pageSize}
      </span>&nbsp;&nbsp;
      <span>

      <c:if test="${pageInfo.pageNum > 1}">
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpMyDemandList/1'">
          首页
        </button>
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpMyDemandList/${pageInfo.pageNum - 1}'">
          上一页
        </button>
      </c:if>
      <c:if test="${pageInfo.pageNum < pageInfo.lastPage}">
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpMyDemandList/${pageInfo.pageNum + 1}'">
          下一页
        </button>
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpMyDemandList/${pageInfo.lastPage}'">
          尾页
        </button>
      </c:if>
    </div>

  </div>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/>
<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="row">
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav">
      <a href="${pageContext.request.contextPath}/index">
        <span class="glyphicon glyphicon-home"></span>
        <p>首页</p>
      </a>
    </div>
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav">
      <a href="${pageContext.request.contextPath}/demand/jumpMyDemandList/1">
        <span class="glyphicon glyphicon-th-list"></span>
        <p>我的需求</p>
      </a>
    </div>
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav bottom-nav-one">
      <a href="${pageContext.request.contextPath}/orderForm/jumpOrderFormList/1">
        <span class="glyphicon glyphicon-shopping-cart"></span>
        <p>我的订单</p>
      </a>
    </div>
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav">
      <a href="${pageContext.request.contextPath}/user/userInfo/1">
        <span class="glyphicon glyphicon-user"></span>
        <p>账号</p>
      </a>
    </div>
  </div>
</nav>

<script src="${pageContext.request.contextPath}/resources/user/jQuery/jquery.min.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/common/bootstrap.min.js">
</script>
<script type="text/javascript">
</script>
</body>
</html>

