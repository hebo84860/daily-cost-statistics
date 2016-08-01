$(document).ready(function(){

    $("#submitButton").off().on().click(function(){
        ajaxModifyPassword();
    }) ;
    $("#resetButton").off().on().click(function(){
        history.back();
    });
    $(".span-prompt").off().on().blur(function(){
        if(!$(this).val()){
            $(this).next("span").show();
        }
        if($(this).attr("id")=='confirmPassword' && $(this).val()!=$("#password").val()){
            $(this).next("span").show();
        }
    }).focus(function(){
        $(this).next("span").hide();
    })

});

function ajaxModifyPassword(){
    var url_ = "../user/modifyPassword";
    var paramsJson = {};
    var username = $("#username").val();
    var oldPassword = $("#oldPassword").val();
    var newPassword = $("#password").val();
    if(!oldPassword){
        alert('请填写用户原始密码');
        return;
    }
    if(!newPassword){
        alert('请填写用户新密码');
        return;
    }
    if(newPassword!=$("#confirmPassword").val()){
        alert('两次输入密码不一致');
        return;
    }
    paramsJson['username'] = username;
    paramsJson['newPassword'] = newPassword;
    paramsJson['oldPassword'] = oldPassword;
    $.ajax({
        url: url_,
        type: 'post',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data:JSON.stringify(paramsJson),
        success: function(data){
            alert(data.msg);
            if (data.code==0) {
                location.href = '../main/login'
            }
        },
        error: function(data){

        }
    } )

}