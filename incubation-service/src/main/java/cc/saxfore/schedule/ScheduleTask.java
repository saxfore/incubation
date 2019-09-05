package cc.saxfore.schedule;

import cc.saxfore.entity.IBUser;
import cc.saxfore.service.IBUserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：ScheduleTask
 * 类 描 述：TODO
 * 创建时间：2019/8/11 8:05 PM
 * 创 建 人：wangjiang
 */
@Component
public class ScheduleTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
    IBUserService userService;

    /**
     * 每分钟执行一次
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void findDisableUsers() {
        log.info("ScheduleTask findDisableUsers ...");
        long beginTime = new Date().getTime();

        List<IBUser> userList = userService.listAll();
        log.info("ScheduleTask findDisableUsers 查询结果：{}", new Gson().toJson(userList));

        long endTime = new Date().getTime();
        log.info("ScheduleTask findDisableUsers 执行时间：{}ms", (endTime - beginTime));
    }


}
