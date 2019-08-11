package cc.saxfore.incubation.repository;

import cc.saxfore.incubation.entity.IBUser;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：IBUserNativeRepository
 * 类 描 述：TODO
 * 创建时间：2019/8/11 2:18 PM
 * 创 建 人：wangjiang
 */
@Repository
public class IBUserNativeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<IBUser> queryUserList(String username, String password) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from IBUser");
        sql.append("");
        sql.append("");
        sql.append("");
        sql.append("");
        Query nativeQuery = entityManager.createNativeQuery(sql.toString())
                .setParameter("username", username)
                .setParameter("password", password);
        List<IBUser> userList = nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(IBUser.class)).getResultList();
        return userList;
    }

}
