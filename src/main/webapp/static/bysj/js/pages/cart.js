$(function () {
    var userData = JSON.parse(window.sessionStorage.getItem('data'));
    console.log($(".count").text())
    if ($(".count").text()=="0"){
        $('.cart-main').hide();
        $('.cart-tool').hide();
    }

    $.ajax({
        type: 'post',
        dataType: 'json',
        data:{
            userId:userData.id
        },
        url:'/cart/selectTrade',
        success: function (res) {
            console.log(res);
            var str = new Array();
            for (var i=0;i<res.trades.length;i++){
                str.push('<div class="cart-item-list">\n' +
                    '<div class="cart-shop">\n' +
                    '<input type="checkbox" name="apple" id="" value="" />\n' +
                    '<span class="shopname self">'+res.trades[i].shop_name+'</span>\n' +
                    '</div>\n'
                    );
                for (var j = 0;j<res.trades[i].trade.length;j++){
                    str.push('<div class="cart-body">\n' +
                        '<div class="cart-list">\n' +
                        '<ul class="goods-list yui3-g">\n' +
                        '<li class="yui3-u-1-24">\n' +
                        '<input type="checkbox" name="apple" id="" value="" />\n' +
                        '</li>\n' +
                        '<li class="yui3-u-11-24">\n' +
                        '<div class="good-item">\n' +
                        '<div class="item-img"><img src="'+res.trades[i].trade[j].img_path+'" /></div>\n' +
                        '<div class="item-msg">'+res.trades[i].trade[j].trade_name+res.trades[i].trade[j].color+res.trades[i].trade[j].parameter+'</div>\n' +
                        '</div>\n' +
                        '</li>\n' +
                        '<li class="yui3-u-1-8"><span class="price">'+(res.trades[i].trade[j].price).toFixed(2)+'</span></li>\n' +
                        '<li class="yui3-u-1-8">\n' +
                        '<a href="javascript:void(0)" class="increment mins">-</a>\n' +
                        '<input autocomplete="off" type="text" trade-id="'+res.trades[i].trade[j].trade_id+'" value="'+res.trades[i].trade[j].trade_number+'" minnum="1" class="itxt" />\n' +
                        '<a href="javascript:void(0)" class="increment plus">+</a>\n' +
                        '</li>\n' +
                        '<li class="yui3-u-1-8"><span class="sum">'+(res.trades[i].trade[j].money).toFixed(2)+'</span></li>\n' +
                        '<li class="yui3-u-1-8">\n' +
                        '<a href="#none">删除</a><br />\n' +
                        '<a href="#none">移到我的关注</a>\n' +
                        '</li>\n' +
                        '</ul>\n' +
                        '</div>'+
                        '</div>\n' +
                        '</div>'
                    );
                }
            }
            $('.cart-main').append(str.join(""));

            $('.plus').on('click',function () {
                $(this).prev().val(parseInt($(this).prev().val())+1);
                const num= $(this).prev().val();
                const sum =$(this).parent().prev().children().text();
                $(this).parent().next().children().text((num*sum).toFixed(2));
                updateCart(this,$(this).prev().val(),$(this).prev().attr('trade-id'));
            });
            $('.mins').on('click',function () {
                if ($(this).next().val()>1) {
                    $(this).next().val(parseInt($(this).next().val())-1);
                    const num= $(this).next().val();
                    const sum =$(this).parent().prev().children().text();
                    $(this).parent().next().children().text((num*sum).toFixed(2));
                    updateCart(this,$(this).next().val(),$(this).next().attr('trade-id'));
                }else {
                    alert('数量不能小于1');
                    return;
                }

            });
            $('.itxt').on('input',function () {

                if ($(this).val() < 0 ||$(this).val()=="") {
                    $(this).val(1);
                    alert("数量不能小于1");
                }
                const num= $(this).val();
                const sum =$(this).parent().prev().children().text();
                $(this).parent().next().children().text((num*sum).toFixed(2));
                updateCart(this,$(this).val(),$(this).attr('trade-id'));
                console.log(111)

               /* $(this).parent().next().children().text(parseInt($(this).next().val())*parseInt(res.trades[i].trade[j].price));*/
            });


        }
    });

    function updateCart(that,count,id) {
        console.log(id)
        $.ajax({
            url: "/cart/updateCart",
            type: "post",
            dataType:"json",
            data: {
                userId: userData.id,
                tradeNumber: count,
                tradeId: id,
                money: $(that).parent().next().children().text()
            },
            success:function (res) {
                console.log(res);
            }

        });
    }

});