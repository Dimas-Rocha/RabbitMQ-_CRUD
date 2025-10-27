package config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String EXCHANGE_NAME = "user.exchange";
	public static final String QUEUE_NAME = "user.queue";
	public static final String ROUTING_KEY = "user.routingkey";
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
		
	}
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME,true);
	}
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder
				.bind(queue)
				.to(exchange)
				.with(ROUTING_KEY);
	}
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	@Bean
	public AmqpTemplate ampTemplate(ConnectionjFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplayte(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
}
