package com.bysj.controller;

import com.bysj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/index")
public class IndexController{


    @Autowired
    private UserService userService;
    /**
     * 跳转到登录页
     */
    @RequestMapping("/buy")
    public String getIndex(){
        return "bysj/index.html";
    }

    /**
     * 跳转到注册页面
     */
    @RequestMapping("/reg")
    public  String getReg(){
        return "bysj/register.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping("/login")
    public String getLogin(){
        return "bysj/login.html";
    }

    /**
     * 跳转到修改信息页
     * @return
     */
    @RequestMapping("/changeInformation")
    public String changeInformation(){
        return "bysj/home-setting-info.html";
    }

    /**
     * 跳转到收货地址页
     * @return
     */
    @RequestMapping("/address")
    public String getSafe(){
        return "/bysj/home-setting-address.html";
    }

    @RequestMapping("/myGoods")
    public String myGoods(){
        return "/bysj/home-orderDetail.html";
    }

    /**
     * 跳转到我的购物车
     * @return
     */
    @RequestMapping("/myCart")
    public String myCart(){
        return "/bysj/cart.html";
    }
    /**
     * 注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public Integer getRegister(@RequestParam Map<String,Object> params){
        Integer integer= null;
        System.out.println(params.size());
        try {
            integer = userService.regInsert(params);

        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;

    }
    /**
     * 查询所用用户名，判断该用户名是否存在
     */
    @RequestMapping("/getAllUserName")
    @ResponseBody
    public Boolean getAllUser(@RequestParam Map<String,Object> map){
        System.out.println(map.size());
        boolean flag = true;
        String name = (String) map.get("username");
        List<String> allUserName = userService.getAllUserName();
        for (String userName : allUserName){
            if (userName.equals(name)){
                flag=false;
            }
        }
        return flag;
    }

    /**
     * 查询所有手机号，判断手机号是否存在
     * @return
     */
    @RequestMapping("/getPhoneNumber")
    @ResponseBody
    public Boolean getPhoneNumber(@RequestParam Map<String,Object> map){
        Boolean flage = true;
        String number = (String) map.get("phoneNumber");
        List<String> phoneNumber = userService.getPhoneNumber();
        for (String phone:phoneNumber){
            if (phone.equals(number)){
                flage=false;
            }
        }
        return flage;
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/getLogin")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam Map<String,Object> map){
        Map<String, Object> user = userService.getUsers(map);
        return user;
    }

    /**
     * 上传头像
     * @param file
     * @return
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file ,@RequestParam("userName") String userName){
        String path = userService.uploadImage(file,userName);
        return path;
    }
    @RequestMapping("/saveData")
    @ResponseBody
    public Integer saveData(@RequestParam Map<String,Object> map){
        Integer integer = userService.updateData(map);
        return integer;
    }

    /**
     * 添加收货地址
     * @param map
     * @return
     */
    @RequestMapping("/addAddress")
    @ResponseBody
    public Integer addAddress(@RequestParam Map<String,String> map){
        Integer integer = userService.addAddress(map);
        return integer;
    }

    /**
     * 查询当前用户的收货地址
     * @param userId
     * @return
     */
    @RequestMapping("/selectAddress")
    @ResponseBody
    public Object selectAddress(@RequestParam("userId") String userId){
        List<Map<String, Object>> maps = userService.selectAddress(userId);
        System.out.println(userId);
        return maps;
    }

    /**
     * 删除当前用户收货地址
     * @param id
     * @return
     */
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public Integer deleteAddress(@RequestParam("id") String id){
        Integer integer = userService.deleteAddress(id);
        return integer;
    }

    /**
     * 设为默认地址
     * @param id
     * @return
     */
    @RequestMapping("/setAddress")
    @ResponseBody
    public Integer setAddress(@RequestParam("id") String id){
        Integer integer = userService.setAddress(id);
        return integer;
    }
}
