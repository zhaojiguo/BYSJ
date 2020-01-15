$(function() {
    $('input,textarea').placeholder();

    $('#reg').on('click',function () {
       window.location.href='/index/reg';
    });

    $('#login').on('click',function () {
        if ($('#username-input').val()==""||$('#username-input').val()==undefined){
            alert("请输入用户名");
        } else if ($('#password-input').val() == ""||$('#password-input').val()==undefined) {
            alert("请输入密码");
        }else {
            let params = {
                userName: $('#username-input').val(),
                password: $('#password-input').val()
            }
            $.ajax({
                type: 'post',
                dataType: 'json',
                data: params,
                url: '/index/getLogin',
                success: function (res) {
                    if (res['user']==""){
                        alert("用户名或密码错误，请重新输入");
                    } else {
                        window.location.href='/index/buy';
                        console.log(res);
                        let data =JSON.stringify(res);
                        console.log(data);
                        //window.localStorage.setItem('data',data);
                        window.sessionStorage.setItem('data',data)
                    }
                }
            });
        }

    });
})