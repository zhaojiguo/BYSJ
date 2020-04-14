package com.bysj.controller;

import com.bysj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
