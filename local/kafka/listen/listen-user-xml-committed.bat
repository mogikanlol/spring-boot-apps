call docker exec -it kafka /bin/bash -c "kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic-user-out --from-beginning --isolation-level=read_committed"