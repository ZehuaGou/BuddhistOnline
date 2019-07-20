/*
* 将多余的字变成省略号
* */
$(function () {
    $(".omit-text").each(function () {
        $(this).text($(this).text().substr(0, 20) + "...");
    });

    //调用bootstrap collapse插件
    $("#collapse").bind("click", function () {
        $(this).collapse();
    });
});