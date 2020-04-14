$(function () {

    $('#reg').on('click',function () {
        window.location.href = "/index/reg";
    });

    $("#login").on("click",function () {
        window.location.href = "/index/login";
    });

    $('#my-item').on('click',function () {
        window.location.href = "/index/buy";
    });
    /**
     * 登录
     * @type {string}
     */
    let data = window.sessionStorage.getItem('data');
    let user = JSON.parse(data);
    console.log(user);

    if ( user== null) {
        $('.btn-default').on('click',function () {
            window.location.href = '/index/login';
        });
        $('#noLogin').css('display','block');
        $('#haveLogin').css('display','none');
    }else {
        $('.btn-default').on('click',function () {
            window.location.href = '/index/myCart';
        });
        $('#noLogin').css('display','none');
        $('#haveLogin').css('display','block');
        $('.name').text(user.user_name);
        $('#my-name').text(user.user_name);
        if (user.image_path == "") {
            $('#my_img').attr('src',"../../../static/bysj/img/_/photo.png");
        }else {
            $('#my_img').attr('src',user.image_path);
        }
    }
    /**
     * 个人中心
     */
    $('#haveLogin').on('mouseover',function () {
        $('.my_item').css('display','block');
    });
    $('.my_item').on('mouseout',function () {
        $('.my_item').css('display','none');
    });

    /**
     * 修改信息
     */
    $('#changeInformation').on('click',function () {
        window.location.href = '/index/changeInformation'
    });

    /**
     * 安全中心
     */
    // $('#safe').on('click',function () {
    //     window.location.href = "/index/safe";
    // });
    /**
     * 退出账号
     */
    $('#exit').on('click',function () {
        $('#noLogin').css('display','block');
        $('#haveLogin').css('display','none');
        window.sessionStorage.removeItem('data');
        window.location.href = '/index/login';

    });

    /**
     * 个人信息左侧
     */

    /*个人信息*/

    if(user.image_path != null){
        $("#imgShow_WU_FILE_0").attr('src',user.image_path);
        $(".person-photo img").attr('src',user.image_path);
    }
    $('#user_information').on('click',function () {
        window.location.href = '/index/changeInformation';
    });

    /**
     * 地址管理
     */
    $('#address').on('click',function () {
        window.location.href = '/index/address';
    });
    /**
     * 我的订单
     */
    $('#my-order-form').on('click',function () {
        window.location.href = '/index/myGoods';
    });

});