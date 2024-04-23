package wo1261931780.stspringCloud3admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:wo1261931780.stspringCloud3admin.pojo
 *
 * @author liujiajun_junw
 * @Date 2024-04-14-45  星期二
 * @Description
 */
@Data
@TableName("tb_hotel")
public class Hotel {
	@TableId(type = IdType.INPUT)
	private Long id;
	private String name;
	private String address;
	private Integer price;
	private Integer score;
	private String brand;
	private String city;
	private String starName;
	private String business;
	private String longitude;
	private String latitude;
	private String pic;
}
