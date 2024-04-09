package com.danielnunesro.notificacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
	
	@Autowired
    private JavaMailSender emailSender;
	
	String mensagem = "Olá, \n" +
            "Estamos muito felizes em receber sua inscrição para fazer parte da nossa plataforma como cuidador! \n" +
            "Queremos expressar nosso profundo reconhecimento pela importância da profissão de cuidador. \n" +
            "Entendemos o valor e a dedicação que você traz para aqueles que precisam de cuidados. \n" +
            "Nossa prioridade é garantir a segurança e o bem-estar tanto dos cuidadores quanto dos que necessitam de cuidados. \n" +
            "Por isso, estamos analisando cuidadosamente o seu cadastro para garantir a melhor experiência para todos. \n" +
            "Em breve entraremos em contato para agendar uma entrevista e discutir mais detalhes sobre sua participação na nossa plataforma. \n" +
            "Agradecemos novamente por querer fazer parte da nossa comunidade e contribuir para o cuidado e o bem-estar das pessoas. \n" +
            "Atenciosamente, \n" +
            "Equipe da Startup Cuidadores & Cuidados.";

	
	 	public void sendSimpleMessage(String to) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("noreply@cuidarbem.com"); 
	        message.setTo(to);
	        message.setSubject("Obrigado Por Se Inscrever! Estamos Avaliando Seu Cadastro como Cuidador");
	        message.setText(mensagem);
	        emailSender.send(message);
	    }
	
}
