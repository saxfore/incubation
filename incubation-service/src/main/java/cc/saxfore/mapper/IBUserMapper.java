package cc.saxfore.mapper;

import cc.saxfore.entity.IBUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：${NAME}
 * 创建时间：2019/8/12 5:46 PM
 * 创 建 人：wangjiang
 * 说明：@Mapper和{@link MapperConfiguration#@MapperScan(basePackages={"cc.saxfore.incubation.mapper"})}意义相同
 */
//@Mapper
public interface IBUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(IBUser record);

    int insertOrUpdate(IBUser record);

    int insertOrUpdateSelective(IBUser record);

    int insertSelective(IBUser record);

    IBUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IBUser record);

    int updateByPrimaryKey(IBUser record);

    int updateBatch(List<IBUser> list);

    int batchInsert(@Param("list") List<IBUser> list);

    List<IBUser> listAll();

    IBUser findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}