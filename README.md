# RIT EVT Admin App

Depdencies:
* MongoDB 3.2+
* Firefox 48+
* geckodriver 11.0+

The easiest way to get MongoDB is to just run it in a docker container and setup the correct ports. For example:
```sh
docker run --name admin-app -p 27017:27017 -d mongo
```

Make sure `geckodriver` is in your `PATH` environment variable. 

To build:
```sh
gradle build
```

A few things need to be done before the app can be run:

```sh
export EVTPASS=<enter evt wiki password here>
gradle setup
```

To run: 

```sh
gradle runApp
```

To use:
* Open a browser and navigate to `localhost:8080/api/task`. A Firefox window will pop up, automatically navigate to the member add webpage, and take a screenshot and download it (in the browser used to navigate to the endpoint)

Notes:
* This is a work in progress! Things are very rough now. 

