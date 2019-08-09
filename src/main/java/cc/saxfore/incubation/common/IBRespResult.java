package cc.saxfore.incubation.common;

import cc.saxfore.incubation.model.IBResponse;

/**
 * 项目名称：incubation
 * 类 名 称：IBRespResult
 * 类 描 述：TODO
 * 创建时间：2019/8/9 5:40 PM
 * 创 建 人：wangjiang
 */
public class IBRespResult {

    public static int SUCCESS = 200;

    public static int FAIL = 400;

    public static int ERROR = 500;

    public static <T> IBResponse<T> success() {
        return new IBResponse(SUCCESS, "", "");
    }

    public static <T> IBResponse<T> success(String msg) {
        return new IBResponse(SUCCESS, msg, "");
    }

    public static <T> IBResponse<T> success(T data) {
        return new IBResponse(SUCCESS, "", data);
    }

    public static <T> IBResponse<T> fail(String msg) {
        return new IBResponse(FAIL, msg, "");
    }

    public static <T> IBResponse<T> error(String msg) {
        return new IBResponse(ERROR, msg, "");
    }


}
