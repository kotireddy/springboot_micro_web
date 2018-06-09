package com.springboot.micro.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomApplicationConfiguration {

	private static final Logger LOGGER = LoggerFactory.
			getLogger(CustomApplicationConfiguration.class);

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter httpMessageConverter = new
										MappingJackson2HttpMessageConverter();
		httpMessageConverter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(httpMessageConverter);
		return restTemplate;
	}

	public static Connector getTomcatConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}


}
