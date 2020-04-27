package com.bysj.controller;

import com.bysj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 获取购物车商品数据
     * @param userId
     * @return
     */
    @RequestMapping("/selectTrade")
    @ResponseBody
    public Map<String,Object> selectTrade(@RequestParam("userId") String userId){
        Map<String, Object> resultMap = new HashMap<String, Object>(64);
        try {
            resultMap = cartService.selectTrade(userId);
        }catch (Exception e){
            resultMap.put("error","获取购物车商品数据出错");
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 更新购物车数据
     * @param map
     * @return
     */
    @RequestMapping("/updateCart")
    @ResponseBody
    public Map<String,String> updateCart(@RequestParam Map<String,Object> map){
        Map<String,String> result = new HashMap<>(64);
        try {
            Integer integer = cartService.updateCart(map);
            result.put("success","购物车数据更新成功");
        }catch (Exception e){
            result.put("success","购物车数据更新失败");
        }

        return result;
    }
}
