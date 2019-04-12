FROM tomcat:8.5

RUN apt-get update && \
  apt-get install -y \
    net-tools \
    tree \
    vim && \
  rm -rf /var/lib/apt/lists/* && apt-get clean && apt-get purge

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh
COPY pkg/HelloWorld.war /usr/local/tomcat/webapps/HelloWorld.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
