$(document).ready(function(){

    //$("#username").off().on().blur(function(){
    //    validUsernameRepeat($("#username").val());
    //});

    $("#submitButton").off().on().click(function(){
        ajaxAddUser();
    }) ;
    $("#resetButton").off().on().click(function(){
        history.back();
    });
    $(".span-prompt").off().on().blur(function(){
        var usernameReg = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
        var passwordReg = /^[a-zA-Z]\w{5,17}$/;
        if($(this).attr("id")=='username' && usernameReg.test($(this).val())){
            if($(this).val() && usernameReg.test($(this).val()))
                validUsernameRepeat($("#username").val());
            if(!$(this).val() || !usernameReg.test($(this).val())){
                $(this).next("span").show();
            }
        }
        else if($(this).attr("id")=='password' && (!$(this).val() || !passwordReg.test($(this).val())))
        {
            $(this).next("span").show();
        }else
        {
            if(!$(this).val()){
                $(this).next("span").show();
            }
            if($(this).attr("id")=='confirmPassword' && $(this).val()!=$("#password").val()) {
                $(this).next("span").show();
            }
        }
    }).focus(function(){
        $(this).next("span").hide();
        if($(this).attr("id")=='username')
            $("#usernameExist").hide();
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
    var inviteCode = $("#inviteCode").val();
    var reg = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
    if(!username || !reg.test(username)){
        alert('请正确填写用户名！');
        return;
    }
    if(!realname){
        alert('请填写您的姓名！');
        return;
    }
    if(!nickname){
        alert('请填写用户昵称！');
        return;
    }
    reg = /^[a-zA-Z]\w{5,17}$/;
    if(!password || !reg.test(password)){
        alert('请正确填写用户密码！');
        return;
    }
    if(!inviteCode){
        alert('请填写用户注册邀请码！');
        return;
    }
    if(password!=$("#confirmPassword").val()){
        alert('两次密码输入不相同！');
        $("#confirmPassword").val("");
        $("#password").val("");
        return;
    }
    paramsJson['username'] = username;
    paramsJson['nickname'] = nickname;
    paramsJson['realname'] = realname;
    paramsJson['password'] = password;
    paramsJson['inviteCode'] = inviteCode;
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

function validUsernameRepeat(username){
    if(!username){
        return false;
    }
    $.ajax({
        url : 'ajaxValidUserNameRepeat',
        type:'post',
        dataType : "json",
        data : {
            username : username
        },
        success: function(data){
            if(data.status==false && data.code=='ACCOUNT_EXIST'){
                $("#usernameExist").show();
            }
        }
    });
}