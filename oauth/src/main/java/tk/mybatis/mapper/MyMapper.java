package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Description:
 *  不能被springboot扫描到
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 12:12
 */
public interface  MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
