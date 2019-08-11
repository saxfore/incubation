package cc.saxfore.incubation.service;

import cc.saxfore.incubation.entity.IBUser;

import java.util.List;
import java.util.Optional;

/**
 * 项目名称：incubation
 * 类 名 称：IBUserService
 * 类 描 述：TODO
 * 创建时间：2019/8/9 6:24 PM
 * 创 建 人：wangjiang
 */
public interface IBUserService {

    IBUser save(IBUser ibUser);

    List<IBUser> saveAll(List<IBUser> ibUsers);

    Optional<IBUser> findById(String id);

    boolean existsById(String id);

    List<IBUser> findAll();

    List<IBUser> findAllById(List<String> ids);

    long count();

    void deleteById(String id);

    void delete(IBUser ibUser);

    void deleteAll(List<IBUser> ibUsers);

    void deleteAll();

    IBUser findByUsernameAndPassword(String username, String password);

    List<IBUser> findUserListByJpa();

    List<IBUser> findUserListByNative();

}
