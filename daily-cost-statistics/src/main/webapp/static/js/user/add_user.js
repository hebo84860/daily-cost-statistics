$(document).ready(function(){

    $("#submitButton").off().on().click(function(){
        ajaxAddUser();
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

function ajaxAddUser(){
    var url_ = "../user/addOrUpdate";
    var paramsJson = {};
    var username = $("#username").val();
    var realname = $("#realname").val();
    var nickname = $("#nickname").val();
    var password = $("#password").val();
    var email = $("#email").val();
    if(!username){
        alert('请填写用户名');
        return;
    }
    if(!realname){
        alert('请填写您的姓名');
        return;
    }
    if(!nickname){
        alert('请填写用户昵称');
        return;
    }
    if(!password){
        alert('请填写用户密码');
        return;
    }
    if(password!=$("#confirmPassword").val()){
        alert('请填写用户密码');
        return;
    }
    paramsJson['username'] = username;
    paramsJson['nickname'] = nickname;
    paramsJson['realname'] = realname;
    paramsJson['password'] = password;
    if(email)
        paramsJson['email'] = email;

    //alert(JSON.stringify(paramsJson));
    $.ajax({
        url: url_,
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        data:{"paramsJson":JSON.stringify(paramsJson)},
        //dateType: "text",
        success: function(data){
            var d = JSON.parse(data);
            alert(d.msg);
            if (d.code==0) {
                location.href = '../main/login'
            }
        },
        error: function(data){

        }
    } )

}