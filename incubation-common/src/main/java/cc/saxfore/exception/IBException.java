package cc.saxfore.exception;

/**
 * 项目名称：incubation
 * 类 名 称：IBException
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:54 AM
 * 创 建 人：wangjiang
 */
public class IBException extends RuntimeException {

    private int code;
    private String msg;

    public IBException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public IBException(Throwable cause, int code, String msg) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public IBException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String msg) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public IBException(IBExceptionEnum exp) {
        super(exp.getMsg());
        this.code = exp.getCode();
        this.msg = exp.getMsg();
    }

}
