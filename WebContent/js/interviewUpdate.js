function interview_update() {
    $("#update").click(function(){
        var interview_id = $("#interviewId").val();
        var interview_title = $("#interviewTitle").val();
        var interview_desc = $("#interviewDesc").val();
        var interview_user = $("#interviewUser").val();
        var interview_place = $("#interviewPlace").val();
        var interview_phone = $("#interviewPhone").val();
        var up_data = {
            'interview.interview_id'    : interview_id,
            'interview.interview_title' : interview_title,
            'interview.interview_desc'  : interview_desc,
            'interview.interview_user'  : interview_user,
            'interview.interview_place' : interview_place,
            'interview.interview_phone' : interview_phone,
            'interCondition': true,
        };
        $.ajax({
	        url: 'interviewUpdate',
	        data: up_data,
	        type: "POST",
	        dataType: "json",
	        success: function(result) {
	            if(result.status == "success") {
	            	alert("success");
	            } else {
	            	alert("failed");
	            }
	        }
        });
    });
}

function show_detail(interview_id){
    var interview_id = interview_id;
    var up_data = {
        'interview.interview_id' : interview_id,
        'interCondition': true,
    }
    $.ajax({
        url: 'interviewFind',
        data: up_data,
        type: "POST",
        dataType: "json",
        success: function(result) {
            var infoList = eval(result);
            $("#interviewId").val(infoList[0].interview_id);
            $("#interviewTitle").val(infoList[0].interview_title);
            $("#interviewDesc").val(infoList[0].interview_desc);
            $("#interviewTime").val(infoList[0].interview_time);
            $("#interviewPhone").val(infoList[0].interview_phone);
            $("#interviewUser").val(infoList[0].interview_user);
            $("#interviewPlace").val(infoList[0].interview_place);
        }
    });
}

$(document).ready(function() {
    var reg = new RegExp("(^|&)" + "interview_id" + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    var context = ""; 
    if (r != null) {
        context = r[2];
        show_detail(context);
    }
    interview_update();
})