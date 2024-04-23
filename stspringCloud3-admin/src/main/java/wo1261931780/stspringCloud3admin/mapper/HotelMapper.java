package wo1261931780.stspringCloud3admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wo1261931780.stspringCloud3admin.pojo.Hotel;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:wo1261931780.stspringCloud3admin.mapper
 *
 * @author liujiajun_junw
 * @Date 2024-04-14-46  星期二
 * @Description
 */
@Mapper
public interface HotelMapper extends BaseMapper<Hotel> {
	// 这里可能是版本的问题，必须要带上mapper注解，不然报错
}
