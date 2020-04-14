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
}
