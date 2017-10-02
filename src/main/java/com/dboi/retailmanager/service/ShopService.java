package com.dboi.retailmanager.service;

import com.dboi.retailmanager.model.Shop;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ShopService {
    public static final int EARTH_RADIUS_IN_METER = 6374612;
    private final AtomicReference<GeoApiContext> GEO_API_CONTEXT;
    private final List<Shop> shops;

    @Value("${apiKey}")
    private String apiKey;

    public ShopService() {
        this.shops = new ArrayList<>();
        this.GEO_API_CONTEXT = new AtomicReference<>();
    }

    private GeoApiContext getApiContext() {
        GeoApiContext ctx = GEO_API_CONTEXT.get();
        if (ctx == null) {
            ctx = new GeoApiContext().setApiKey(apiKey);
            GEO_API_CONTEXT.compareAndSet(null, ctx);
        }
        return GEO_API_CONTEXT.get();
    }

    public void add(Shop shop) {
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(getApiContext(),
                    String.valueOf(shop.getShopAddress().getPostCode())).await();
            LatLng latLng = results[0].geometry.location;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(results[0].geometry.location));
            shop.setLatitude(latLng.lat);
            shop.setLongitude(latLng.lng);
            shops.add(shop);
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Shop> getAvailableShops() {
        return shops;
    }

    private double calculateDistanceInMeters(LatLng to, LatLng from) {
        double deltaLatitude = Math.toRadians(to.lat - from.lat);
        double deltaLongitude = Math.toRadians(to.lng - from.lng);
        double arcSine = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2) +
                Math.cos(Math.toRadians(to.lat)) * Math.cos(Math.toRadians(from.lat)) *
                        Math.sin(deltaLongitude / 2) * Math.sin(deltaLongitude / 2);
        double distance = 2 * Math.atan2(Math.sqrt(arcSine), Math.sqrt(1 - arcSine));
        return EARTH_RADIUS_IN_METER * distance;
    }

    public Shop shopNearByLocation(double longitude, double latitude) {
        LatLng to = new LatLng(latitude, longitude);
        Map<Double, Shop> shopsWithDistance = new HashMap<>();
        shops.stream()
                .forEach(shop -> {
                    double distance = calculateDistanceInMeters(new LatLng(shop.getLatitude(), shop.getLongitude()),
                            to);
                    shopsWithDistance.put(distance, shop);
                });
        Optional<Double> nearestDistance = shopsWithDistance.keySet().stream().sorted().findFirst();
        Shop nearestShop = shopsWithDistance.get(nearestDistance.orElse(0.0));
        return nearestShop;
    }

}
