package cc.saxfore.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 项目名称：incubation
 * 类 名 称：WebServletConfiguration
 * 类 描 述：TODO
 * 创建时间：2019/8/11 7:53 PM
 * 创 建 人：wangjiang
 */
@Configuration
@ServletComponentScan(basePackages = {"cc.saxfore.servlet.**"})
public class ServletConfiguration {

}
