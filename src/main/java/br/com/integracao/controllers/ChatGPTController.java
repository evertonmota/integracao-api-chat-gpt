package br.com.integracao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.integracao.services.ChatGPTService;

@RestController
@RequestMapping("/bot")
public class ChatGPTController {

	@Autowired
	private ChatGPTService service;
	
	@GetMapping(value = "/chat")
	public Object chat(@RequestParam ("prompt") String prompt) throws JsonProcessingException{
		return service.chat(prompt);
	}
	
}
