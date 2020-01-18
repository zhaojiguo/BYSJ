$(function () {
    let user = JSON.parse(window.sessionStorage.getItem('data'));

    $('#add_address').on('click',function () {
         let params = {
             userId : user.id,
             addressName: $('#user_name').val(),
             addressInformation: $('#address_information').val(),
             phone: $('#phone').val(),
             email: $('#email-address').val(),
             defaultAddress: '0'
         }

         $.ajax({
             url: "/index/addAddress",
             type: 'post',
             dataType: 'json',
             data: params,
             success: function (res) {
                 if (res == "1") {
                     alert('地址添加成功');
                     window.location.reload();
                 }else {
                     alert('地址添加失败');
                 }

             }
         });
        $('#user_name').val("");
        $('#address_information').val("");
        $('#phone').val("");
        $('#email-address').val("");
    });

    let id = {
        userId: user.id
    };
    $.ajax({
        url: "/index/selectAddress",
        type: 'post',
        dataType: 'json',
        data: id,
        success: function (res) {
            console.log(res);
            let arr = new Array();
            for (let i = 0; i < res.length; i++) {
                if (res[i].default_address == '1') {
                    arr[0]=" <tr><td>"+res[i].address_name+"</td>\n" +
                        " <td>"+res[i].address+"</td>\n" +
                        "<td>"+res[i].phone+"</td>\n" +
                        " <td>\n" +
                        " <a href='javascript: void(0);' class='editor-address' address-id='"+res[i].id+"'>编辑</a>\n" +
                        " <a href='javascript: void(0);' class='delete-address'address-id='"+res[i].id+"'>删除</a>\n" +
                        " 默认地址\n" +
                        " </td></tr>";
                }else {
                    arr[i+1]=" <tr><td>"+res[i].address_name+"</td>\n" +
                        " <td>"+res[i].address+"</td>\n" +
                        "<td>"+res[i].phone+"</td>\n" +
                        " <td>\n" +
                        " <a href='javascript: void(0);' class='editor-address' address-id='"+res[i].id+"'>编辑</a>\n" +
                        " <a href='javascript: void(0);' class='delete-address'address-id='"+res[i].id+"'>删除</a>\n" +
                        " <a href='javascript: void(0);' class='set-address'address-id='"+res[i].id+"'> 设为默认地址</a>\n" +
                        " </td></tr>";
                }

            }
            $("#address-table").html(arr.join(""));
            /**
             * 编辑
             */
            $(".editor-address").on('click',function () {
               /* $(".hide").css({'display':'block','width':'580px','margin-top':'-142px'});

                $(".hide").attr('aria-hidden','false');*/
               alert("该功能正在完善！");
            });
            /**
             * 删除
             */
            $('.delete-address').on('click',function () {
                $.ajax({
                    url: '/index/deleteAddress',
                    type: 'post',
                    dataType: 'json',
                    data: {
                        id : $(this).attr('address-id')
                    },
                    success: function (res2) {
                        if (res2>0){
                            alert("删除成功");
                            window.location.reload();
                        } else {
                            alert("删除失败");
                        }
                    }
                });

            });
            /**
             * 设为默认地址
             */
            $(".set-address").on('click',function () {
                $.ajax({
                    url: '/index/setAddress',
                    type: 'post',
                    dataType: 'json',
                    data: {
                        id :  $(this).attr('address-id')
                    },
                    success: function (count) {
                        window.location.reload();
                    }
                });

            });
        }
    });


});