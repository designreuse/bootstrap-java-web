function menu_login() {
    $("#submit").click(function() {
        var patrn=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
        var _user = $("#InputEmail").val();
        var _psd = $("#InputPassword").val();
        var up_data = {
            'user.user_email'   : _user,
            'user.user_password': _psd,
        };
        $.ajax({
            url: 'userLogin',
            data: up_data,
            type: "POST",
            dataType: "json",
            success: function(result) {
                if(result.status == "success"){
                    alert("success");
                    location.href = "sign-up.html";
                } else {
                    alert("failed");
                }
            }
            
        });
    });
}

$(document).ready(function(){
    menu_login();
})