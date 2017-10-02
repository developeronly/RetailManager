package com.dboi.retailmanager.controller;

import com.dboi.retailmanager.model.Shop;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ShopController {

    private List<Shop> shops = new ArrayList<>();

    @RequestMapping(value = "shops", method = RequestMethod.POST)
    public Shop addShop(@RequestBody Shop shop) {
        shops.add(shop);
        return shop;
    }

    @RequestMapping(value = "shops", method = RequestMethod.GET)
    public List<Shop> list() {
        return shops;
    }
}
