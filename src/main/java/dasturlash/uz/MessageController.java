package dasturlash.uz;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // POST /api/messages?key=order-1     (body - xabar matni)
    @PostMapping
    public String send(@RequestParam String key, @RequestBody String message) {
        kafkaTemplate.send("orders", key, message);
        return "Xabar yuborildi";
    }
}