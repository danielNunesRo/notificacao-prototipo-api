package com.danielnunesro.notificacao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielnunesro.notificacao.model.Cuidador;

@Service
public class PrototipoCuidadorListener {
	
	private static final Logger logger = LoggerFactory.getLogger(PrototipoCuidadorListener.class);
	
	
	private EmailServiceImpl serviceEmail;
	
	@Autowired
	public PrototipoCuidadorListener(EmailServiceImpl serviceEmail) {
		super();
		this.serviceEmail = serviceEmail;
	}


	@RabbitListener(queues = "${rabbitmq.queue.prototipo.cuidador}")
	public void prototipoCuidador(Cuidador cuidador) {
		serviceEmail.sendSimpleMessage(cuidador.getEmail());
	}
	
}
