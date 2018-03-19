[![Build Status](https://travis-ci.org/erwindev/simpleshift.svg?branch=master)](https://travis-ci.org/erwindev/simpleshift)
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

## Docker build and push
```
$ docker build -t ealberto/simpleshift .
$ docker push ealberto/simpleshift
```

## Deploying in OpenShift via Minishift

Redhat provides are real easy way to run OpenShift locally using Minishift.  Minishift is a single-node OpenShift cluster running inside a virtual machine.

To install Minishift, follow the[directions](https://docs.openshift.org/latest/minishift/getting-started/installing.html)in this installation guide.  As a note, I'm running these examples in MacOSX but I use VirtualBox as my VM driver.  

```
$ minishift start --vm-driver=virtualbox

```

### Accessing to the OpenShift CLI (oc)
```
$ minishift oc-env
$ eval $(minishift oc-env)

```

### Deploying the application to OpenShift
To deploy the application, you will need to set a few environment variables.  Please copy `openshift.env.template` into another `openshift.env` and update the variables accordingly.
Please note that we are using a Docker image (ealberto/simpleshift) hosted in Dockerhub to create the application.  So, before you can run the following command, please make sure you have built your docker image.
```
$ oc new-app ealberto/simpleshift --env-file=openshift.env
$ oc expose svc/simpleshift

```

### Access the config settings
```
$ open http://simpleshift-myproject.192.168.99.101.nip.io/
```

### Deleting the application in OpenShift                     
```                                                           
$ oc delete all --selector app=simpleshift                  
```                                        

### Pushing to Artifactory
```
$ gradle -Dorg.ajoberstar.grgit.auth.username='xxxxxxx' -Dorg.ajoberstar.grgit.auth.password='xxxxxxxx' candidate
```                   