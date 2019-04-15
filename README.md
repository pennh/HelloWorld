# HelloWorld Java Web App  

Simple java project to build a war file to be deployed on a Tomcat server.

## Build and test
> mvn package
Produce a target/HelloWorld.war.

## Source Url Mapping
Source | Url
--- | ---
src/main/java/Hello.java | localhost:8080/demo/Hello
src/main/webapp/index.jsp | localhost:8080/demo/index.jsp

## Build image
Build the docker image:
> mkdir pkg
> cp target/HelloWorld.war pkg/

> docker build . -t hello-world

## Run
docker run --rm -p 8080:8080 -t hello-world

## Browser Urls:
http://localhost:8080/HelloWorld/Hello
http://localhost:8080/HelloWorld/index.jsp

## Run Jenkins in container
# Build the following docker image on my local computer:
> cd DockerInDocker/Dockerfile
> docker build . -t my-docker

# Run jenkins in container with the image I created: 
> docker run -u root -p 8080:8080 --name myjenkins2 p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock my-docker
