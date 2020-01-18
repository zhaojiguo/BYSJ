package com.bysj.dao;

import com.bysj.model.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserAddressMapper {
    /**
     * 添加收货地址
     * @param userAddress
     * @return
     */
    Integer addAddress(UserAddress userAddress);

    /**
     * 查询收货地址
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectAddress(String userId);

    /**
     * 删除当前用户的收货地址
     * @param string
     * @return
     */
    Integer deleteAddress(String string);

    /**
     * 设置默认地址
     * @param string
     * @return
     */
    Integer setAddress(String string);
    Integer defaultAddress();
}
