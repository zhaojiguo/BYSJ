package com.bysj.model;

public class Cart {
    //商品id
    private String id;
    //用户id
    private String userId;
    //商店名
    private String shopName;
    //商品名
    private String tradeName;
    //商品颜色
    private String color;
    //商品详情
    private String parameter;
    //商品价格
    private Double price;
    //商品数量
    private Integer tradeNumber;
    //商品图片地址
    private String imgPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(Integer tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", tradeName='" + tradeName + '\'' +
                ", color='" + color + '\'' +
                ", parameter='" + parameter + '\'' +
                ", price='" + price + '\'' +
                ", tradeNumber=" + tradeNumber +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
