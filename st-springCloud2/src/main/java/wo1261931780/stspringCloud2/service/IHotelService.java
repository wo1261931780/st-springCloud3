package wo1261931780.stspringCloud2.service;


import com.baomidou.mybatisplus.extension.service.IService;
import wo1261931780.stspringCloud2.pojo.Hotel;
import wo1261931780.stspringCloud2.pojo.PageResult;
import wo1261931780.stspringCloud2.pojo.RequestParams;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author junw
 */
public interface IHotelService extends IService<Hotel> {
	PageResult searchHotel(RequestParams requestParams) throws IOException;

	PageResult searchBooleanHotel(RequestParams requestParams);

	PageResult searchSortedHotel(RequestParams requestParams);

	Map<String, List<String>> filters(RequestParams requestParams) throws IOException;

	List<String> getSuggestion(String key) throws IOException;

	void deleteById(Long hotelId);

	void saveById(Long hotelId);

	void deleteHotelById(long hotelId) throws IOException;

	void insertOrUpdateHotelById(long hotelId) throws IOException;
}
