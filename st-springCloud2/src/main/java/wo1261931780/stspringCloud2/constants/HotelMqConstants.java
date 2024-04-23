package wo1261931780.stspringCloud2.constants;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:wo1261931780.stspringCloud3admin.constants
 *
 * @author liujiajun_junw
 * @Date 2024-04-14-46  星期二
 * @Description
 */
public class HotelMqConstants {
	// 交换机
	public static final String EXCHANGE_NAME = "hotel.topic";
	// 监听新增和修改队列
	public static final String INSERT_QUEUE_NAME = "hotel.insert.queue";
	// 监听删除队列
	public static final String DELETE_QUEUE_NAME = "hotel.delete.queue";
	// 新增或修改的RoutingKey
	public static final String INSERT_KEY = "hotel.insert";
	// 删除的RoutingKey
	public static final String DELETE_KEY = "hotel.delete";
}
