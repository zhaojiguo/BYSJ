package com.bysj.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {
    List<Map<String,Object>> selectShop(String userId);
    List<Map<String,Object>> selectTrade(Map map);

    Integer updateCart(Map<String,Object> map);
}
