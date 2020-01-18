package com.bysj.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 注册用户
     * @param map
     * @return
     */
    Integer regInsert(Map<String , Object> map);

    /**
     * 查询用户名
     * @return
     */
    List<String> getAllUserName();

    /**
     * 查询手机号
     * @return
     */
    List<String> getPhoneNumber();

    Map<String,Object> getUsers(Map<String,Object> map);

    /**
     * 上传图片
     * @param file
     * @return
     */
    String uploadImage(MultipartFile file,String userName);

    /**
     * 更新数据
     * @param map
     * @return
     */
    Integer updateData(Map<String,Object> map);

    /**
     * 添加收货地址
     * @param map
     * @return
     */
    Integer addAddress(Map<String,String> map);

    /**
     * 查询所有的收货地址
     * @param userId
     * @return
     */
    List<Map<String, Object>> selectAddress(String userId);

    /**
     * 删除当前用户的收货地址
     * @param addressId
     * @return
     */
    Integer deleteAddress(String addressId);

    /**
     * 设置默认地址
     * @param addressId
     * @return
     */
    Integer setAddress(String addressId);
}
