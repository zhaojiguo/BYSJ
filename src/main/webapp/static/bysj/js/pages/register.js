$(function() {
    $('input,textarea').placeholder();

});
//jquery.validate表单验证
$(document).ready(function(){
    //注册表单验证
    $("#registerForm").validate({
        rules:{
            username:{
                required:true,//必填
                minlength:3, //最少6个字符
                maxlength:32,//最多20个字符
                remote:{
                    url:"/index/getAllUserName",//用户名重复检查，别跨域调用
                    type:"post",
                    dataType: "json",
                    data: {
                        username: function () {
                            return $("#user-name").val();
                        }
                    }
                },
            },
            password:{
                required:true,
                minlength:3,
                maxlength:32,
            },
            confirm_password:{
                required:true,
                minlength:3,
                equalTo:'.password'
            },
            phone_number:{
                required:true,
                phone_number:true,//自定义的规则
                digits:true,//整数
                remote:{
                    url:"/index/getPhoneNumber",//手机号重复检查，别跨域调用
                    type:"post",
                    dataType:'json',
                    data:{
                        phoneNumber:function () {
                            return $('.phone_number').val();
                        }
                    }
                },
            }
        },
        //错误信息提示
        messages:{
            username:{
                required:"必须填写用户名",
                minlength:"用户名至少为3个字符",
                maxlength:"用户名至多为32个字符",
                remote:"该用户名已经被注册",
            },
            password:{
                required:"必须填写密码",
                minlength:"密码至少为3个字符",
                maxlength:"密码至多为32个字符",
            },
            confirm_password:{
                required: "请再次输入密码",
                minlength: "确认密码不能少于3个字符",
                equalTo: "两次输入密码不一致",//与另一个元素相同
            },
            phone_number:{
                required:"请输入手机号码",
                digits:"请输入正确的手机号码",
                remote: "该手机号已存在",
            },

        },
    });
    //添加自定义验证规则
    jQuery.validator.addMethod("phone_number", function(value, element) {
        var length = value.length;
        var phone_number = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(19[0-9]{1}))+\d{8})$/
        return this.optional(element) || (length == 11 && phone_number.test(value));
    }, "手机号码格式错误");

    $('#reg_btn').on('click',function () {
        if ($('#check_btn').is(':checked')){
            let params = {
                userName: $(".username").val(),
                password: $('.confirm_password').val(),
                phoneNumber: $('.phone_number').val()
            }
            $.ajax({
                type: 'post',
                data: params,
                dataType: "json",
                url: '/index/register',
                success: function (res) {
                    console.log(res);
                    alert('注册成功！');
                    window.location.href= '/index/login'
                },
                error: function () {
                    alert('注册失败，请重新注册');
                }
            });
        }else{
          alert('请统一用户注册协议');
        }
    });

    /**
     * 已有账号去登陆
     */
    $('#login').on('click',function () {
        window.location.href='/index/login';
    });
});