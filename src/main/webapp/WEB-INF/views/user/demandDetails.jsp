<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>佛事详情页</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/index.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/registered.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/demandDetails.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
</head>
<body>

<div class="cargo-top">
  <!--<img src="images/cargo-top.jpg" />-->
  <div class="container">
    <br/><br/>
    <p class="lg-title">有因有缘集世间，有因有缘世间集；有因有缘灭世间，有因有缘世间灭。</p>
    <p class="sm-title">善待当下,缘由心生</p>
    <br/><br/>

  </div>
</div>

<div class="cargo-body">
  <div class="ca-by-top">
    <a href="${pageContext.request.contextPath}/index">首页</a>
    <span> &nbsp;&nbsp;&nbsp;&nbsp;${inventory.designation.classify.typeOne} >> ${inventory.designation.classify.name}</span>
  </div>
  <div class="container">
    <div class="row cargo-row">
      <div class="col-md-6 col-sm-6">
        <img src="${pageContext.request.contextPath}/resources/user/images/cargo-by-1.jpg" class="img-responsive"/>
      </div>
      <div class="col-md-6 col-sm-6 col-world">
        <div class="">
          <div class="col-md-4 col-sm-4 col-xs-4 xinxi">发布时间:</div>
          <div class="col-md-8 col-sm-8 col-xs-8 xinxi">
            <fmt:formatDate value="${inventory.publishTime}" pattern="yyyy-MM-dd HH:mm"/>
          </div>
        </div>

        <div>
          <div class="col-md-4 col-sm-4 col-xs-4 xinxi">佛事名称：</div>
          <div class="col-md-8 col-sm-8 col-xs-8 xinxi">
            ${inventory.designation.name}
          </div>
        </div>

        <div>
          <div class="col-md-4 col-sm-4 col-xs-4 xinxi">发布人：</div>
          <div class="col-md-8 col-sm-8 col-xs-8 xinxi">
            ${inventory.user.name}
          </div>
        </div>

        <div>
          <div class="col-md-4 col-sm-4 col-xs-4 xinxi">价格：</div>
          <div class="col-md-8 col-sm-8 col-xs-8 xinxi">
            ${inventory.designation.price}
          </div>
        </div>

        <div>
          <div class="col-md-4 col-sm-4 col-xs-4 xinxi">最早时间 ：</div>
          <div class="col-md-8 col-sm-8 col-xs-8 xinxi">
            <fmt:formatDate value="${inventory.earlyTime}" pattern="yyyy-MM-dd HH:mm"/>
          </div>
        </div>

        <div>
          <div class="col-md-4 col-sm-4 col-xs-4 xinxi">最晚时间 ：</div>
          <div class="col-md-8 col-sm-8 col-xs-8 xinxi">
            <fmt:formatDate value="${inventory.lateTime}" pattern="yyyy-MM-dd HH:mm"/>
          </div>
        </div>

        <p></p>
        <div >
          <p>详细内容：</p>
          <p>
            ${inventory.content}
          </p>
        </div>

        <button class="btn btn-danger ca-button"
                onclick="window.open('${pageContext.request.contextPath}/orderForm/jumpAddOrderForm/${inventory.iid}')">
          下订单
        </button>
      </div>
    </div>
    <br/>
    <hr/>
  </div>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="row">
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav bottom-nav-one">
      <a href="${pageContext.request.contextPath}/index"><span class="glyphicon glyphicon-home"></span>
        <p>首页</p></a>
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
        <p>我的订单</p></a>
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


