# springBootDockerTomcatMongodb

Deploy Your Spring Boot WAR to a remote Tomcat Server running in a Docker Container and Container Linked to MongoDB

The demo application uses a REST Controller to respond to mapped URL requests and stores its visitor page count via logging to MongoDB whose value can then be retrieved via another URL mapping. The project concentrates on deploying the application on Docker Containers and not necessarily the application code; this is the primary goal of the Tutorial. 

Covers how to perform container linking via a docker compose YAML file and the docker compose commands (Version 1). Docker Compose will start 3 Containers; Tomcat, MongoDB and Firefox at the correct IP address, port and address bar URL so that you don’t even have to start your browser or enter anything!

All you need to do once you git clone this repo is execute "docker-compose up" from the root project directory to have the environment
re-produced on your docker host.

You can follow along by watching my YouTube Tutorial which goes through the entire process here ...

"Deploy Spring Boot to Tomcat MongoDB Docker Containers"  https://youtu.be/XojJV0A3cBw

===================================================

Subscribe to MVP Java ...
https://www.youtube.com/c/MVPJava?sub_confirmation=1

Follow me ...

Website:  http://www.mvpjava.com 

Google+ : http://bit.ly/1Jsnnfj 

Facebook: https://www.facebook.com/mvpjava 

Twitter : https://twitter.com/mvpjava
