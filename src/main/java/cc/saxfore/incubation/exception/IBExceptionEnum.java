package cc.saxfore.incubation.exception;

/**
 * 项目名称：incubation
 * 类 名 称：IBExceptionEnum
 * 类 描 述：TODO
 * 创建时间：2019/8/11 12:02 PM
 * 创 建 人：wangjiang
 */
public enum IBExceptionEnum {

    UserNotFound(501, "用户不存在"),
    UserIsForzen(502, "该用户已被冻结"),
    UserISRetistered(503, "用户名已被注册");

    private int code;
    private String msg;

    private IBExceptionEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
