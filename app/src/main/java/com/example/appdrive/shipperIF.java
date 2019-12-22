package com.example.appdrive;

import com.google.android.gms.maps.model.LatLng;

public class shipperIF {

    private String userName;
    private String userAddress;
    private String userNumber;
    private String shopName;
    private String shopAddress;
    private LatLng user;
    private LatLng shop;

    public shipperIF(String userName, String userAddress, String userNumber, String shopName, String shopAddress, LatLng user, LatLng shop) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userNumber = userNumber;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.user = user;
        this.shop = shop;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public LatLng getUser() {
        return user;
    }

    public LatLng getShop() {
        return shop;
    }
}
