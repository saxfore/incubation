package cc.saxfore.incubation.common;

import cc.saxfore.incubation.model.IBResponse;
import com.google.gson.Gson;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    public static <T> void success(HttpServletResponse response, String msg) throws IOException {
        if (response != null) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding("UTF-8");
            PrintWriter responseWriter = response.getWriter();
            responseWriter.print(new Gson().toJson(success(msg)));
            responseWriter.flush();
            responseWriter.close();
        }
    }

    public static <T> void success(HttpServletResponse httpServletResponse, T data) throws IOException {
        if (httpServletResponse != null) {
//            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter responseWriter = httpServletResponse.getWriter();
            responseWriter.print(new Gson().toJson(success(data)));
            responseWriter.flush();
            responseWriter.close();
        }
    }

    public static void fail(HttpServletResponse response, String msg) throws IOException {
        if (response != null) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding("UTF-8");
            PrintWriter responseWriter = response.getWriter();
            responseWriter.print(new Gson().toJson(fail(msg)));
            responseWriter.flush();
            responseWriter.close();
        }
    }
}
