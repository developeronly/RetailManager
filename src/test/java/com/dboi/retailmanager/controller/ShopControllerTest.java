package com.dboi.retailmanager.controller;


import com.dboi.retailmanager.model.Shop;
import com.dboi.retailmanager.model.ShopAddress;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        assertEquals(expectedShop, shopToBeCreated);
    }

    @Test
    public void listShops() {
        List<Shop> shops = new ArrayList<>();
        ShopController shopController = new ShopController();
        shopController.addShop(new Shop("xyz", new ShopAddress(1, 411043)));
        shopController.addShop(new Shop("abc", new ShopAddress(2, 411044)));
        shopController.addShop(new Shop("pqr", new ShopAddress(3, 411045)));
        shops = shopController.list();
        assertFalse(shops.isEmpty());
        assertEquals(3, shops.size());
    }

}
