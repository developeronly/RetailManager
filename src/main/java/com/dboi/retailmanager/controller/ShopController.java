package com.dboi.retailmanager.controller;

import com.dboi.retailmanager.model.Shop;
import com.dboi.retailmanager.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ShopController {

    @Autowired
    private ShopService shopService;


    @RequestMapping(value = "shops", method = RequestMethod.POST)
    public Shop addShop(@RequestBody Shop shop) {
        shopService.add(shop);
        return shop;
    }

    @RequestMapping(value = "shops", method = RequestMethod.GET)
    public List<Shop> list() {
        return shopService.getAvailableShops();
    }

    @RequestMapping(value = "shops/{latitude}/{longitude}", method = RequestMethod.GET)
    public Shop shopNearByLocation(@PathVariable double longitude, @PathVariable double latitude) {
        return shopService.shopNearByLocation(longitude, latitude);
    }
}
