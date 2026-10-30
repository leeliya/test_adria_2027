package bdcc.devops.bankchatbot.web.rest;

import bdcc.devops.bankchatbot.agents.BankAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ChatController {

    private final BankAgent agent;
    public ChatController(BankAgent agent) { this.agent = agent; }
    @GetMapping("/chat")
    public String chat(@RequestParam String question) { return
            agent.ask(question); }
}
