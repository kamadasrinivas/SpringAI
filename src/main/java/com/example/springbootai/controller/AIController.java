package com.example.springbootai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringAIWorkspace.service.AudioService;
import com.example.SpringAIWorkspace.service.ChatService;
import com.example.SpringAIWorkspace.service.ImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Spring AI", description = "Spring AI endpoints")
public class AIController {
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	AudioService audioService;
	
	@Autowired
	ImageService imageService;
	
	
	@Operation(summary = "ask ai", description = "Returns ai response")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "AI responded"),
        @ApiResponse(responseCode = "404", description = "AI has issues")
    })
	@GetMapping("/askai")
	public String getResponse(@RequestParam String prompt) {
		System.out.println("prompt sent");
		return chatService.getChatResponse(prompt);	
		
	}
	
	@GetMapping("/generate-image")
	public String getImage(@RequestParam String prompt) {
		System.out.println("image");
		return imageService.generateImage(prompt);	
		
	}
	
	
	@GetMapping("/generate-audio")
	public String getAudio(@RequestParam String prompt) {
		System.out.println("audio"+prompt);
		return audioService.convertTextToSpeech(prompt);	
		
	}
	

}
