$(function () {
    /*
    * 进行二级联动查询
    * */
    $("#typeOne").bind("mouseleave", function () {
        var type = $(this).val();
        var contextPath = $("#contextPath").val();

        $.ajax({
            url: contextPath + "/classify/searchTwoType",
            type: "get",
            timeout: "1000",
            data: {type: type},

            success: function (data) {

                if (data) {
                    data = eval("(" + data + ")");
                    $("#typeTwo").empty();

                    for (var i = 0; i < data.length; i++) {
                        var typeTwoId = data[i].cid;
                        var typeTwoName = data[i].name;
                        $("#typeTwo").append(
                            "<option value=" + typeTwoId + ">"
                            + typeTwoName + "</option>");
                    }
                }
            },
            error: function (XMLResponse) {
                alert(XMLResponse.responseText);
            }
        });
    });

    /*
    * 通过json进行表单提交
    * */
    $("#submit").bind("click", function () {
        var contextPath = $("#contextPath").val();

        var designation = {
            "cid": $("#typeTwo").val(),
            "name": $("#name").val(),
            "content": $("#d-content").val(),
            "price": $("#price").val()
        };

        var inventory = {
            "iid": $("#iid").val(),
            "did": $("#did").val(),
            "content": $("#i-content").val(),
            "assign": $("#assign").val(),
            "earlyTime": $("#earlyTime").val(),
            "lateTime": $("#lateTime").val()
        };

        var returnVal = {
            "designation": designation,
            "inventory": inventory
        };

        $.ajax({
            url: contextPath + "/demand/updateDemand",
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