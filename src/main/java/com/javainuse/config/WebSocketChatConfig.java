package com.javainuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketChatConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocketApp").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// ampq프로토콜연결 : 5672, stomp 프로토콜 연결 61613
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableStompBrokerRelay("/topic")
				.setRelayHost("127.0.0.1").setRelayPort(61613).setClientLogin("admin")
				.setClientPasscode("rladydtn76");

	}
}
