package com.dboi.retailmanager.controller;


import com.dboi.retailmanager.model.Shop;
import com.dboi.retailmanager.model.ShopAddress;
import org.junit.Assert;
import org.junit.Test;

public class ShopControllerTest {

    @Test
    public void addShop() {
        int shopNumber = 1;
        int postCode = 411043;
        ShopAddress shopAddress = new ShopAddress(shopNumber, postCode);
        String name = "xyz";
        Shop shopToBeCreated = new Shop(name, shopAddress);
        ShopController shopController = new ShopController();
        Shop expectedShop = shopController.addShop(shopToBeCreated);
        Assert.assertEquals(expectedShop, shopToBeCreated);
    }

}
