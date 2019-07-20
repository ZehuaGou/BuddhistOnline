<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>注册</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/registered.css"/>
</head>
<body>
<nav class="navbar navbar-default nav-top">
  <div class="container">
    <div class="navbar-header">
      <a href="${pageContext.request.contextPath}/index" class="navbar-brand top-word">
        在线佛事
      </a>
      <span class="navbar-toggle glyphicon glyphicon-user" data-toggle="collapse"  id="collapse"
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
  <br/><br/><br/>
  <div class="container">
    <p class="register-p">会员注册 / REGISTERED</p>
    <div class="jumbotron small-jumbotron">
      <form class="form-horizontal"
            action="${pageContext.request.contextPath}/user/saveUser"
            method="post">
        <input type="hidden" id="contextPath" value="${pageContext.request.contextPath}"/>

        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-12 control-label lab">真实姓名：</label>
          <div class="col-md-8 col-sm-8 col-xs-10">
            <input type="text" class="form-control re-col" placeholder="真实姓名" id="name" name="name"/>
          </div>
        </div>
        <div id="name-div"></div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-12 control-label lab">密码：</label>
          <div class="col-md-8 col-sm-8 col-xs-10">
            <input type="password" class="form-control re-col" placeholder="密码" id="password" name="password"/>
          </div>
        </div>
        <div id="password-div"></div>


        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-12 control-label lab">确认密码：</label>
          <div class="col-md-8 col-sm-8 col-xs-10">
            <input type="password" class="form-control re-col" placeholder="确认密码" id="rePassword"/>
          </div>
        </div>
        <div id="rePassword-div"></div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-12 control-label lab">身份证号：</label>
          <div class="col-md-8 col-sm-8 col-xs-10">
            <input type="text" class="form-control re-col" placeholder="身份证号" id="idCard" name="idCard"/>
          </div>
        </div>
        <div id="idCard-div"></div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-12 control-label lab">手机号：</label>
          <div class="col-md-8 col-sm-8 col-xs-10">
            <input type="text" class="form-control re-col" placeholder="手机号" id="phone" name="phone"/>
          </div>
        </div>
        <div id="phone-div"></div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-4 control-label lab">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
          <div class="col-md-8 col-sm-8 col-xs-8 radio">
            <label class="radio-inline re-col2">
              <input type="radio" name="sex" value="男" class="input-re-col2" checked title="男"/> 男
            </label>
            <label class="radio-inline re-col2">
              <input type="radio" name="sex" value="女" class="input-re-col2" title="女"/> 女
            </label>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4 col-xs-4 control-label lab">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
          <div class="col-md-8 col-sm-8 col-xs-8 radio">
            <label class="radio-inline re-col2">
              <input type="radio" name="identify" value="Y" class="input-re-col2" checked title="施主"/> 施主
            </label>
            <label class="radio-inline re-col2">
              <input type="radio" name="identify" value="X" class="input-re-col2" title="修士"/> 修士
            </label>
          </div>
        </div>

        <div id="re-div">
          <button type="submit" class="btn btn-info register-btn" id="submit" disabled>
            注册
          </button>
          <br/><br/>
          <p><a href="${pageContext.request.contextPath}/user/jumpLogin" class="tishi">已有账号 ？ 立即登录 >></a></p>
        </div>
      </form>

    </div>
  </div>
  <br/><br/><br/><br/><br/><br/><br/>
</div>

<script src="${pageContext.request.contextPath}/resources/user/jQuery/jquery.min.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/common/bootstrap.min.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/self/registered.js">
</script>
<script type="text/javascript">

</script>
</body>
</html>

