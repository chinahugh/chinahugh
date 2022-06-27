
docker run -d --name zookeeper -p 2181:2181 -it wurstmeister/zookeeper

docker run -d --name kafka -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.0.102:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.0.102:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 wurstmeister/kafka

docker exec -it kafka   /bin/bash

#单机方式：创建一个主题
bin/kafka-topics.sh --create --zookeeper 192.168.0.102:2181 --replication-factor 1 --partitions 3 --topic mykafka
#运行一个生产者
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic mykafka


kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mykafka --from-beginning