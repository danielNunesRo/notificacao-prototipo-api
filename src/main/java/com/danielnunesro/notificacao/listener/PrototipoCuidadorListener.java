package com.danielnunesro.notificacao.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.danielnunesro.notificacao.model.Cuidador;

@Component
public class PrototipoCuidadorListener {
	
	private static final Logger logger = LoggerFactory.getLogger(PrototipoCuidadorListener.class);
	
	@RabbitListener(queues = "${rabbitmq.queue.prototipo.cuidador}")
	public void prototipoCuidador(Cuidador cuidador) {
		logger.info("Mensagem do Protótipo Cuidador recebida: {}", cuidador.getName());
		System.out.println(cuidador.getName());
		System.out.println(cuidador.getCpf());
		System.out.println(cuidador.getEmail());
	}
	
}
