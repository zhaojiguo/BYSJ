package com.bysj.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CartService {
    /**
     * 查询购物车中的商品
     * @param userId
     * @return
     */
    Map<String,Object> selectTrade(String userId);

    /**
     * 更新购物车数据
     */
    Integer updateCart(Map<String,Object> map);
}
