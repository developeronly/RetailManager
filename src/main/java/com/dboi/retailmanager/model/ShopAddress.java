package com.dboi.retailmanager.model;

public class ShopAddress {
    private final int shopNumber;
    private final int postCode;

    public ShopAddress(int shopNumber, int postCode) {
        this.shopNumber = shopNumber;
        this.postCode = postCode;
    }

    public int getShopNumber() {
        return shopNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopAddress that = (ShopAddress) o;

        if (shopNumber != that.shopNumber) return false;
        return postCode == that.postCode;

    }

    @Override
    public int hashCode() {
        int result = shopNumber;
        result = 31 * result + postCode;
        return result;
    }

    @Override
    public String toString() {
        return "ShopAddress{" +
                "shopNumber=" + shopNumber +
                ", postCode=" + postCode +
                '}';
    }

}
