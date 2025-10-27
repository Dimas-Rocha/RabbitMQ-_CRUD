package messaging;

import static config.RabbitMQConfig.EXCHANGE_NAME;
import static config.RabbitMQConfig.ROUTING_KEY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import dto.UserEvent;

@Service
public class UserEventProducer {
	private static final Logger logger = LoggerFactory.getLogger(UserEventProducer.class);

	private RabbitTemplate rabbitTemplate;

	public static void sendUserEvent(UserEvent event) {
		try {
			rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, event);
			logger.info("Evento enviado para RabbitMQ: {}", event);

		} catch (Exception e) {
			logger.error("Erro ao enviar evento para RabbitMQ: {}", e.getMessage());
		}

	}

}
