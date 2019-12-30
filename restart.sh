TomcatID=$(ps -ef |grep tomcat |grep -w 'tomcat'|grep -v 'grep'|awk 'NR==1{print $2}')
echo "tomcatId is ${TomcatID}"