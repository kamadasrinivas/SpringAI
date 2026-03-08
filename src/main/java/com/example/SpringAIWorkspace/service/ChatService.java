package com.example.SpringAIWorkspace.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.prompt.Prompt;

@Service
public class ChatService {
	
	ChatModel chatModel;
	public ChatService(ChatModel chatModel) {
		
		this.chatModel = chatModel;
	}
	
	public String getChatResponse(String prompt) {
		
		ChatResponse response = chatModel.call(
				
				new Prompt(prompt,
						OpenAiChatOptions.builder()
						.model("gpt-4o")
						.maxTokens(150)
						.temperature(0.1)
						.build()
						));
				//)); 
		
		  System.out.println(response);
		return response.getResult().getOutput().getText();
				
				
	}

}
