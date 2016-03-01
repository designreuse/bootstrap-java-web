function show_all() {
    var up_data = {
        'interCondition': false,
    };
    $.ajax({
        url: 'interviewFind',
        data: up_data,
        type: "POST",
        dataType: "json",
        success: function(result) {
            var infoList = eval(result);
            var html = "";
            for(var i = 0; i < infoList.length; i++) {
                html = html + "<tr><td>" + infoList[i].interview_id + "</td><td>"
                + infoList[i].interview_title + "</td><td>"
                + infoList[i].interview_time + "</td><td>"
                + infoList[i].interview_place + "</td><td>"
                + infoList[i].interview_phone + "</td><td>"
                + "<button type='button' class='btn btn-default detail' onclick='show_detail("
                + infoList[i].interview_id + ")' id='"
                + infoList[i].interview_id + "'>详情</button>";
            }
            $("#interviewList").append(html);
        }
    });
}



function show_detail(interview_id) {
    location.href = "interview-detail.html?interview_id=" + interview_id;
}

$(document).ready(function(){
    show_all();
})