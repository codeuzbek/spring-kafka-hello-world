package dasturlash.uz;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleConsumer {

    @KafkaListener(topics = "orders")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.printf("Yangi habar keldi: partition=%d, offset=%d, key=%s, value=%s%n",
                record.partition(), record.offset(), record.key(), record.value());
    }
}