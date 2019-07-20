<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>账号信息修改</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/userInfo.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <style>
    .right {
      border: 0;
    }

    .register-p {
      text-align: center;
      font-size: 20px;
      margin-bottom: 30px;
    }

    .register-btn {
      width: 100%;
      margin-top: 20px;
    }
  </style>
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
          <td>
            <span>
              <a href="${pageContext.request.contextPath}/user/userInfo/1"> 我的账户</a>
            </span>
          </td>
        </tr>
        <tr>
          <td>
            修改信息
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
            <td>施修星级：${sessionScope.existUser.grade}</td>
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

      <p class="register-p">信息修改</p>
      <div class="jumbotron small-jumbotron">
        <form class="form-horizontal register-form"
              action="${pageContext.request.contextPath}/user/editUserInfo"
              method="post">

          <input type="hidden" id="contextPath" value="${pageContext.request.contextPath}"/>
          <input type="hidden" name="uid" value="${sessionScope.existUser.uid}"/>

          <div class="form-group">
            <label class="col-sm-4 col-xs-12 control-label lab">真实姓名:</label>
            <div class="col-sm-8 col-xs-11 re-input">
              <input type="text" class="form-control" placeholder="真实姓名"
                     id="name" name="name" value="${sessionScope.existUser.name}"/>
            </div>
          </div>
          <div id="name-div"></div>

          <div class="form-group">
            <label class="col-sm-4 col-xs-12 control-label lab">新密码:</label>
            <div class="col-sm-8 col-xs-11 re-input">
              <input type="password" class="form-control" placeholder="新密码"
                     id="password" name="password" value="${sessionScope.existUser.password}"/>
            </div>
          </div>
          <div id="password-div"></div>

          <div class="form-group">
            <label class="col-sm-4 col-xs-12 control-label lab">确认密码:</label>
            <div class="col-sm-8 col-xs-11 re-input">
              <input type="password" class="form-control" placeholder="确认密码"
                     id="rePassword" value="${sessionScope.existUser.password}"/>
            </div>
          </div>
          <div id="rePassword-div"></div>

          <div class="form-group">
            <label class="col-sm-4 col-xs-12 control-label lab">身份证号:</label>
            <div class="col-sm-8 col-xs-11 re-input">
              <input type="text" class="form-control" placeholder="身份证号"
                     id="idCard" name="idCard" value="${sessionScope.existUser.idCard}"/>
            </div>
          </div>
          <div id="idCard-div"></div>

          <div class="form-group">
            <label class="col-sm-4 col-xs-12 control-label lab">手机号:</label>
            <div class="col-sm-8 col-xs-11 re-input">
              <input type="text" class="form-control" placeholder="手机号"
                     id="phone" name="phone" value="${sessionScope.existUser.phone}"/>
            </div>
          </div>
          <div id="phone-div"></div>

          <div class="form-group">
            <label class="col-sm-4 col-xs-12 control-label lab">性别:</label>
            <div class="col-sm-8 col-xs-11">
              <label class="checkbox-inline re-co12">
              <input type="radio" name="sex" value="男" class="input-re-col2"
                      <c:if test="${sessionScope.existUser.sex == '男'}">checked</c:if>
                      title="男"/>&nbsp;男
              </label>
              <label class="checkbox-inline re-co12">
              <input type="radio" name="sex" value="女" class="input-re-col2"
                      <c:if test="${sessionScope.existUser.sex == '女'}">checked</c:if>
                      title="女"/>&nbsp;女
              </label>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 col-xs-12 control-label lab"></label>
            <div class="col-sm-9 col-xs-11 re-input">
              <button type="submit" class="btn btn-info register-btn" id="submit">修改</button>
            </div>
          </div>

        </form>
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
<script src="${pageContext.request.contextPath}/resources/user/js/self/editUserInfo.js">
</script>

<script type="text/javascript">

</script>
</body>
</html>

