<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>登录</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/login.css"/>
</head>
<body>
<nav class="navbar navbar-default nav-top">
  <div class="container">
    <div class="navbar-header">
      <a href="${pageContext.request.contextPath}/index" class="navbar-brand top-word">
        在线佛事
      </a>
      <span class="navbar-toggle glyphicon glyphicon-user" data-toggle="collapse" id="collapse"
            data-target="#navbar-collapse"></span>
    </div>

    <div class="collapse navbar-collapse" id="navbar-collapse">
      <ul class="nav navbar-nav navbar-right top-word2">
        <li><a href="${pageContext.request.contextPath}/user/jumpLogin">登录</a></li>
        <li><a href="${pageContext.request.contextPath}/user/registered">注册</a></li>
      </ul>
    </div>

  </div>

</nav>


<div class="register">
  <br/><br/>
  <div class="container">
    <br/><br/><br/><br/>
    <p class="register-p">会员登录 / LOGIN</p>

    <div class="jumbotron small-jumbotron">
      <form action="${pageContext.request.contextPath}/user/checkUser"
            method="post">
        <div class="input-group group">
          <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
          <input type="text" class="form-control" placeholder="请输入手机号" name="phone"/>
        </div>

        <div class="input-group group">
          <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
          <input type="password" class="form-control" placeholder="请输入密码" name="password"/>
        </div>
        <div style="text-align: center; color: red">${message}</div>

        <button type="submit" class="btn btn-info register-btn">登录</button>
      </form>

      <p>
        <a href="#" class="tishi">忘记密码 ？</a>
        <a href="${pageContext.request.contextPath}/user/registered" class="tishi">还没有账号 ？ 立即注册 >></a>
      </p>
    </div>
  </div>
  <br/><br/><br/><br/><br/><br/><br/>
</div>

<script src="${pageContext.request.contextPath}/resources/user/jQuery/jquery.min.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/common/bootstrap.min.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/self/login.js">
</script>
<script type="text/javascript">

</script>
</body>
</html>
