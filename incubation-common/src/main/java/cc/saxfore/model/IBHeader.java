package cc.saxfore.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBHeader
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:24 PM
 * 创 建 人：wangjiang
 */
public class IBHeader implements Serializable {

    private String userId;
    private String versionNo;
    private String signature;
    private long timestamp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
