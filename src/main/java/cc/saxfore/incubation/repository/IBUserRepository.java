package cc.saxfore.incubation.repository;

import cc.saxfore.incubation.entity.IBUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 项目名称：incubation
 * 类 名 称：IBUserRepository
 * 类 描 述：TODO
 * 创建时间：2019/8/9 6:23 PM
 * 创 建 人：wangjiang
 */
public interface IBUserRepository extends JpaRepository<IBUser, String> {
}