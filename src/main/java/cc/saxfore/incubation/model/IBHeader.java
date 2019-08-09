package cc.saxfore.incubation.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBHeader
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:24 PM
 * 创 建 人：wangjiang
 */
public class IBHeader implements Serializable {

    private String token;
    private String versionNo;
    private String sigaural;
    private long timestamp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getSigaural() {
        return sigaural;
    }

    public void setSigaural(String sigaural) {
        this.sigaural = sigaural;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
