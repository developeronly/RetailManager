package com.dboi.retailmanager.model;

import com.google.maps.model.LatLng;

public class Shop {
    private String name;
    private ShopAddress shopAddress;
    private double latitude;
    private double longitude;

    public Shop(String name, ShopAddress shopAddress) {
        this.name = name;
        this.shopAddress = shopAddress;
    }

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopAddress getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(ShopAddress shopAddress) {
        this.shopAddress = shopAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;
        return shopAddress != null ? shopAddress.equals(shop.shopAddress) : shop.shopAddress == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (shopAddress != null ? shopAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", shopAddress=" + shopAddress +
                '}';
    }

    public void setLocation(LatLng shopLocation) {
        this.setLatitude(shopLocation.lat);
        this.setLongitude(shopLocation.lng);
    }

}
