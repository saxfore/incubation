package cc.saxfore.incubation.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 项目名称：incubation
 * 类 名 称：MapperConfiguration
 * 类 描 述：TODO
 * 创建时间：2019/8/12 5:21 PM
 * 创 建 人：wangjiang
 * 注意：cc.saxfore.incubation.mapper.** 不可识别; 最后一个路径必须明确: cc.saxfore.incubation.**.mapper
 * 说明：@MapperScan(basePackages = {"cc.saxfore.incubation.mapper"})和 {@link IBUserMapper#@Mapper}意义相同
 */
@Configuration
@MapperScan(basePackages = {"cc.saxfore.incubation.mapper"})
public class MapperConfiguration {

}
