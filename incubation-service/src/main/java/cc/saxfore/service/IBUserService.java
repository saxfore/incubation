package cc.saxfore.service;

import cc.saxfore.entity.IBUser;

import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/8/12 5:46 PM
 * 创 建 人：wangjiang
 */
public interface IBUserService {


    int deleteByPrimaryKey(String id);

    int insert(IBUser record);

    int insertOrUpdate(IBUser record);

    int insertOrUpdateSelective(IBUser record);

    int insertSelective(IBUser record);

    IBUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IBUser record);

    int updateByPrimaryKey(IBUser record);

    int updateBatch(List<IBUser> list);

    int batchInsert(List<IBUser> list);

    IBUser findByUsernameAndPassword(String username, String password);

    List<IBUser> listAll();
}
