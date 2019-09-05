package cc.saxfore.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBResponse
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:21 PM
 * 创 建 人：wangjiang
 */
public class IBRequest<T> implements Serializable {

    protected IBHeader header;
    protected T body;

    public IBHeader getHeader() {
        return header;
    }

    public void setHeader(IBHeader header) {
        this.header = header;
    }



    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
