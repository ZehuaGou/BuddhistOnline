<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>需求</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/index.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
</head>
<body>

<div class="tab1">
  <div class="container">

    <p class="tab1-p">你的一份信任，我们百倍回报。</p>

    <div class="row">
      <c:forEach items="${inventoryList}" var="inventory">
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6 col"
             onclick="window.open('${pageContext.request.contextPath}/demand/jumpDemandDetails/${inventory.iid}')">
          <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/resources/user/images/tab1-6.jpg" alt=""/>
            <div class="caption">
              <h4>${inventory.designation.name}</h4>
              <p class="omit-text" title="${inventory.designation.content}">
                  ${inventory.designation.content}
              </p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
    <div class="ann">

      <span>第${pageInfo.pageNum}/${pageInfo.lastPage}页</span>&nbsp;&nbsp;
      <span>总记录数：${pageInfo.total}&nbsp;&nbsp;每页显示:
        ${pageInfo.pageSize}
      </span>&nbsp;&nbsp;
      <span>

      <c:if test="${pageInfo.pageNum > 1}">
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpDemandList/${cid}/1'">
          首页
        </button>
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpDemandList/${cid}/${pageInfo.pageNum - 1}'">
          上一页
        </button>
      </c:if>
      <c:if test="${pageInfo.pageNum < pageInfo.lastPage}">
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpDemandList/${cid}/${pageInfo.pageNum + 1}'">
          下一页
        </button>
        <button class="btn btn-info ann-btn"
                onclick="window.location.href='${pageContext.request.contextPath}/demand/jumpDemandList/${cid}/${pageInfo.lastPage}'">
          尾页
        </button>
      </c:if>
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
<script type="text/javascript">

</script>
</body>
</html>