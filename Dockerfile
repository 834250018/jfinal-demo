FROM openjdk:8
ADD jfinal-demo-release.zip /app.zip
RUN unzip app.zip
ENTRYPOINT ["/bin/bash", "/jfinal-demo/jfinal.d.sh","start"]