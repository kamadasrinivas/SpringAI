package com.example.springbootai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringAIWorkspace.service.AudioService;
import com.example.SpringAIWorkspace.service.ChatService;
import com.example.SpringAIWorkspace.service.ImageService;

@RestController
public class AIController {
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	AudioService audioService;
	
	@Autowired
	ImageService imageService;
	
	@GetMapping("/askai")
	public String getResponse(@RequestParam String prompt) {
		System.out.println("Hello");
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
