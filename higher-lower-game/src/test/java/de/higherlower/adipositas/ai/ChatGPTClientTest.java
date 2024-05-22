package de.higherlower.adipositas.ai;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.Generation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
class ChatGPTClientTest {

    @Autowired
    private ChatGPTClient chatGPTClient;

    @Test
    void getChatGPTResponse() {
        String chatGPTResponse = chatGPTClient.getChatGPTResponse("Was hat mehr Kalorien: Apfel oder Birne?", "", "");
        assertNotNull(chatGPTResponse);
    }

    @Test
    void testGetChatGPTResponse() {
        String question = "Was hat mehr Kalorien: {first} oder {second}?";
        Map<String, Object> args = Map.of("first", "Milch", "second", "Kefir");

        List<Generation> chatGPTResponse = chatGPTClient.getChatGPTResponse(question, args);

        Assertions.assertThat(chatGPTResponse).isNotNull().isNotEmpty();

        chatGPTResponse.forEach(r -> {
                    System.err.println(r);
                    System.err.println(r.getOutput());
                    System.err.println(r.getMetadata());

                }
        );
    }
}