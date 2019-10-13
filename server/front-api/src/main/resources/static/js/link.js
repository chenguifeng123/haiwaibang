function checkPara(name){
    if(name == null || name == ""){
        return false;
    }
    return true;
}

$(document).ready(function(){
    $("#ask").popover({
        html: true,
        title: '预约成功',
        placement:'top',
        //trigger: "hover",
        content: function () {
            return '您好！恭喜您预约成功，我们会尽快安排专业移民顾问和您联系；提供1对1的专家服务';
        }
    });

    $("#ask").click(function(){
        var purpose = $('#purpose').val();
        var username = $('#username').val();
        var phone = $('#phone').val();
        if(!checkPara(username)){
            return;
        }
        if(!checkPara(phone)){
            return;
        }
        $.ajax({
            url: '/manage/custom',
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify({
                purpose: purpose,
                username: username,
                phone: phone,
                isContact:0
            }),
            error: function (result) {
                console.log(result);
            },
            success: function( response ) {
                // $('#ask').popover('show');


                $('#username').val("");
                $('#phone').val("");
                setTimeout(function(){
                    $('#ask').popover('hide')
                },2000);
            }
        });
    });
});