package wo1261931780.stspringCloud2.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wo1261931780.stspringCloud2.constants.HotelMqConstants;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:wo1261931780.stspringCloud2.config
 *
 * @author liujiajun_junw
 * @Date 2024-04-15-00  星期二
 * @Description
 */
@Configuration
public class MqConfig {


	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(HotelMqConstants.EXCHANGE_NAME, true, false);
	}

	@Bean
	public Queue insertQueue() {
		return new Queue(HotelMqConstants.INSERT_QUEUE_NAME, true);
	}
	@Bean
	public Queue deleteQueue() {
		return new Queue(HotelMqConstants.DELETE_QUEUE_NAME, true);
	}
	@Bean
	public Binding insertQueueBinding(TopicExchange topicExchange) {
		return BindingBuilder.bind(insertQueue()).to(topicExchange).with(HotelMqConstants.INSERT_KEY);
	}
	@Bean
	public Binding deleteQueueBinding(TopicExchange topicExchange) {
		return BindingBuilder.bind(deleteQueue()).to(topicExchange).with(HotelMqConstants.DELETE_KEY);
	}
}
