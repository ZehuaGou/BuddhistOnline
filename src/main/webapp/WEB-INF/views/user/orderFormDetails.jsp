<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>订单详情</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/user/ico/favicon.ico"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/common/orderFormDetails.css"/>
</head>
<body>

<div class="register">
  <br/><br/><br/>
  <div class="container">
    <p class="register-p">订单详情</p>
    <div class="jumbotron small-jumbotron">
      <div class="form-horizontal">

        <input type="hidden" id="contextPath" value="${pageContext.request.contextPath}">
        <input type="hidden" id="oid" name="oid" value="${orderForm.oid}"/>
        <input type="hidden" id="did" name="did" value="${orderForm.did}"/>


        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">佛事名称：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">${orderForm.inventory.designation.name}</span>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">发布人：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">${orderForm.inventory.user.name}</span>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">价格：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">${orderForm.inventory.designation.price}</span>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">回向文1：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">${orderForm.answerOne}</span>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">回向文2：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">${orderForm.answerTwo}</span>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">特殊要求：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">${orderForm.require}</span>
          </div>
        </div>


        <%--如果身份为用户则只能看到直播链接，修士则可以修改直播链接--%>
        <c:if test="${sessionScope.existUser.identify == 'Y'}">
          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">直播链接：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
              <a href="http://${orderForm.playUrl}" target="_blank">
                  ${orderForm.playUrl}
              </a>
            </span>
            </div>
          </div>
        </c:if>
        <c:if test="${sessionScope.existUser.identify == 'X'}">
          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">直播链接：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
              <input type="text" class="form-control" id="playUrl" name="playUrl"
                     value="${orderForm.playUrl}" title="">
            </span>
            </div>
          </div>
        </c:if>

        <%--身份为施主则可以看到修士手机号，身份为修士则可以看到用户手机号--%>
        <c:if test="${sessionScope.existUser.identify == 'Y'}">
          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">修士手机号：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.monkUser.phone}
            </span>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">修士姓名：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.monkUser.name}
            </span>
            </div>
          </div>
        </c:if>
        <c:if test="${sessionScope.existUser.identify == 'X'}">
          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">施主手机号：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.donorUser.phone}
            </span>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">施主姓名：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.donorUser.name}
            </span>
            </div>
          </div>
        </c:if>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">最早时间：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
              <fmt:formatDate value="${orderForm.inventory.earlyTime}" pattern="yyyy-MM-dd HH:mm"/>
            </span>
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">最晚时间：</label>
          <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
              <fmt:formatDate value="${orderForm.inventory.lateTime}" pattern="yyyy-MM-dd HH:mm"/>
            </span>
          </div>
        </div>

        <%--如果该订单没完成--%>
        <c:if test="${orderForm.finish == 'N'}">

          <%--
            如果该订单已被指定则可以评价，打分，选择是否完成
            如果该订单没被指定则只能选择是否指定此订单
        --%>
          <c:choose>
            <%--如果是此订单被接受则显示如下信息--%>
            <c:when test="${orderForm.flag == 'Y' && orderForm.message == ''}">

              <%--身份是施主则可以评价评分，身份是修士则只能修改直播链接--%>
              <c:if test="${sessionScope.existUser.identify == 'X'}">

                <div id="re-div">
                  <button id="updateSubmit" class="btn btn-info register-btn">修改</button>
                  <br/><br/>
                </div>

              </c:if>
              <c:if test="${sessionScope.existUser.identify == 'Y'}">

                <div class="form-group">
                  <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">评分：</label>
                  <div class="col-md-8 col-sm-7 col-xs-7">
                    <select name="grade" class="form-control" id="grade" title="">
                      <c:forEach var="i" begin="1" end="5" step="1">
                        <option value="${i}">
                            ${i}
                        </option>
                      </c:forEach>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">评价：</label>
                  <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                <input type="text" class="form-control" name="evaluate" title="" id="evaluate"/>
            </span>
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">说明：</label>
                  <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                <input type="text" class="form-control" name="explain" title="" id="explain"/>
            </span>
                  </div>
                </div>

                <div id="re-div">
                  <button class="btn btn-info register-btn" id="paySubmit">
                    支付
                  </button>
                  <br/><br/>
                </div>
              </c:if>
            </c:when>

            <%--如果此订单没被接受则显示如下信息--%>
            <c:when test="${orderForm.flag == 'Y' && orderForm.message != ''}">
              <div class="form-group">
                <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">回复消息：</label>
                  <%--修士只能看到评分，施主可以进行评分--%>
                <c:if test="${sessionScope.existUser.identify == 'X'}">
                  <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.message}
            </span>
                  </div>
                </c:if>
                <c:if test="${sessionScope.existUser.identify == 'Y'}">
            <span>
                <select name="grade" style="font-size: 30px; margin-top: 10px; padding: 10px" title="">
                  <c:forEach var="i" begin="1" end="5" step="1">
                    <option value="${i}"
                            <c:if test="${orderForm.grade == i}">selected</c:if> >
                        ${i}
                    </option>
                  </c:forEach>
              </select>
            </span>
                </c:if>
              </div>
            </c:when>

          </c:choose>

          <%--如果是施主则可以选择指定此单，并回复其他订单信息--%>
          <c:if test="${orderForm.flag == 'N' && sessionScope.existUser.identify == 'Y'}">

            <div class="form-group">
              <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">特殊要求：</label>
              <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
              <input type="text" class="form-control" id="require" name="require"
                     value="${orderForm.require}" title="">
            </span>
              </div>
            </div>

            <div class="form-group">
              <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">回复其他订单：</label>
              <div class="col-md-8 col-sm-7 col-xs-7 re-large">
                  <span class="re-col">
                   <input type="text" class="form-control" id="message" name="message" title=""/>
                  </span>
              </div>
            </div>

            <div id="re-div">
              <button id="acceptSubmit" class="btn btn-info register-btn">接受订单</button>
              <br/><br/>
            </div>

          </c:if>

        </c:if>

        <%--如果该订单已完成--%>
        <c:if test="${orderForm.finish == 'Y'}">
          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">评分：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.grade}
            </span>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 col-sm-5 col-xs-5 control-label lab re-large">评价：</label>
            <div class="col-md-8 col-sm-7 col-xs-7 re-large">
            <span class="re-col">
                ${orderForm.evaluate}
            </span>
            </div>
          </div>
        </c:if>

      </div>

    </div>
  </div>
  <br/><br/><br/><br/><br/><br/><br/>
</div>

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
<script src="${pageContext.request.contextPath}/resources/user/js/self/orderFormDetails.js">
</script>
<script type="text/javascript">

</script>
</body>
</html>

