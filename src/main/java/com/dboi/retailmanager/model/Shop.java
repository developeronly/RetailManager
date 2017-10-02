package com.dboi.retailmanager.model;

public class Shop {
    private String name;
    private ShopAddress shopAddress;

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

}
