package de.higherlower.adipositas.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ChatGPTClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatGPTClient.class);

    private final OpenAiChatClient chatClient;

    private final Resource promptUserTemplate;

    public ChatGPTClient(OpenAiChatClient chatClient, @Value("classpath:/prompts/user-question.st") Resource promptUserTemplate) {
        this.chatClient = chatClient;
        this.promptUserTemplate = promptUserTemplate;
    }

    public String getChatGPTResponse(String question) {
        String answer = chatClient.call(question);
        LOGGER.info("Die Antwort von AI ist: {}", answer);

        return answer;
    }

    public List<Generation> getChatGPTResponse(String question, Map<String, Object> args) {
        PromptTemplate promptTemplate = new PromptTemplate(question);

        Prompt prompt = promptTemplate.create(args);

        return chatClient.call(prompt).getResults();
    }

    public AiKalorienAntwort getChatGPTResponse(String first, String second) {
        BeanOutputParser<AiKalorienAntwort> outputParser = new BeanOutputParser<>(AiKalorienAntwort.class);

        PromptTemplate promptTemplate = new PromptTemplate(promptUserTemplate,
                Map.of("first", first, "second", second, "context", "",  "format", outputParser.getFormat()));

        Prompt prompt = promptTemplate.create();

        AssistantMessage output = chatClient.call(prompt).getResult().getOutput();
        LOGGER.info("Antwort von AI ist: {}", output);

        return outputParser.parse(output.getContent());
    }


}
