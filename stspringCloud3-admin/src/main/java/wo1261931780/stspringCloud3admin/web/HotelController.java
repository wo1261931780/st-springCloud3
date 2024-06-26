package wo1261931780.stspringCloud3admin.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wo1261931780.stspringCloud3admin.constants.HotelMqConstants;
import wo1261931780.stspringCloud3admin.pojo.Hotel;
import wo1261931780.stspringCloud3admin.pojo.PageResult;
import wo1261931780.stspringCloud3admin.service.IHotelService;

import java.security.InvalidParameterException;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:wo1261931780.stspringCloud3admin.web
 *
 * @author liujiajun_junw
 * @Date 2024-04-14-43  星期二
 * @Description
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {


	@Autowired
	private IHotelService hotelService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/{id}")
	public Hotel queryById(@PathVariable("id") Long id) {
		return hotelService.getById(id);
	}

	@GetMapping("/list")
	public PageResult hotelList(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "1") Integer size
	) {
		Page<Hotel> result = hotelService.page(new Page<>(page, size));

		return new PageResult(result.getTotal(), result.getRecords());
	}

	@PostMapping
	public void saveHotel(@RequestBody Hotel hotel) {
		// 新增酒店
		hotelService.save(hotel);
		// 发送MQ消息，尽量降低数据量，所以只用id
		// 其实消息体比较小，也是为了避免占用内存
		rabbitTemplate.convertAndSend(HotelMqConstants.EXCHANGE_NAME, HotelMqConstants.INSERT_KEY, hotel.getId());
	}

	@PutMapping()
	public void updateById(@RequestBody Hotel hotel) {
		if (hotel.getId() == null) {
			throw new InvalidParameterException("id不能为空");
		}
		hotelService.updateById(hotel);

		// 发送MQ消息
		rabbitTemplate.convertAndSend(HotelMqConstants.EXCHANGE_NAME, HotelMqConstants.INSERT_KEY, hotel.getId());
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		hotelService.removeById(id);

		// 发送MQ消息
		rabbitTemplate.convertAndSend(HotelMqConstants.EXCHANGE_NAME, HotelMqConstants.DELETE_KEY, id);
	}
}
