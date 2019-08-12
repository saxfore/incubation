package cc.saxfore.incubation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目名称：incubation
 * 类 名 称：IncubationApplication
 * 创建时间：2019/8/8 5:21 PM
 * 创 建 人：wangjiang
 * <p>
 * 开启事务管理: @EnableTransactionManagement
 * 不开启可能提示：<p color:red>synchronization is not active，JDBC Connection will not be managed by Spring </p>
 */
@SpringBootApplication
@EnableTransactionManagement
public class IncubationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncubationApplication.class, args);
    }

}
