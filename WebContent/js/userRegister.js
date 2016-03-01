function menu_register() {
    $("#submit").click(function() {
        var _userName = $("#InputUsername").val();
        var _userEmail = $("#InputEmail").val();
        var _userPsd = $("#InputPassword").val();
        var up_data = {
            'user.user_name'    :_userName,
            'user.user_email'   :_userEmail,
            'user.user_password':_userPsd
        };
        $.ajax({
            url: 'userRegister',
            data: up_data,
            type:"POST",
            dataType:"json",
            success: function(result) {
                if(result.status == "success"){
                    alert("success");
                } else {
                    alert("failed");
                }
            }
        });
    });
}

$(document).ready(function(){
    menu_register();
})