SET message=user.xml
call docker cp messages/%message% kafka:/%message%
call docker exec -it kafka /bin/bash -c "cat %message% | tr -d '\r\n' | kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic-user"