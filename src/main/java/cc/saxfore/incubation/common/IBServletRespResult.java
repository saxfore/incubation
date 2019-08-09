package cc.saxfore.incubation.common;

import cc.saxfore.incubation.model.IBResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 项目名称：incubation
 * 类 名 称：IBServletRespResult
 * 类 描 述：TODO
 * 创建时间：2019/8/9 5:55 PM
 * 创 建 人：wangjiang
 */
public class IBServletRespResult {

    public static void success(HttpServletResponse httpServletResponse, IBResponse ibResponse) throws IOException {
        if (httpServletResponse != null) {
            httpServletResponse.setCharacterEncoding("utf-8");
            PrintWriter responseWriter = httpServletResponse.getWriter();
            responseWriter.print(ibResponse);
            responseWriter.flush();
            responseWriter.close();
        }
    }

}
