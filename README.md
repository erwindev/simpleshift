# Simple Shift

## Summary
This is a very simple application that will access the College App Tracker Config Server.  It contains a single controller that will display a value in the config files stored in the GIT server.

   
## Run the application

Before you can run this application, you will need to set some environment variables.  Feel free to copy the `env.current.template` into another file like `env.current` file and update the environment variables in that new file before sourcing it.  
  
```
$ source env.current
```  

Compile and create the executable jar file.

```
$ gradle assemble
```

Run the application.

```
$ java -jar build/libs/simpleshift.jar

```

## Access the test controller

```
$ curl http://localhost:8080/

```    
