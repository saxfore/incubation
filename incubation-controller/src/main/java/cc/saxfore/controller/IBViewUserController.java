package cc.saxfore.controller;

import cc.saxfore.entity.IBUser;
import cc.saxfore.model.IBResponse;
import cc.saxfore.service.IBUserService;
import cc.saxfore.utils.IBRespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "web端操作用户信息的controller")
@CrossOrigin
@RestController
@RequestMapping("/view/user")
public class IBViewUserController extends IBBaseController {
    private static final Logger log = LoggerFactory.getLogger(IBViewUserController.class);

    @Autowired
    IBUserService userService;

    @ApiOperation(value = "查询用户", notes = "根据用户名和密码来查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")})
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public IBResponse get(@RequestParam("username") String username, @RequestParam("password") String password) {
        log.info("username = [{}], password = [{}]", username, password);
        IBUser user = userService.findByUsernameAndPassword(username, password);
        return IBRespResult.success(user);
    }

}
