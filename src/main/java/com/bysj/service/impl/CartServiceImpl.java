package com.bysj.service.impl;

import com.bysj.dao.CartMapper;
import com.bysj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public Map<String, Object> selectTrade(String userId) {
        Map<String,Object> tradeMap = new HashMap<>(64);
        Set<Object> tradeList = new HashSet<>(64);
        List<Map<String, Object>> list = cartMapper.selectShop(userId);
        for (Map map:list){
            Map<String,Object> resultMap = new HashMap<>(64);
            resultMap.put("user_id",userId);
            resultMap.put("shop_name",map.get("shop_name"));
            List<Map<String,Object>> map1 = cartMapper.selectTrade(resultMap);
            resultMap.put("trade",map1);
            tradeList.add(resultMap);
        }
        tradeMap.put("trades",tradeList);
        System.out.println(list.size());
        return tradeMap;
    }

    @Override
    public Integer updateCart(Map<String, Object> map) {
        Integer integer = cartMapper.updateCart(map);
        return integer;
    }
}
