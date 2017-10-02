package com.dboi.retailmanager.controller;

import com.dboi.retailmanager.model.Shop;
import com.dboi.retailmanager.model.ShopAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ShopController {

    public Shop addShop(Shop shop) {
        int shopNumber = 1;
        int postCode = 411043;
        ShopAddress shopAddress = new ShopAddress(shopNumber, postCode);
        String name = "xyz";
        return new Shop(name, shopAddress);
    }

}
