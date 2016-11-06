# RIT EVT Admin App

Depdencies:
* MongoDB

The easiest way to get MongoDB is to just run it in a docker container and setup the correct ports. For example:
```sh
docker run --name admin-app -p 27017:27017 -d mongo
```

To build:
```sh
gradle build
```

To initialize the collections in the database:
```sh
gradle setup
```

To run: 

```sh
gradle runApp
```

