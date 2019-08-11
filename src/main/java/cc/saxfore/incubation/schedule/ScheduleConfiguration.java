package cc.saxfore.incubation.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目名称：incubation
 * 类 名 称：ScheduleConfiguration
 * 创建时间：2019/8/11 8:01 PM
 * 创 建 人：wangjiang
 * 类描述：EnableScheduling开启定时任务；EnableAsync开启异步任务
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ScheduleConfiguration {

}
