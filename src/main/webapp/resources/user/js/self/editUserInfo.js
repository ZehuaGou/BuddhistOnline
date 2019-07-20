$(function () {

    var nameFlag = true;
    var passwordFlag = true;
    var rePasswordFlag = true;
    var idCardFlag = true;
    var phoneFlag = true;

    var contextPath = $("#contextPath").val();

    /*
    * 判断名字是否为真实姓名
    * */
    $("#name").bind("blur", function () {
        var name = $(this).val();
        var nameRegular = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;

        if (nameRegular.test(name)) {
            $("#name-div").empty();
            nameFlag = true;
            resumeSubmit();
        } else {
            nameFlag = false;

            $("#name-div").css({
                "color": "red",
                "text-align": "center",
                "margin-top": "-10px"
            }).text("请输入正确的姓名！");
            resumeSubmit();
        }
    });

    /*
    * 判断是否密码格式是否正确
    * */
    $("#password").bind("blur", function () {
        if ($(this).val() !== "" && $.trim($(this).val()).length !== 0) {

            var password = $(this).val();
            var rePassword = $("#rePassword").val();
            var passwordRegular = /^\w{6,16}$/;

            if (!passwordRegular.test(password)) {
                passwordFlag = false;
                $("#password-div").css({
                    "color": "red",
                    "text-align": "center",
                    "margin-top": "-10px"
                }).text("密码是长度为6 - 16位的字母或数字或下划线");
                resumeSubmit();
            } else if (password !== rePassword) {
                passwordFlag = false;
                $("#rePassword-div").css({
                    "color": "red",
                    "text-align": "center",
                    "margin-top": "-10px"
                }).text("两次密码不一致!");
                resumeSubmit();
            }
            else {
                passwordFlag = true;
                rePasswordFlag = true;
                $("#password-div").empty();
                $("#rePassword-div").empty();
                resumeSubmit();
            }
        } else {
            passwordFlag = false;
            $("#password-div").css({
                "color": "red",
                "text-align": "center",
                "margin-top": "-10px"
            }).text("请输入密码！");
            resumeSubmit();
        }
    });

    /*
    * 判断两次输入密码是否一致
    * */
    $("#rePassword").bind("blur", function () {

        if ($(this).val() !== "" && $.trim($(this).val()).length !== 0) {
            var password = $("#password").val();
            var rePassword = $(this).val();

            if (password === rePassword) {
                $("#rePassword-div").empty();
                passwordFlag = true;
                rePasswordFlag = true;
                resumeSubmit();
            } else {
                rePasswordFlag = false;
                $("#rePassword-div").css({
                    "color": "red",
                    "text-align": "center",
                    "margin-top": "-10px"
                }).text("两次密码不一致!");
                resumeSubmit();
            }
        } else {
            rePasswordFlag = false;
            $("#rePassword-div").css({
                "color": "red",
                "text-align": "center",
                "margin-top": "-10px"
            }).text("请输入确认密码！");
            resumeSubmit();
        }
    });

    /*
    * 判断输入的身份证号格式是否正确
    * */
    $("#idCard").bind("blur", function () {
        var idCard = $("#idCard").val();
        var idCardRegular = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/; //正则表达式

        if (idCardRegular.test(idCard)) {
            $("#idCard-div").empty();
            idCardFlag = true;
            resumeSubmit();
        } else {
            idCardFlag = false;
            $("#idCard-div").css({
                "color": "red",
                "text-align": "center",
                "margin-top": "-10px"
            }).text("请输入正确的身份证号！");
            resumeSubmit();
        }
    });

    /*
    * 使用ajax传递手机号判断手机号是否已被注册
    * 并且通过正则表达式判断输入的手机号格式是否正确
    * */
    $("#phone").bind("blur", function () {
        var phone = $(this).val();
        var phoneRegular = /^1[0-9]{10}$/; //正则表达式

        if ($(this).val() !== "" && $.trim($(this).val()).length !== 0) {

            if (phoneRegular.test(phone)) {
                $("#phone-div").empty();

                $.ajax({
                    type: "POST",
                    url: contextPath + "/user/checkIfChangePhone",
                    data: {'phone': $("#phone").val()},
                    dataType: "json",
                    async: false,
                    success: function (data) {
                        if (data.result === 'success') {
                            phoneFlag = true;
                            $("#phone-div").empty();
                            resumeSubmit();
                        } else if (data.result === 'error') {
                            phoneFlag = false;
                            $("#phone-div").css({
                                "color": "red",
                                "text-align": "center",
                                "margin-top": "-10px"
                            }).text("此手机号已被注册！");
                            resumeSubmit();
                        }
                    }
                });

                resumeSubmit();
            } else {
                phoneFlag = false;
                $("#phone-div").css({
                    "color": "red",
                    "text-align": "center",
                    "margin-top": "-10px"
                }).text("请输入正确的手机号！");
                resumeSubmit();
            }

        } else {
            phoneFlag = false;
            $("#phone-div").css({
                "color": "red",
                "text-align": "center",
                "margin-top": "-10px"
            }).text("请输入手机号！");
            resumeSubmit();
        }
    });

    /*
    * 改变按钮效果
    * */
    function resumeSubmit() {
        if (nameFlag && passwordFlag && rePasswordFlag && idCardFlag && phoneFlag) {
            $("#submit").attr("disabled", false);
        } else {
            $("#submit").attr("disabled", true);
        }
    }
});