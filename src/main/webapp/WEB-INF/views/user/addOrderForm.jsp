<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>下单页</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/addOrderForm.css"/>
</head>
<body>
<div class="car-top">
  <span> 确认订单信息</span>
</div>

<div class="or-su-body">
  <div class="container">

    <form action="${pageContext.request.contextPath}/orderForm/addOrderForm" method="post">
      <input type="hidden" id="did" value="${inventory.did}">

      <c:if test="${sessionScope.existUser.identify == 'X'}">
        <input type="hidden" name="xid" value="${sessionScope.existUser.uid}">
        <input type="hidden" name="sid" value="${inventory.uid}">
      </c:if>
      <c:if test="${sessionScope.existUser.identify == 'Y'}">
        <input type="hidden" name="sid" value="${sessionScope.existUser.uid}">
        <input type="hidden" name="xid" value="${inventory.uid}">
      </c:if>

      <input type="hidden" name="did" value="${inventory.designation.did}">


      <table class="table table-striped order-table">

        <tr>
          <th class="th0"></th>
          <th class="th1">佛事名称</th>
          <th class="th2">价格</th>
          <th class="th3">最早时间</th>
          <th class="th4">最晚时间</th>
        </tr>

        <tr>
          <td></td>
          <td>${inventory.designation.name}</td>
          <td>${inventory.designation.price}</td>
          <td class="td3">
            <fmt:formatDate value="${inventory.earlyTime}" pattern="yyyy-MM-dd HH:mm"/>
          </td>
          <td>
            <fmt:formatDate value="${inventory.lateTime}" pattern="yyyy-MM-dd HH:mm"/>
          </td>
        </tr>

        <tr>
          <td></td>
          <td>回向文1</td>
          <td></td>
          <td colspan="2">
            <input type="text" name="answerOne" title=""/>
          </td>
        </tr>

        <tr>
          <td></td>
          <td>回向文2</td>
          <td></td>
          <td colspan="2">
            <input type="text" name="answerTwo" title=""/>
          </td>
        </tr>

        <%--如果是施主就显示特殊要求输入框--%>
        <c:if test="${sessionScope.existUser.identify == 'Y'}">
          <tr>
            <td></td>
            <td>特殊要求</td>
            <td></td>
            <td colspan="2">
              <input type="text" name="require" title=""/>
            </td>
          </tr>
        </c:if>

        <%--如果是修士就显示直播链接输入框--%>
        <c:if test="${sessionScope.existUser.identify == 'X'}">
          <tr>
            <td></td>
            <td>直播链接</td>
            <td></td>
            <td colspan="2">
              <input type="text" name="playUrl" title=""/>
            </td>
          </tr>
        </c:if>

        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td>
            <button type="submit" class="btn btn-danger">提交订单</button>
          </td>
        </tr>

      </table>
    </form>
    <br/>
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

