package arile.toy.crypto_automation.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackHttpClient {
    // 메시지 날림 : send
    public void send(String message) {
        try{
            Slack instance = Slack.getInstance();
            // 요청을 보낼 data : payload
            Payload payload = Payload.builder()
                    .text(message)
                    .build();

            instance.send("https://hooks.slack.com/services/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", payload); // webhook uri
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
