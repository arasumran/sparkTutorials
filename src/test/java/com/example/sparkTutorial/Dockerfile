FROM openjdk:11

ARG JAVA_VERSION=1.8.0
# define spark and hadoop versions
ENV SPARK_VERSION=3.3.1
ENV HADOOP_VERSION=3.3.1
USER 0

RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y krb5-user krb5-config libkrb5-dev && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
# download and install hadoop
RUN chown -R 1001110000:0 /opt && \
    chmod -R 775 /opt

USER 1001110000
RUN mkdir -p /opt && \
    cd /opt && \
    curl http://archive.apache.org/dist/hadoop/common/hadoop-${HADOOP_VERSION}/hadoop-${HADOOP_VERSION}.tar.gz | \
        tar -xz hadoop-${HADOOP_VERSION}/lib/native && \
    ln -s hadoop-${HADOOP_VERSION} hadoop && \
    echo Hadoop ${HADOOP_VERSION} native libraries installed in /opt/hadoop/lib/native

# download and install spark
RUN mkdir -p /opt && \
    cd /opt && \
    curl http://archive.apache.org/dist/spark/spark-${SPARK_VERSION}/spark-${SPARK_VERSION}-bin-hadoop3.tgz | \
        tar -zx && \
    ln -s spark-${SPARK_VERSION}-bin-hadoop3 spark && \
    echo Spark ${SPARK_VERSION} installed in /opt

# add scripts and update spark default config
ADD common.sh spark-master spark-worker /opt/spark/conf/
ADD spark-defaults.conf /opt/spark/conf/spark-defaults.conf

ENV SPARK_HOME="/opt/spark"  
ENV HADOOP_HOME="/opt/hadoop"  

ENV PATH="$SPARK_HOME/bin:$HADOOP_HOME/bin:$PATH"
ENV SPARK_DIST_CLASSPATH = $(/opt/hadoop/bin classpath)
