package com.bysj.dao;

import com.bysj.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 注册用户
     * @param user
     * @return
     */
    Integer regInsert(User user);

    /**
     * 查询所有用名
     * @return
     */
    List<String> getAllUserName();

    /**
     * 查询手机号
     * @return
     */
    List<String> getPhoneNumber();

    /**
     * 登录
     * @return
     */
    List<Map<String,Object>> getUsers(Map<String,Object> map);

    /**
     * 更新图片路径
     * @param user
     * @return
     */
    Integer updateImagePath(User user);

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    Integer updateData(User user);
}
