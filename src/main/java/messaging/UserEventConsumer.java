package messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dto.UserEvent;

@Service
public class UserEventConsumer {
	private static final Logger logger = LoggerFactory.getLogger(UserEventConsumer.class);

	public void consumeUsserEvent(UserEvent event) {
		logger.info("Evento recebido do RabbitMQ:{} ", event);
		// SIMULAR PROCESSAMENTO DE EVENNTO
		processEvent(event);

	}

	private void processEvent(UserEvent event) {
		try {
			Thread.sleep(1000);
			switch (event.getType()) {
			case "CREATED":
				logger.info("Processando criação de usuario:{} ", event.getUserEmail());
				break;
			case "UPDATE":
				logger.info("Processando atualização do usuario:{}", event.getUserEmail());
				break;
			case "DELETED":
				logger.info("Processando execluão de usuario: {}", event.getUserEmail());
				break;
			}

			logger.info("Evento processando com sucesso:{}", event.getType());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.error("Erro ao processar evento:{}", e.getMessage());
		} catch (Exception e) {
			logger.error("Erro ao processar evento: {}",e.getMessage());

		}

	}
}
