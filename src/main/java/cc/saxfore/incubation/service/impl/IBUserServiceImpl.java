package cc.saxfore.incubation.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cc.saxfore.incubation.mapper.IBUserMapper;
import cc.saxfore.incubation.entity.IBUser;
import cc.saxfore.incubation.service.IBUserService;
/**
 * 项目名称：incubation
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/8/12 5:46 PM
 * 创 建 人：wangjiang
 */
@Service
public class IBUserServiceImpl implements IBUserService{

    @Resource
    private IBUserMapper iBUserMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return iBUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IBUser record) {
        return iBUserMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(IBUser record) {
        return iBUserMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(IBUser record) {
        return iBUserMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(IBUser record) {
        return iBUserMapper.insertSelective(record);
    }

    @Override
    public IBUser selectByPrimaryKey(String id) {
        return iBUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IBUser record) {
        return iBUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IBUser record) {
        return iBUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<IBUser> list) {
        return iBUserMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<IBUser> list) {
        return iBUserMapper.batchInsert(list);
    }

    @Override
    public IBUser findByUsernameAndPassword(String username, String password) {
        return iBUserMapper.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<IBUser> listAll() {
        return iBUserMapper.listAll();
    }


}
