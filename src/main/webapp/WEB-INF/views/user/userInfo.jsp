<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>账号</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/userInfo.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
</head>
<body>
<div class="myself-top">
  <span>账号管理</span>
</div>
<div class="my-pc">
  <div class="container">
    <div class="left">

      <table class="table table-striped table-bordered">
        <tr>
          <td>个人信息</td>
        </tr>
        <tr>
          <td>
            <span><a href="${pageContext.request.contextPath}/user/jumpEditUserInfo"> 修改信息</a></span>
          </td>
        </tr>
        <c:if test="${sessionScope.existUser.identify == 'X'}">
          <tr>
            <td>我的身份：修士</td>
          </tr>
          <tr>
            <td>施修单数：${sessionScope.existUser.acceptOrds}</td>
          </tr>
          <tr>
            <td>施修金额：${sessionScope.existUser.acceptMoney}</td>
          </tr>
          <tr>
            <td>
              <%--如果接单数为0，星级就直接显示为0--%>
              <c:if test="${sessionScope.existUser.acceptOrds == 0}">
                施修星级：0
              </c:if>
              <c:if test="${sessionScope.existUser.acceptOrds > 0}">
                施修星级：
                <fmt:formatNumber value="${sessionScope.existUser.grade / sessionScope.existUser.acceptOrds}"
                                  pattern="#,#0.0#">

                </fmt:formatNumber>
              </c:if>
            </td>
          </tr>
        </c:if>
        <c:if test="${sessionScope.existUser.identify == 'Y'}">
          <tr>
            <td>我的身份：施主</td>
          </tr>
          <tr>
            <td>布施单数：${sessionScope.existUser.donationOrds}</td>
          </tr>
          <tr>
            <td>布施金额：${sessionScope.existUser.donationMoney}</td>
          </tr>
        </c:if>

      </table>
    </div>
    <div class="right">
      <div class="right-top">
        <div class="t-top">
          <div class="t-top-left">
            <img src="${pageContext.request.contextPath}/resources/user/images/cargo-by-3.jpg"/>
            <p>${sessionScope.existUser.name}</p>
          </div>
          <div class="t-top-right">
            <span>绑定手机号：</span>
            <p>${sessionScope.existUser.phone}</p>
          </div>
        </div>
        <div style="clear: both;"></div>
        <div class="t-bottom">
          <div class="row">
            <div class="col-md-5 col-xs-5 ro-name">
              注册时间
            </div>
            <div class="col-md-6 col-xs-6 ro-name">
              身份证号
            </div>

          </div>
          <div class="row">
            <div class="col-md-5 col-xs-5 ro-name">
              <fmt:formatDate value="${sessionScope.existUser.rTime}" pattern="yyyy-MM-dd"/>
            </div>
            <div class="col-md-6 col-xs-6 ro-name">
              ${sessionScope.existUser.idCard}
            </div>

          </div>
        </div>
      </div>
      <div class="right-center">
        <p><b>历史账单</b></p>
        <table class="table table-striped table-bordered table-hover">
          <thead>
          <tr>
            <th>佛事名称</th>
            <th>交易价格</th>
            <th>简单介绍</th>
            <th>说明</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${billList}" var="bill">
            <tr class="info">
              <td>${bill.inventory.designation.name}</td>
              <td>${bill.reality}</td>
              <td>${bill.inventory.designation.content}</td>
              <td>
                ${bill.explain}
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>

        <div class="ann">

          <span>第${pageInfo.pageNum}/${pageInfo.lastPage}页</span>&nbsp;&nbsp;
          <span>总记录数：${pageInfo.total}&nbsp;&nbsp;每页显示:
        ${pageInfo.pageSize}
      </span>&nbsp;&nbsp;
          <span>

      <c:if test="${pageInfo.pageNum > 1}">
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/user/userInfo/1'">
          首页
        </button>
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/user/userInfo/${pageInfo.pageNum - 1}'">
          上一页
        </button>
      </c:if>
      <c:if test="${pageInfo.pageNum < pageInfo.lastPage}">
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/user/userInfo/${pageInfo.pageNum + 1}'">
          下一页
        </button>
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/user/userInfo/${pageInfo.lastPage}'">
          尾页
        </button>
      </c:if>
        </div>

      </div>
    </div>
  </div>
</div>
<br/><br/><br/><br/>
<br/><br/><br/><br/>
<br/><br/><br/><br/>
<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="row">
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav">
      <a href="${pageContext.request.contextPath}/index"><span class="glyphicon glyphicon-home"></span>
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
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav bottom-nav-one">
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

