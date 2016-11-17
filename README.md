# Microservices Demo
Simple microservices example with Java EE 7 and microprofile.

## Description
This project is the code for the [blog post](https://vasouv.wordpress.com/2016/11/16/simple-microservices-with-payara-micro-pt-2-complete-example/) I wrote. It's a Maven project containing sub-modules. Each sub-module is the microservice required to run. In a nutshell; suppose we're a nuclear plant and we're monitoring the temperatures of our two reactors. Along with the temperatures, we want to see the supervisor's name and the temperature they verified.

## Sub-modules
Apollo and Artemis are the hypothetical reactors that expose their temperatures (just a random integer) at their REST endpoints.

Poseidon is another microservice that retrieves Apollo's temperature and adds the supervisor's name along with a timestamp.

Zeus is the user interface that gets the reactors' temperatures and the supervisor's name from Poseidon. It's written in JSF and Primefaces.

## Run
You need Payara Micro to run the microservices. In a directory, put the Payara Micro jar and the generated .war files of the microservices.
Deploy like so:
- java -jar payaramicro.jar --deploy apollo.war --port 8383
- java -jar payaramicro.jar --deploy artemis.war --port 8484
- java -jar payaramicro.jar --deploy poseidon.war --port 8585
- java -jar payaramicro.jar --deploy zeus.war --port 8989

Go to localhost:8989/zeus and that's it.

## Todo
The project isn't finished. It needs work and I will continue to add functionallity and make it better.
