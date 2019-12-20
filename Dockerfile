FROM openjdk:8
ADD jfinal-demo-release.zip /app.zip
RUN unzip app.zip
CMD /jfinal-demo/jfinal.sh start