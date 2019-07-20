$(function () {
    /*
    * 点击修改按钮通过json传值修改直播地址
    * */
    $("#updateSubmit").bind("click", function () {

        var contextPath = $("#contextPath").val();

        var orderForm = {
            "playUrl": $("#playUrl").val(),
            "oid": $("#oid").val()
        };

        var returnVal = {
            "orderForm": orderForm
        };

        $.ajax({
            url: contextPath + "/orderForm/updateOrderForm",
            dateType: "json",
            contentType: "application/json;charset=utf-8",
            type: "post",
            data: JSON.stringify(returnVal),
            success: function (data) {
                window.location.href = contextPath + data;
            },
            error: function () {
                alert("提交异常！");
            }
        });

    });

    /*
    * 点击支付按钮进行支付
    * */
    $("#paySubmit").bind("click", function () {

        var contextPath = $("#contextPath").val();

        var orderForm = {

            "oid": $("#oid").val(),
            "grade": $("#grade").val(),
            "evaluate": $("#evaluate").val()
        };

        var bill = {

            "oid": $("#oid").val(),
            "did": $("#did").val(),
            "explain": $("#explain").val()
        };

        var returnVal = {
            "orderForm": orderForm,
            "bill": bill
        };

        $.ajax({
            url: contextPath + "/bill/addBill",
            dateType: "json",
            contentType: "application/json;charset=utf-8",
            type: "post",
            data: JSON.stringify(returnVal),
            success: function (data) {
                window.location.href = contextPath + data;
            },
            error: function () {
                alert("提交异常！");
            }
        });

    });

    /*
    * 点击接受订单按钮，接受此订单
    * */
    $("#acceptSubmit").bind("click", function () {

        var contextPath = $("#contextPath").val();

        var orderForm = {
            "oid": $("#oid").val(),
            "require": $("#require").val(),
            "message": $("#message").val(),
            "did": $("#did").val()
        };

        var returnVal = {
            "orderForm": orderForm
        };

        $.ajax({
            url: contextPath + "/orderForm/confirmOrderForm",
            dateType: "json",
            contentType: "application/json;charset=utf-8",
            type: "post",
            data: JSON.stringify(returnVal),
            success: function (data) {
                window.location.href = contextPath + data;
            },
            error: function () {
                alert("提交异常！");
            }
        });

    });

});