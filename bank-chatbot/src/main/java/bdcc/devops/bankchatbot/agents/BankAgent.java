package bdcc.devops.bankchatbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class BankAgent {
    private final ChatClient chatClient;
    public BankAgent(ChatClient.Builder builder, ChatMemory chatMemory,
                     ToolCallbackProvider tools) {
        this.chatClient = builder.defaultSystem("""
                        Tu es un assistant bancaire. Utilise toujours les outils
                        pour consulter
                        les comptes et les transactions, ne devine jamais un
                        solde.
                        Avant un virement ou une transaction, rappelle le compte,
                        le montant et la devise.
                        Réponds en français.
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(tools)
                .build();
    }

    public String ask(String question) {
        return chatClient.prompt().user(question).call().content();
    }
}
