<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>首页</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/index.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
</head>
<body>
<nav class="navbar navbar-default nav-top">
  <div class="container">
    <div class="navbar-header">
      <a href="${pageContext.request.contextPath}/index" class="navbar-brand top-word">
        在线佛事
      </a>
      <span class="navbar-toggle glyphicon glyphicon-user"
            data-toggle="collapse" data-target="#navbar-collapse" id="collapse"></span>
    </div>

    <div class="collapse navbar-collapse" id="navbar-collapse">
      <ul class="nav navbar-nav navbar-right top-word2">
        <c:choose>
          <c:when test="${empty sessionScope.existUser}">
            <li><a href="${pageContext.request.contextPath}/user/jumpLogin">登录</a></li>
            <li><a href="${pageContext.request.contextPath}/user/registered">注册</a></li>
          </c:when>
          <c:otherwise>
            <li><a href="${pageContext.request.contextPath}/demand/jumpAddDemand">发布需求</a></li>
            <li><a href="${pageContext.request.contextPath}/user/userInfo/1">${sessionScope.existUser.name}</a></li>
            <li><a href="${pageContext.request.contextPath}/user/quit">注销</a></li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>

  </div>

</nav>

<div class="carousel slide" id="myCarousel">
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to='0' class="active"></li>
    <li data-target="#myCarousel" data-slide-to='1'></li>
    <li data-target="#myCarousel" data-slide-to='2'></li>
  </ol>
  <div class="carousel-inner">
    <div class="item active" style="background-color: #C6742B;"><img
            src="${pageContext.request.contextPath}/resources/user/images/slide1.jpg" alt="1"/></div>
    <div class="item" style="background-color: #C6742B;"><img
            src="${pageContext.request.contextPath}/resources/user/images/slide2.jpg" alt="2"/></div>
    <div class="item" style="background-color: #020202;"><img
            src="${pageContext.request.contextPath}/resources/user/images/slide3.jpg" alt="3"/></div>
  </div>
  <a href="#myCarousel" data-slide='prev' class="carousel-control left">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a href="#myCarousel" data-slide='next' class="carousel-control right">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>

<div class="tab1">
  <div class="container">
    <h3>[在线佛事：佛事分类]</h3>
    <p class="tab1-p">你的一份信任，我们百倍回报。</p>
    <p class="tab1-title1">一. 寺院佛事 </p>
    <div class="row">
      <c:forEach items="${templeTypeList}" var="templeType" varStatus="status">
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6 col"
             onclick="window.open('${pageContext.request.contextPath}/demand/jumpDemandList/${templeType.cid}/1')">
          <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/resources/user/images/tab1-${status.index}.jpg" alt=""/>
            <div class="caption">
              <h4>${templeType.name}</h4>
              <p class="omit-text" title="${templeType.content}">${templeType.content}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>

    <p class="tab1-title1">二 . 个人修持佛事(为顾客量身定制)</p>
    <div class="row">
      <c:forEach items="${personalTypeList}" var="personalType" varStatus="status">
        <div class="col-md-12 col-sm-12"
             onclick="window.open('${pageContext.request.contextPath}/demand/jumpDemandList/${personalType.cid}/1')">
          <p class="tab1-p2">
            <a>
                ${status.index+1}).${personalType.name} ： ${personalType.content}
            </a>
          </p>
        </div>
      </c:forEach>
    </div>

    <p class="tab1-title1">三 . 其他常见佛事</p>
    <div class="row">
      <c:forEach items="${otherTypeList}" var="otherType" varStatus="status">
        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6 col"
             onclick="window.open('${pageContext.request.contextPath}/demand/jumpDemandList/${otherType.cid}/1')">
          <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/resources/user/images/tab2-${status.index}.jpg" alt=""/>
            <div class="caption">
              <h4>${otherType.name}</h4>
              <p class="omit-text">${otherType.content}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>

  </div>
</div>

<br/><br/><br/><br/><br/><br/><br/><br/>

<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="row">
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav bottom-nav-one">
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
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav">
      <a href="${pageContext.request.contextPath}/user/userInfo/1">
        <span class="glyphicon glyphicon-user">
        </span>
        <p>账号</p>
      </a>
    </div>
  </div>
</nav>

<script src="${pageContext.request.contextPath}/resources/user/jQuery/jquery.min.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/common/bootstrap.min.js">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/self/index.js">
</script>

<script type="text/javascript">
</script>

</body>
</html>