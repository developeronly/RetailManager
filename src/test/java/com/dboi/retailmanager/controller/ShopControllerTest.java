package com.dboi.retailmanager.controller;


import com.dboi.retailmanager.model.Shop;
import com.dboi.retailmanager.model.ShopAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopControllerTest {

    @Autowired
    private ShopController shopController;

    @Test
    public void addShop() {
        int shopNumber = 1;
        int postCode = 411043;
        ShopAddress shopAddress = new ShopAddress(shopNumber, postCode);
        String name = "xyz";
        Shop shopToBeCreated = new Shop(name, shopAddress);
        Shop expectedShop = shopController.addShop(shopToBeCreated);
        assertEquals(expectedShop, shopToBeCreated);
    }

    @Test
    public void listShops() {
        List<Shop> shops = new ArrayList<>();
        shopController.addShop(new Shop("xyz", new ShopAddress(1, 411043)));
        shopController.addShop(new Shop("abc", new ShopAddress(2, 411044)));
        shopController.addShop(new Shop("pqr", new ShopAddress(3, 411045)));
        shops = shopController.list();
        assertFalse(shops.isEmpty());
        assertEquals(3, shops.size());
    }

    @Test
    public void verifyEmptyListOfShops() {
        List<Shop> shops = new ArrayList<>();
        shops = shopController.list();
        assertTrue(shops.isEmpty());
    }

    public void listOfShopsNearByCustomersLocationWhenThereIsOnlyOneShop() {
        List<Shop> shops = new ArrayList<>();
        Shop shop = new Shop("xyz", new ShopAddress(1, 411043));
        shopController.addShop(shop);
        Shop nearestShop = shopController.shopNearByLocation(41.40338, 2.17403);
        assertEquals(nearestShop, shop);
    }

    public void shopNearByCustomersLocationWhenThereIsOnlyMoreThanOneShop() {
        List<Shop> shops = new ArrayList<>();
        shopController.addShop(new Shop("xyz", new ShopAddress(1, 411043)));
        shopController.addShop(new Shop("abc", new ShopAddress(2, 411044)));
        shopController.addShop(new Shop("pqr", new ShopAddress(3, 411045)));
        Shop nearestShop = shopController.shopNearByLocation(18.4028691, 73.8536683);
        assertEquals(new Shop("pqr", new ShopAddress(3, 411045)), nearestShop);
    }

}
