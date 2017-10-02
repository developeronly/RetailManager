# RetailManager

Simple REST API for finding nearest shop using Google [Geocoding API](https://developers.google.com/maps/documentation/geocoding/intro).

Base URL would be
```
http://localhost:8080/api/v1/
```

For Adding a new shop
```
POST http://localhost:8080/api/v1/shops
```
For fetching all available shops
```
GET http://localhost:8080/api/v1/shops
```
For fetching a shop nearby given location
```
GET http://localhost:8080/api/v1/shops/{latitude}/{longitude}
```

Steps to run this application
1. Clone it
2. cd inside the repo
3. And hit `mvn spring-boot:run`
```
Which will run the application using default tomcat and on default port 8080.

```
While using postman you need to add two headers
```
Key: Accept Value: application/json
```
Key: Content-Type Value: application/json
```

For adding a new shop:
```
Url would be
```
http://localhost:8080/api/v1/shops
```
Method type should be POST
```
Request payload would be something like:
{
    "name": "name of the shop",
    "shopAddress": {
        "shopNumber": 1,
        "postCode": 411045
    }
}
```
Which will return
```
{
    "name": "name of the shop",
    "shopAddress": {
        "shopNumber": 1,
        "postCode": 411045
    },
    "latitude": 18.4648188,
    "longitude": 73.8483773
}
```

For fetching all available shops
```
Url would be
```
http://localhost:8080/api/v1/shops
```
Method type should be GET
```
Note: You need to add few shops before hitting this one otherwise you will get an empty array.
```
No request payload needed for this request
```
Which will return
```
[
    {
        "name": "one",
        "shopAddress": {
            "shopNumber": 1,
            "postCode": 411043
        },
        "latitude": 18.4648188,
        "longitude": 73.8483773
    },
    {
        "name": "two",
        "shopAddress": {
            "shopNumber": 1,
            "postCode": 411046
        },
        "latitude": 18.4028691,
        "longitude": 73.8536683
    },
    {
        "name": "three",
        "shopAddress": {
            "shopNumber": 1,
            "postCode": 411045
        },
        "latitude": 18.5642382,
        "longitude": 73.77694319999999
    }
]
```

For fetching a shop nearby given location
```
Url would be
```
http://localhost:8080/api/v1/shops/{latitude}/{longitude}
```
Method type should be GET
```
Request payload would be something like:
```
{
    "name": "name of the shop",
    "shopAddress": {
        "shopNumber": 1,
        "postCode": 411045
    }
}
```
Which will return
{
    "name": "name of the shop",
    "shopAddress": {
        "shopNumber": 1,
        "postCode": 411045
    },
    "latitude": 18.4648188,
    "longitude": 73.8483773
}
```

