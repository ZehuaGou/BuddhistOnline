<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>需求</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/addDemand.css"/>
</head>
<body>

<div class="register">
  <br/><br/><br/>
  <div class="container">
    <p class="register-p">发布需求</p>
    <div class="jumbotron small-jumbotron">
      <form class="form-horizontal"
            action="${pageContext.request.contextPath}/demand/addDemand"
            method="post">

        <input type="hidden" id="contextPath" value="${pageContext.request.contextPath}">

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">大分类：</label>
          <div class="col-md-8 col-sm-8 ">
            <select class="form-control re-sel" id="typeOne" title="">
              <option value="0">--请选择--</option>
              <option value="1">寺院佛事</option>
              <option value="2">其他佛事</option>
              <option value="3">个人修持佛事</option>
            </select>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">小分类：</label>
          <div class="col-md-8 col-sm-8 ">
            <select class="form-control re-sel" id="typeTwo" name="cid" title="">
            </select>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">佛事名称：</label>
          <div class="col-md-8 col-sm-8 ">
            <input type="text" class="form-control re-col" placeholder="佛事名称"
            id="name">
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">最早时间：</label>
          <div class="col-md-8 col-sm-8 ">
            <input type="text" class="form-control re-col" placeholder="最早时间"
                   data-options="{'type':'YYYY-MM-DD hh:mm:ss','beginYear':2010,'endYear':2088}"
            id="earlyTime"/>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">最晚时间：</label>
          <div class="col-md-8 col-sm-8 ">
            <input type="text" class="form-control re-col" placeholder="最晚时间"
                   data-options="{'type':'YYYY-MM-DD hh:mm:ss','beginYear':2010,'endYear':2088}"
            id="lateTime"/>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">简单说明：</label>
          <div class="col-md-8 col-sm-8 ">
            <input type="text" class="form-control re-col" placeholder="简单说明" id="d-content">
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">详细说明：</label>
          <div class="col-md-8 col-sm-8 ">
            <input type="text" class="form-control re-col" placeholder="详细说明" id="i-content">
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">布施金额：</label>
          <div class="col-md-8 col-sm-8 ">
            <input type="text" class="form-control re-col" placeholder="布施金额" id="price">
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-4  control-label lab">自动指派：</label>
          <div class="col-md-8 col-sm-8 ">
            <select class="form-control re-sel" title="" id="assign">
              <option value="Y">是</option>
              <option value="N">否</option>
            </select>
          </div>
        </div>

        <div id="re-div">
          <button type="button" class="btn btn-info register-btn" id="submit">
            发布需求
          </button>
          <br/><br/>
        </div>

      </form>


    </div>
  </div>
  <br/><br/><br/><br/><br/><br/><br/>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="row">
    <div class="col-lg-3 col-md-3 col-xs-3 bottom-nav">
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
<script src="${pageContext.request.contextPath}/resources/user/jQuery/jqueryDate/jquery.date.js">
</script>
<script src="${pageContext.request.contextPath}/resources/user/js/self/addDemand.js">
</script>
<script type="text/javascript">
    $.date("#earlyTime");
    $.date("#lateTime");
</script>
</body>
</html>

