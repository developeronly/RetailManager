package com.dboi.retailmanager.controller;

import com.dboi.retailmanager.model.Shop;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ShopController {

    @RequestMapping(value = "shops", method = RequestMethod.POST)
    public Shop addShop(@RequestBody Shop shop) {
        return shop;
    }

}
