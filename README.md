# About
A sample Spring Boot 3 and Infinispan integration.

## Frameworks
- Spring Boot 3.0.4
- Infinispan 14.0.7.Final

## Starting Infinispan
```
$ docker pull infinispan/server:14.0.2.Final

$ docker run -p 11222:11222 -e USER="admin" -e PASS="password" infinispan/server:14.0.2.Final
```

## Infinispan Configuration
We are using below XML configuration for setting up Infinispan cache with an index.
```xml
<?xml version="1.0"?>
<distributed-cache name="user-cache" owners="1" mode="SYNC" statistics="true">
    <encoding>
        <key media-type="application/x-protostream"/>
        <value media-type="application/x-protostream"/>
    </encoding>
    <locking isolation="REPEATABLE_READ"/>
    <memory storage="OFF_HEAP"/>
    <indexing enabled="true">
        <indexed-entities>
            <indexed-entity>user.User</indexed-entity>
        </indexed-entities>
    </indexing>
</distributed-cache>
```

## How to Test
Create a new data in a cache store
```
$ curl -kv http://localhost:8080/add-user?name=lele&age=14&address=Jogja
{"name":"lele","age":14,"address":"Jogja"} 
```

Get the data from a cache store
```
$ curl -kv http://localhost:8080/get-user?name=lele
{"name":"lele","age":14,"address":"Jogja"} 
```

Find cities using Fuzzy search. For this sample, we are using the word `Jogjon`, but application is able to give `Jogja` as result. 
```
$ curl -kv "http://localhost:8080/find-address?address=Jogjon
{"name":"lele","age":14,"address":"Jogja"} 
```