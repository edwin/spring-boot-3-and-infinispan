# About
A sample Spring Boot 3 and Infinispan integration.

## Frameworks
- Spring Boot 3.0.4
- Infinispan 14.0.7.Final

## Starting Infinispan
```
$ docker pull infinispan/server:latest

$ docker run -p 11222:11222 infinispan/server
```

## Infinispan Configuration
We are using below XML configuration for setting up Infinispan cache for a 5 minutes session timeout.
```json
{
  "user-cache": {
    "distributed-cache": {
      "owners": "1",
      "mode": "SYNC",
      "statistics": true,
      "encoding": {
        "key": {
          "media-type":"application/x-java-serialized-object"
        },
        "value": {
          "media-type": "application/x-java-serialized-object"
        }
      },
      "locking": {
        "isolation": "REPEATABLE_READ"
      },
      "expiration": {
        "lifespan": "-1",
        "max-idle": "300000"
      }
    }
  }
}
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