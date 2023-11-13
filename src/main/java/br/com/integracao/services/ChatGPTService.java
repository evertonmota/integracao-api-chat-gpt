package br.com.integracao.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.integracao.vo.request.ChatGPTRequest;
import br.com.integracao.vo.response.ChatGPTResponse;

@Service
public class ChatGPTService {

	private Logger logger = Logger.getLogger(ChatGPTService.class.getName());
	
	@Value("${openai.model}")
	private String model;
	
	@Value("${openai.api.url}")
	private String url;
	
	@Autowired
	RestTemplate template;
	
	public Object chat(String prompt) throws JsonProcessingException {
			
		logger.info("Stating Prompt");
		ChatGPTRequest request = new ChatGPTRequest(model, prompt);
		
		String json = new ObjectMapper().writeValueAsString(request);

		logger.info(json);
		ChatGPTResponse response =  template.postForObject(url, request, ChatGPTResponse.class);
		
		
		return response;
	}
}
