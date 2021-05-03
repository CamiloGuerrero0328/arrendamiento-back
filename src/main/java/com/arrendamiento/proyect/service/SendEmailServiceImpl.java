package com.arrendamiento.proyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.arrendamiento.proyect.domain.*;

@Service
@Scope("singleton")
public class SendEmailServiceImpl {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendOpenAccount(String receptor, Inmueble inmueble) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		String mensaje = "Has creado un nuevo inmueble con id: "
				+ inmueble.getIdInmueble() + ", con tipo inmueble " + inmueble.getTipoInmueble()
				+ " Con direccion" + inmueble.getDireccion();

		simpleMailMessage.setTo(receptor);
		simpleMailMessage.setSubject("Creacion Inmueble #" + inmueble.getIdInmueble());
		simpleMailMessage.setText(mensaje);

		javaMailSender.send(simpleMailMessage);
	}
	
	public void notificationAvisoInmuebleArrendatario(String receptor, Proceso proceso) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		String mensaje = "Has aplicado al inmueble con ID: "
				+ proceso.getInmueble().getIdInmueble();

		simpleMailMessage.setTo(receptor);
		simpleMailMessage.setText(mensaje);

		javaMailSender.send(simpleMailMessage);
	}
	
	public void notificationAvisoInmuebleArrendador(String receptor, Proceso proceso) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		String mensaje = "Han aplicado a tu inmueble con ID: "
				+ proceso.getInmueble().getIdInmueble() + ", Y el cliente es: " + 
				proceso.getCliente().getNombreCliente();

		simpleMailMessage.setTo(receptor);
		simpleMailMessage.setText(mensaje);

		javaMailSender.send(simpleMailMessage);
	}

}
