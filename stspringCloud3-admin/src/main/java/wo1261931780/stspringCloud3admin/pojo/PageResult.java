package wo1261931780.stspringCloud3admin.pojo;

import lombok.Data;

import java.util.List;

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
public class PageResult {
	private Long total;
	private List<Hotel> hotels;

	public PageResult() {
	}

	public PageResult(Long total, List<Hotel> hotels) {
		this.total = total;
		this.hotels = hotels;
	}
}
