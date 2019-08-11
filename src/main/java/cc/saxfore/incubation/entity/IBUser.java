package cc.saxfore.incubation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBUser
 * 类 描 述：TODO
 * 创建时间：2019/8/9 6:12 PM
 * 创 建 人：wangjiang
 */
@Entity
@Table(name = "IB_User")
public class IBUser implements Serializable {

    @Id
    private String id;
    private String username;
    private String password;
    private long delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(long delFlag) {
        this.delFlag = delFlag;
    }
}
