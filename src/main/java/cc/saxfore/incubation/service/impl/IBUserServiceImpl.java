package cc.saxfore.incubation.service.impl;

import cc.saxfore.incubation.entity.IBUser;
import cc.saxfore.incubation.repository.IBUserRepository;
import cc.saxfore.incubation.service.IBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 项目名称：incubation
 * 类 名 称：IBUserService
 * 类 描 述：TODO
 * 创建时间：2019/8/9 6:24 PM
 * 创 建 人：wangjiang
 */
@Service
public class IBUserServiceImpl implements IBUserService {

    @Autowired
    IBUserRepository repository;

    @Override
    public IBUser save(IBUser ibUser) {
        return repository.save(ibUser);
    }

    @Override
    public List<IBUser> saveAll(List<IBUser> ibUsers) {
        return repository.saveAll(ibUsers);
    }

    @Override
    public Optional<IBUser> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public List<IBUser> findAll() {
        return repository.findAll();
    }

    @Override
    public List<IBUser> findAllById(List<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(IBUser ibUser) {
        repository.delete(ibUser);
    }

    @Override
    public void deleteAll(List<IBUser> ibUsers) {
        repository.deleteAll(ibUsers);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
        ;
    }

}
