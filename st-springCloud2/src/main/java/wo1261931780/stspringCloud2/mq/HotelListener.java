package wo1261931780.stspringCloud2.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wo1261931780.stspringCloud2.constants.HotelMqConstants;
import wo1261931780.stspringCloud2.service.impl.HotelService;

import java.io.IOException;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:wo1261931780.stspringCloud2.mq
 *
 * @author liujiajun_junw
 * @Date 2024-04-15-11  星期二
 * @Description
 */
@Component
public class HotelListener {
	@Autowired
	private HotelService hotelService;

	/**
	 * 监听mq的hotel insert消息
	 *
	 * @param hotelId hotelId
	 */
	@RabbitListener(queues = HotelMqConstants.INSERT_QUEUE_NAME)
	public void listenHotelInsertOrUpdate(long hotelId) throws IOException {
		hotelService.insertOrUpdateHotelById(hotelId);

	}

	@RabbitListener(queues = HotelMqConstants.DELETE_QUEUE_NAME)
	public void listenHotelDelete(long hotelId) throws IOException {
		hotelService.deleteHotelById(hotelId);
	}
}
