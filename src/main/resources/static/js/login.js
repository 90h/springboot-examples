function loginAuthentication() {
    var loginName = $("#loginName").val();
    var loginPwd = $("#loginPwd").val();
    alert(loginName );
    alert(loginPwd);
    if(loginName.trim()==="" || loginPwd.trim()===""){
        $("#errorMsg").attr("style","display:block;");
        return;
    }

    loginName = loginName.trim();
    loginPwd = loginPwd.trim();

    ajaxLogin(loginName,loginPwd);
}

function ajaxLogin(loginName,loginPwd) {
    alert("loginName:"+loginName +",loginPwd:"+loginPwd);

    var paramdata = {
        username:loginName,
        userpwd:loginPwd
    }

    $.ajax({
        url:"/loginPost",
        type:"post",
        dataType:"json",
        data:paramdata,
        timeout:120000,
        success:function (data) {
            if (null===data){
                $("#errorMsg").attr("style","display:block");
            }

            var status = data.status;
            var result = data.result;
            alert("status:" + status + ",result:"+result);

        },
        error:function () {
            
        }
    });
}