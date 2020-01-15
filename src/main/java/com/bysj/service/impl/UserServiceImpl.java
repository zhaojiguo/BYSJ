package com.bysj.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.bysj.dao.UserMapper;
import com.bysj.model.User;
import com.bysj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer regInsert(Map<String, Object> map) {
        User user = new User();
        String userName = (String) map.get("userName");
        String password = (String) map.get("password");
        String phoneNumber = (String) map.get("phoneNumber");
        user.setId(IdWorker.get32UUID());
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setDataBirth("");
        user.setAge(0);
        user.setSex("");
        user.setEmialAddress("");
        user.setAddress("");
        user.setImagePath("");
        Integer integer = userMapper.regInsert(user);
        return integer;
    }

    @Override
    public List<String> getAllUserName() {
        List<String> allUserName = userMapper.getAllUserName();

        return allUserName;
    }

    @Override
    public List<String> getPhoneNumber() {
        List<String> phoneNumber = userMapper.getPhoneNumber();
        return phoneNumber;
    }

    @Override
    public Map<String, Object> getUsers(Map<String, Object> map) {
        Map<String, Object> user = new HashMap<String, Object>(16);
        List<Map<String, Object>> userList = userMapper.getUsers(map);
        if (userList.size()==0){
            user.put("user","");
        }else {
            user= userList.get(0);
        }
        return user;
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @Override
    public String uploadImage(MultipartFile file,String userName) {
        String filename = file.getOriginalFilename();
        int indexOf = filename.indexOf(".");
        String substring = filename.substring(indexOf);
        String imagePath = "../../../static/bysj/img/userImage/"+userName+substring;
        User user = new User();
        user.setImagePath(imagePath);
        user.setUserName(userName);
        userMapper.updateImagePath(user);

        //上传是地址
        String path = "E:\\BYSJ\\src\\main\\webapp\\static\\bysj\\img\\userImage\\"+userName+substring;
        File outFile = new File(path);
        FileOutputStream fileOutputStream = null;
        //建立数组缓冲区
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            InputStream inputStream = file.getInputStream();
            fileOutputStream = new FileOutputStream(outFile);
            //建立数组缓冲区
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //读取数据，边读边写
            int count = 0;
            while((count=bufferedInputStream.read())!=-1) {
                bufferedOutputStream.write(count);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
                try {
                    if (fileOutputStream!=null) {
                        bufferedOutputStream.close();
                    }
                }catch(IOException e) {
                    throw new RuntimeException(e);
                }
        }
        return path;
    }

    /**
     * 更新用户数据
     * @param map
     * @return
     */
    @Override
    public Integer updateData(Map<String, Object> map) {
        User user = new User();
        String userId = (String) map.get("userId");
        String sex = (String) map.get("sex");
        String dataBirth = (String) map.get("dataBirth");
        String address = (String) map.get("address");
        String emailAddress = (String) map.get("emailAddress");
        user.setId(userId);
        user.setSex(sex);
        user.setDataBirth(dataBirth);
        user.setAddress(address);
        user.setEmialAddress(emailAddress);
        Integer integer = userMapper.updateData(user);
        return integer;
    }
}
