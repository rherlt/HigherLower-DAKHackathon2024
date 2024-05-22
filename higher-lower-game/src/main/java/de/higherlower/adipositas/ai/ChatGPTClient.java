package de.higherlower.adipositas.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class ChatGPTClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatGPTClient.class);

    private final OpenAiChatClient chatClient;

    public ChatGPTClient(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getChatGPTResponse(String question, String questionName, String questionDescription) {

        UserMessage userMessage = new UserMessage(question);

//        var promptOptions = OpenAiChatOptions.builder()
//                .withFunctionCallbacks(List.of(new FunctionCallbackWrapper<>(
//                        questionName, // name
//                        questionDescription, // function description
//                        response -> Mon))) // function code
//                .build();

        String call = chatClient.call(question);
        System.err.println(call);

        return call;
    }

    public List<Generation> getChatGPTResponse(String question, Map<String, Object> args) {
        PromptTemplate promptTemplate = new PromptTemplate(question);

        Prompt prompt = promptTemplate.create(args);

        return chatClient.call(prompt).getResults();
    }
}
