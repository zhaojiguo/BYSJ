
$(function () {

    /**
     * 将JSON字符串用户信息转换成Json对象
     * @type {any}
     */
    let user = JSON.parse(window.sessionStorage.getItem('data'));
    console.log(user);
    if (user != null) {

        $('#inputName').val(user.user_name);

        if (user.sex == "男") {
            $('#man').addClass("checked");
        }else if (user.sex == "女") {
            $("#woman").addClass("checked");
        }
        /**
         * 截取出年，月，日
         */
        let dateStr = user.data_birth;
        let arr = dateStr.split("-");
        let year = arr[0];
        let mouth = arr[1];
        let day = arr[2];

        $('#select_year2').attr('rel',year);
        $('#select_month2').attr('rel',mouth);
        $('#select_day2').attr('rel',day);

        /**
         * 截取省市县
         */
        let addressStr = user.address;
        let reg = /.+?(省|市|自治区|自治州|县|市|区)/g;
        let addressArr = addressStr.match(reg);
        console.log(addressArr);
      //  $('#province1').find("option[value='"+addressArr[0]+"']").attr('selected','selected');

        // $('#city1').find("option[value='"+addressArr[1]+"']").attr('selected','selected');
        // $('#district1').find("option[value='"+addressArr[2]+"']").attr('selected','selected');


        $('#my_email').val(user.emial_address);

        $('#submit_btn').on('click',function () {
            let getSex = "";
            if ($("#man").hasClass('checked')) {
                getSex="男";
            }else if ($('#woman').hasClass('checked')) {
                getSex='女';
            }

            /**
             * 获取生日
             * @type {*|jQuery|string|undefined}
             */
            let year = $("#select_year2").find('option:selected').val();
            let month = $("#select_month2").find('option:selected').val();
            let day = $("#select_day2").find('option:selected').val();
            let birth = year+'-'+month+'-'+day;
            console.log(birth);
            /**
             * 获取所在地
             * @type {*|jQuery|string|undefined}
             */
            let province = $("#province1").find('option:selected').val();
            let city = $("#city1").find('option:selected').val();
            let district = $("#district1").find('option:selected').val();
            let getAddress = province + city + district;
            console.log(getAddress);
            let params = {
                userId: user.id,
                sex: getSex,
                dataBirth: birth,
                address: getAddress,
                emailAddress: $('#my_email').val(),
            }

            $.ajax({
                type: 'post',
                dataType: 'json',
                data: params,
                url: "/index/saveData",
                success: function () {
                    window.location.reload();
                    let params = {
                        userName: user.user_name,
                        password: user.password
                    }

                   $.ajax({
                       type: 'post',
                       dataType: 'json',
                       data: params,
                       url: "/index/getLogin",
                   });
                }
            });


        });
    }


    /**
     * 上传头像
     */
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;
        window.onload = function(){
            //普通图片上传
            var uploadInst = upload.render({
                elem: '#up_img_WU_FILE_0'
                ,url: '/index/uploadImage/' //改成您自己的上传接口
                ,before: function(obj){
                    this.data = {
                        "userName": user.user_name
                    }
                    //预读本地文件示例，不支持ie8
                    obj.preview(function(index, file, result){
                        $('#imgShow_WU_FILE_0').attr('src', result); //图片链接（base64）
                    });
                }
                ,done: function(res){
                    console.log("照片")
                    console.log(res);
                    window.location.reload();
                    let params = {
                        userName: user.user_name,
                        password: user.password
                    }
                    //上传成功

                    $.ajax({
                        type: 'post',
                        dataType: 'json',
                        data: params,
                        url: "/index/getLogin",
                    });
                }

            });
        }

    });
});
