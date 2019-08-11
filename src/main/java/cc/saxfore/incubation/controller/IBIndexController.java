package cc.saxfore.incubation.controller;

import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.entity.IBUser;
import cc.saxfore.incubation.model.IBResponse;
import cc.saxfore.incubation.service.IBUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 项目名称：incubation
 * 类 名 称：IndexController
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:31 PM
 * 创 建 人：wangjiang
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class IBIndexController extends IBBaseController {
    private static final Logger log = LoggerFactory.getLogger(IBIndexController.class);

    @Autowired
    IBUserService userService;

    @GetMapping("/index")
    public IBResponse index(@RequestParam("username") String username, @RequestParam("password") String password) {
        log.info("username = [{}], password = [{}]", username, password);
        IBUser user = userService.findByUsernameAndPassword(username, password);
        return IBRespResult.success(user);
    }

}
